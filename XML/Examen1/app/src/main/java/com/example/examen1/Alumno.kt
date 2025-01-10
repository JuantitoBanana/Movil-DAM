package com.example.examen1

class Alumno (nombre: String="", calificacion:String="") {
    var nombre:String = nombre
    var calificacion:String = calificacion
    override fun toString(): String {
        return nombre
    }

}