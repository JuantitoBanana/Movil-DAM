package com.example.ejercicio1_componentesbasicos

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ejercicio1_componentesbasicos.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }*/

        var operacion: String = ""

        var num1:Int = 0
        var num2:Int = 0


        var listener: View.OnClickListener = View.OnClickListener { boton ->
            operacion += (boton as Button).text.toString()
            binding.textoResultado.text = operacion
        }

        /*
        Se implementa en interfaz para no implementar una linea de código para cada boton
        override fun onClick(boton:View?)
         */

        binding.boton1.setOnClickListener(listener)
        binding.boton2.setOnClickListener(listener)
        binding.boton3.setOnClickListener(listener)
        binding.boton4.setOnClickListener(listener)
        binding.boton5.setOnClickListener(listener)
        binding.boton6.setOnClickListener(listener)
        binding.boton7.setOnClickListener(listener)
        binding.boton8.setOnClickListener(listener)
        binding.boton9.setOnClickListener(listener)

        binding.botonSuma.setOnClickListener(){
            num1 = operacion.toInt()
            operacion += "+"
            binding.textoResultado.text = operacion
        }

        binding.botonResta.setOnClickListener(){
            num1 = operacion.toInt()
            operacion += "-"
            binding.textoResultado.text = operacion
        }
        binding.botonIgual.setOnClickListener(){
            var resultado:Int
            if(operacion.indexOf('+') != -1) {
                num2 = operacion.substringAfter('+').toInt()
                resultado = num1 + num2
                binding.textoResultado.text = "${resultado}"
            }
            else {
                num2 = operacion.substringAfter('-').toInt()
                resultado = num1 - num2
                binding.textoResultado.text = "${resultado}"
            }
            num1 = resultado
            operacion = num1.toString()
        }
        binding.botonReset.setOnClickListener(){
            operacion = ""
            binding.textoResultado.text = ""
        }
    }
}