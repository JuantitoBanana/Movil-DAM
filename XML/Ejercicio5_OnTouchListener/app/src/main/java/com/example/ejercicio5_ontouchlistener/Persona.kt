package com.example.ejercicio5_ontouchlistener

class Persona {
    lateinit var nombre: String
    lateinit var contrasena: String
    constructor(nombre: String, contrasena: String){
        this.nombre = nombre
        this.contrasena = contrasena
    }

    override fun toString(): String {
        return "$nombre"
    }

}