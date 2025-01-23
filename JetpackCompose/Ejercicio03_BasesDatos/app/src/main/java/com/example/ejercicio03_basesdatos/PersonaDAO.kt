package com.example.ejercicio03_basesdatos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
abstract class PersonaDAO {
    @Query("SELECT * from persona")
    abstract fun listar() : List<Persona>?

    @Insert
    abstract fun insertar(p : Persona)

    @Delete
    abstract fun eliminar(p : Persona)

    @Update
    abstract fun actualizar(p : Persona)
}