package com.example.ejercicio03_basesdatos

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Persona::class], version = 1)
abstract class BD : RoomDatabase() {
    abstract fun personaDao() : PersonaDAO?
}