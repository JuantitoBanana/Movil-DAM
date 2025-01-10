package com.example.ejercicio15_votoselecciones

import android.os.Parcel
import android.os.Parcelable

class Dato (var dato:String?) : Parcelable {
    constructor(parcel: Parcel) : this(parcel.readString()){
    }
    override fun toString(): String {
        return dato.toString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(dato)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Dato> {
        override fun createFromParcel(parcel: Parcel): Dato {
            return Dato(parcel)
        }

        override fun newArray(size: Int): Array<Dato?> {
            return arrayOfNulls(size)
        }
    }
}