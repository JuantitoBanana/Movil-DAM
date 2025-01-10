package com.example.ejem10_datosfragmentaactivity

import android.os.Bundle
import android.view.inputmethod.InputBinding
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.ejem10_datosfragmentaactivity.databinding.ActivityMainBinding
import com.example.ejem10_datosfragmentaactivity.databinding.FragmentMiBinding

class  MainActivity : AppCompatActivity(), fragment_mi.Companion.EnviandoDatos {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var c : Contador = ViewModelProvider(this).get(Contador::class.java)
        binding.tvContador.text = c.contador.toString()

        val fragment = fragment_mi.newInstance(binding.tietDato.text.toString())
        supportFragmentManager.beginTransaction().add(R.id.fragmentContainerView, fragment).commit()

        binding.bIncrementar.setOnClickListener(){
            c.incrementar()
            binding.tvContador.text = c.contador.toString()
        }


    }

    fun actualizarDatos(){
        var dato : Dato = ViewModelProvider(this).get(Dato::class.java)
        binding.tvDato.text = dato.dato
    }

    override fun enviarDatos(dato: String) {
        binding.textView2.text = dato
    }
}