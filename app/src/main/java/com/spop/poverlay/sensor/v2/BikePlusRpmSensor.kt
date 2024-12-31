package com.spop.poverlay.sensor.v2

import android.os.IBinder

class BikePlusRpmSensor(binder: IBinder) : BikePlusSensor(Command.GetRpmRepeating, binder) {
    override fun mapValue(value: Float) = value
}