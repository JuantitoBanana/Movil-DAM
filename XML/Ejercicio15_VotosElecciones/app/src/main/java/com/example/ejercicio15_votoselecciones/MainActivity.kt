package com.example.ejercicio15_votoselecciones

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ejercicio15_votoselecciones.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result ->
            if(result.resultCode == RESULT_OK){
                binding.tvResultados.text = result.data?.getParcelableExtra("resultado", Dato::class.java).toString()
            } else if (result.resultCode == RESULT_CANCELED){
                binding.tvResultados.text = "No se ha encontrado ningun dato"
            }
        }
        
        binding.botonVotos.setOnClickListener(){
            var cambiarActivityVotar:Intent = Intent(this, Activity2::class.java)
            launcher.launch(cambiarActivityVotar)

        }

        binding.botonVotos.setOnTouchListener { view, motionEvent ->
            when(motionEvent.action){
                MotionEvent.ACTION_MOVE -> {
                    binding.botonIdioma.text = "Hola"

                }
                MotionEvent.ACTION_DOWN -> {
                    binding.botonIdioma.text = "Adios"

                }
                MotionEvent.ACTION_UP -> {
                    binding.botonIdioma.text = "Si"

                }
            }
            return@setOnTouchListener true
        }

    }
}