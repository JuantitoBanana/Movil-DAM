package com.example.examen2

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.examen2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var listaPersonas  = mutableListOf<Persona>()
        var adaptador = ArrayAdapter<Persona>(this, android.R.layout.simple_list_item_1,listaPersonas)
        binding.listaPersonas.adapter = adaptador
        binding.radioHombre.isChecked = true


        binding.botonEnviar.setOnClickListener(){
            var p:Persona
            if(!binding.textoNombre.text.equals("")){
                if (binding.radioHombre.isChecked){
                    p = Persona(binding.textoNombre.text.toString(), binding.radioHombre.text.toString())
                } else {
                    p = Persona(binding.textoNombre.text.toString(), binding.radioMujer.text.toString())
                }
                adaptador.add(p)
            }
        }

        binding.listaPersonas.setOnItemClickListener { _, _, posicion, _ ->
            var personaSeleccionada:Persona = listaPersonas[posicion]
            Toast.makeText(this, personaSeleccionada.nombre + ", " + personaSeleccionada.sexo, Toast.LENGTH_SHORT).show()
        }
    }
}