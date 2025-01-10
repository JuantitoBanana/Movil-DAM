package com.example.ejem16_basedatos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "persona")
class Persona{

    @PrimaryKey(autoGenerate = true)
    var id : Int = 0
    @ColumnInfo(name = "nombre")
    var nombre : String = ""
    @ColumnInfo(name = "edad")
    var edad : Int = 0
    @ColumnInfo(name = "direccion")
    var direccion : String = ""

    constructor(nombre: String, edad: Int, direccion: String) {
        this.nombre = nombre
        this.edad = edad
        this.direccion = direccion
    }


    override fun toString(): String {
        return "Persona(direccion='$direccion', id=$id, nombre='$nombre', edad=$edad)"
    }


}