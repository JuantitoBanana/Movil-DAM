package com.example.ejercicio03_basesdatos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "persona")
data class Persona(@PrimaryKey(autoGenerate = true) var id : Int = 0,
    @ColumnInfo var nombre: String,
    @ColumnInfo var estadoCivil: String){}
