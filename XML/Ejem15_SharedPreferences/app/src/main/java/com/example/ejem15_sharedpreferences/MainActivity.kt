package com.example.ejem15_sharedpreferences

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ejem15_sharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPrefLectura = getSharedPreferences("preferencias", MODE_PRIVATE)
        var nombres : MutableSet<String>? =  sharedPrefLectura.getStringSet("nombres", mutableSetOf<String>())
        var contrasenas : MutableSet<String>? =  sharedPrefLectura.getStringSet("contrasenas", mutableSetOf<String>())
        var nombre : String? =  sharedPrefLectura.getString("ultimoNombre", "No definido")
        var contrasena : String? =  sharedPrefLectura.getString("ultimoContrasena", "No definido")
        binding.usuario = Usuario(nombre!!, contrasena!!)

        binding.bRegistrar.setOnClickListener(){
            nombre = binding.tietNombre.text.toString()
            contrasena = binding.tietContrasena.text.toString()
            var usuario : Usuario = Usuario(nombre!!, contrasena!!)

            if (nombres != null && nombres.contains(nombre) == true) {
                binding.tvDato.text = "El usuario ya existe"

            } else {
                nombres?.add(nombre!!)
                contrasenas?.add(contrasena!!)
                binding.tvDato.text = "El usuario no existe"
            }

            val sharedPreference = getSharedPreferences("preferencias", MODE_PRIVATE)
            val editor = sharedPreference.edit()
            editor.putStringSet("nombres", nombres)
            editor.putStringSet("contrasenas", contrasenas)
            editor.putString("ultimoNombre", nombre)
            editor.putString("ultimoContrasena", contrasena)
            //editor.apply()
            editor.commit()
            binding.tietNombre.text?.clear()
            binding.tietContrasena.text?.clear()
        }
    }
}