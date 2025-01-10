package com.example.ejem10_datosfragmentaactivity

import androidx.lifecycle.ViewModel

class Contador : ViewModel(){
    var contador = 0
    fun incrementar(){
        contador++
    }
}