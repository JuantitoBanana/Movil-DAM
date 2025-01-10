package com.example.ejercicio20_fragments

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ejercicio20_fragments.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(), Fragment1.EnviandoDatos {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bContadorAutomatico.setOnClickListener(){
            binding.pgBarraProgreso.max = 20


            CoroutineScope(Dispatchers.Default).launch {
                for(i in 1 .. 20){
                    binding.pgBarraProgreso.progress = i
                    delay(1000)
                }
            }

            CoroutineScope(Dispatchers.Main).launch {
                for(i in 1 .. 20){
                    binding.tvContadorAutomTico2.text = "$i"
                    delay(1000)
                }
            }

        }

    }
    override fun enviarDatos(dato: String) {
        binding.tvContadorManual2.text = dato
    }

}