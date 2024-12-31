package com.spop.poverlay.sensor.v1

import android.os.IBinder
import timber.log.Timber

/**
 * At low power values the sensor can sometimes send huge spikes in values returned
 *
 * These spikes are referred to as "Spurious Readings" in this implementation, and rejected
 */
class PowerSensor(binder: IBinder) : Sensor(Command.GetPowerRepeating, binder) {
    override fun mapValue(value: Float) = value / 100
}