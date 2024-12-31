package com.spop.poverlay.sensor.v2

import android.os.IBinder
import android.os.Parcel
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import java.util.concurrent.atomic.AtomicBoolean
import kotlin.concurrent.thread

data class BikeDataHelper(val bikeData: BikeData, val command: Command) {
    val value: Float
        get() {
            return when (command) {
                Command.GetRpmRepeating -> bikeData.rpm.toFloat()
                Command.GetPowerRepeating -> bikeData.power.toFloat()
                Command.GetResistanceRepeating -> bikeData.targetResistance.toFloat()
            }
        }
}

/**
 * Counts consecutive errors, and throws an exception if the limit is reached
 * This is used to stop the sensor if it is not responding.
 * While testing, the sensor would sometimes stop responding randomly, and this was a way to handle that
 * It is not a perfect solution, but it is better than nothing.
 */
class ConsecutiveErrorCounter(private val limit: Int = 5) {
    private var consecutiveErrors = 0

    fun increment() {
        consecutiveErrors++
        if (consecutiveErrors >= limit) {
            throw Exception("Too many consecutive errors")
        }
    }

    fun reset() {
        consecutiveErrors = 0
    }
}

private const val READ_DELAY = 100L

/**
 * Handles the flow of sending a message to the Sensor Service linked via Binder
 * And receiving a result on a HandlerThread
 */
abstract class BikePlusSensor(private val command: Command, private val binder: IBinder) {
    private val mutableSensorValue = MutableSharedFlow<Float>(
        replay = 2,
        extraBufferCapacity = 512,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )

    private val errorCounter = ConsecutiveErrorCounter()

    /**
     * Exposes any exceptions that occur downstream, use with retry/retryWhen
     */
    val sensorValue = mutableSensorValue
        .asSharedFlow()

    private var threadRunning = AtomicBoolean(false)

    fun start() {
        thread {
            threadRunning.set(true)
            while (threadRunning.get()) {
                try {
                    val parcel = Parcel.obtain()
                    val parcel2 = Parcel.obtain()
                    parcel.writeInterfaceToken(SERVICE_ACTION)
                    binder.transact(14, parcel, parcel2, 0)
                    parcel2.readException()
                    // Skip the first integer
                    parcel2.readInt()
                    val bikeData = BikeData.CREATOR.createFromParcel(parcel2)
                    mutableSensorValue.tryEmit(mapValue(BikeDataHelper(bikeData, command).value))
                    parcel.recycle()
                    parcel2.recycle()
                    errorCounter.reset()
                    Thread.sleep(READ_DELAY)
                } catch (e: Exception) {
                    try {
                        errorCounter.increment()
                    } catch (e: Exception) {
                        stop()
                        throw e
                    }
                }
            }
        }
    }

    private fun stop() {
        threadRunning.set(false)
    }


    protected abstract fun mapValue(value: Float): Float
}