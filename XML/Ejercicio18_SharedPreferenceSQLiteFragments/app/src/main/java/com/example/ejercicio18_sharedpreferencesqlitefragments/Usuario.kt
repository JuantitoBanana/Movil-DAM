package com.example.ejercicio18_sharedpreferencesqlitefragments

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "usuario")
class Usuario {

    @PrimaryKey(autoGenerate = true)
    var id : Int = 0
    @ColumnInfo(name = "nombre")
    var nombre : String = ""
    @ColumnInfo(name = "edad")
    var telefono : String = ""

    constructor(nombre: String, telefono: String) {
        this.nombre = nombre
        this.telefono = telefono
    }

    override fun toString(): String {
        return "Nombre: $nombre, Telefono: $telefono"
    }
}