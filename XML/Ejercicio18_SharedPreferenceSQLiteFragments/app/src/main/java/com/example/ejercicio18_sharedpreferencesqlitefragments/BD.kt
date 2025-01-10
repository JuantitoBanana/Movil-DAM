package com.example.ejercicio18_sharedpreferencesqlitefragments

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Usuario ::class], version = 1)
abstract class BD : RoomDatabase() {
    abstract  fun usuarioDao():UsuarioDao?
}