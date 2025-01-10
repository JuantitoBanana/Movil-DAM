package com.example.ejem03_constraintlayout

class Persona {
    private lateinit var nombre:String
    private lateinit var apellido1:String
    private lateinit var apellido2:String
    constructor(nombre:String, apellido1:String, apellido2: String){
        this.nombre = nombre
        this.apellido1 = apellido1
        this.apellido2 = apellido2
    }

    override fun toString(): String {
        return "$nombre $apellido1 $apellido2"
    }


}