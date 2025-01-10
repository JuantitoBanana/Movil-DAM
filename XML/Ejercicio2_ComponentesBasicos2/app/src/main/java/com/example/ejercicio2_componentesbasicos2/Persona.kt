package com.example.ejercicio2_componentesbasicos2

class Persona {
    var nombre:String = ""
    var soltero:Boolean = true
    var edad: Int = 0
    var deportes: List<String> = emptyList()
    constructor(){
        this.nombre = ""
    }
    constructor( nombre:String, edad:Int, soltero: Boolean, deportes:List<String>){
        this.nombre = nombre
        this.soltero = soltero
        this.edad = edad
        this.deportes = deportes
    }
}