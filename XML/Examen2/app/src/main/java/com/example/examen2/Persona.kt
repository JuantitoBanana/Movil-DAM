package com.example.examen2

class Persona(nombre:String="", sexo:String="") {
    var nombre:String = nombre
    var sexo:String = sexo
    override fun toString(): String {
        return nombre
    }
}