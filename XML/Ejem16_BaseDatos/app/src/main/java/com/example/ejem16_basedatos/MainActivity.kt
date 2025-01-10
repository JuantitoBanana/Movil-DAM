package com.example.ejem16_basedatos

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.ejem16_basedatos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val basedatos: BD =
            Room.databaseBuilder(this, BD::class.java, "bdPersonas").allowMainThreadQueries().build()
        val personaDAO = basedatos.personaDao()

        binding.bInsertar.setOnClickListener(){
            var persona : Persona = Persona(binding.tietNombre.text.toString(), binding.tietEdad.text.toString().toInt(), binding.tietDireccion.text.toString())

            personaDAO?.insertar(persona)
            Log.d("Persona", persona.toString())
        }

        binding.bRecuperarPrimero.setOnClickListener(){
            val persona = personaDAO?.recuperarUsuario(1)
            binding.persona = persona
        }

        binding.bListar.setOnClickListener(){
            val personas = personaDAO?.listar()
            val adaptador = ArrayAdapter<Persona>(this, android.R.layout.simple_list_item_1, personas!!)
            binding.lvPersonas.adapter = adaptador
        }

        binding.bBorrar.setOnClickListener(){
            val persona = personaDAO?.recuperarUsuario(binding.tietId.text.toString().toInt())
            if(persona != null) personaDAO.eliminar(persona)
        }

        binding.bActualizar.setOnClickListener(){
            val persona = personaDAO?.recuperarUsuario(binding.tietId.text.toString().toInt())
            if(persona != null) {
                if (!binding.tietNombre.text.isNullOrBlank()){
                    persona.nombre = binding.tietNombre.text.toString()
                }
                if (!binding.tietEdad.text.isNullOrBlank()){
                    persona.edad = binding.tietEdad.text.toString().toInt()
                }
                if (!binding.tietDireccion.text.isNullOrBlank()){
                    persona.direccion = binding.tietDireccion.text.toString()
                }

                personaDAO.actualizar(persona)
            }
        }

        binding.lvPersonas.setOnItemClickListener { adapterView, view, i, l ->
            val persona = adapterView.getItemAtPosition(i) as Persona
            binding.persona = persona

        }

    }
}