package com.spop.poverlay.sensor.v1

import android.os.Parcel
import android.os.Parcelable

class DataParcel() : Parcelable {
    constructor(parcel: Parcel) : this() {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DataParcel> {
        override fun createFromParcel(parcel: Parcel): DataParcel {
            return DataParcel(parcel)
        }

        override fun newArray(size: Int): Array<DataParcel?> {
            return arrayOfNulls(size)
        }
    }
}