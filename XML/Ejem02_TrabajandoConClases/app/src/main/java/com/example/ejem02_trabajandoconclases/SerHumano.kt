package com.example.ejem02_trabajandoconclases

import android.util.Log

open class SerHumano {
    fun saludar(){
        Log.d("depurando", "Hola")
    }
    fun saludar2(nombre: String): String{
        return "Hola $nombre"
    }
}