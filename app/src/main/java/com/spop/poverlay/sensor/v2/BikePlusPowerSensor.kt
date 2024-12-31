package com.spop.poverlay.sensor.v2

import android.os.IBinder

/**
 * At low power values the sensor can sometimes send huge spikes in values returned
 *
 * These spikes are referred to as "Spurious Readings" in this implementation, and rejected
 */
class BikePlusPowerSensor(binder: IBinder) : BikePlusSensor(Command.GetPowerRepeating, binder) {
    override fun mapValue(value: Float) = value / 100
}