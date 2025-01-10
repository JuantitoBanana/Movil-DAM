package com.example.ejem02_trabajandoconclases

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ejem02_trabajandoconclases.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val pepe = Persona("Pepe", "1234")
        Log.d("depurando", "Nombre: ${pepe.nombre} , Contrasena: ${pepe.contrasena}")

        pepe.contrasena = "5678"
        Log.d("depurando", "Nombre: ${pepe.nombre} , Contrasena: ${pepe.contrasena}")

        var pepe2 = Persona(nombre = "Pepe", edad = 25)
        pepe2.contrasena = "5678"
        Log.d("depurando", pepe2.toString())

        pepe2.correr()
        Log.d("depurando", pepe2.saludar2(pepe.nombre))

        binding.usuario = pepe


        var datos: ArrayList<Persona> = ArrayList<Persona>()
        binding.listaPersonas.adapter = ArrayAdapter<Persona>(this, android.R.layout.simple_list_item_1, datos)

        binding.botonGuardar.setOnClickListener(){
            var usuario: Persona = Persona(binding.textoNombre.text.toString(), binding.textoContrasena.text.toString())
            Log.d("depurando", usuario.toString())
            (binding.listaPersonas.adapter as ArrayAdapter<Persona>).add(usuario)

            val personaVacia: Persona = Persona()
            binding.usuario = personaVacia
            // datos.add(usuario)
            // (binding.listaPersonas.adapter as ArrayAdapter<Persona>).notifyDataSetChanged()



        }
    }
}