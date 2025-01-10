package com.example.ejem17_recycledview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ejem17_recycledview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val persona1 = Persona(getDrawable(R.drawable.foto1)!!, "Juan", 20, "123 45 67 89")
        val persona2 = Persona(getDrawable(R.drawable.foto2)!!, "Pepe", 41, "123 45 67 89")
        val persona3 = Persona(getDrawable(R.drawable.foto3)!!, "Pipo", 35, "123 45 67 89")

        var listaPersonas = mutableListOf(persona1, persona2, persona3)

        binding.rvVistaDatos.adapter = AdaptadorPersona(listaPersonas)
        binding.rvVistaDatos.layoutManager = LinearLayoutManager(this)
        binding.bAniadir.setOnClickListener(){
            val persona = Persona(ContextCompat.getDrawable(this, R.drawable.foto1)!!,binding
                .tietNombre.text.toString(),binding.tietEdad.text.toString().toInt(),binding.tietTelefono.text.toString())
            listaPersonas.add(persona)
            binding.rvVistaDatos.adapter?.notifyDataSetChanged()
        }
    }
}