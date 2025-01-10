package com.example.ejercicio18_sharedpreferencesqlitefragments

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
abstract class UsuarioDao {
    @Query("SELECT * FROM usuario")
    abstract fun listar():List<Usuario?>?

    @Query("DELETE FROM usuario")
    abstract fun eliminarLista()

    @Insert
    abstract fun insertar(user : Usuario)
}