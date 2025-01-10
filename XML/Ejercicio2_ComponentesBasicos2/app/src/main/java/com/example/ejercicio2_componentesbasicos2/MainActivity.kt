package com.example.ejercicio2_componentesbasicos2

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.text.method.KeyListener
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.RadioButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ejercicio2_componentesbasicos2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textoDatos.setOnKeyListener { componentePAdre, codigoLetra, evento ->

            Log.d("depurando", "Ha pulsado " + codigoLetra)
            true
        }

        binding.padreRojo.setOnTouchListener { view, motionEvent ->
            Log.d("depurando", "Ha pulsado en el padre")
            true
        }

        binding.hijoAmarillo.setOnTouchListener { view, motionEvent ->
            Log.d("depurando", "Ha pulsado en el hijo")
            binding.textoHijoAmarillo.text=motionEvent.x.toString()+","+motionEvent.y.toString()
            true
        }

        /*
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
         */
        var datos_Desplegable = arrayOf("Valladolid", "Vigo", "Madrid", "Córdoba")
        binding.selectorCiudades.adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, datos_Desplegable)

        var persona: Persona = Persona("Juan", 20, true, listOf("Futbol", "Baloncesto"))
        binding.usuario = persona

        binding.botonGuardar.setOnClickListener(){
            var nombre: String = binding.textoDatos.text.toString()

            var estadoCivil: String = findViewById<RadioButton>(binding.estadoCivilRG.checkedRadioButtonId).text.toString()

            var ciudad: String = binding.selectorCiudades.selectedItem.toString()

            var deportes = mutableListOf<String>()

            if(binding.checkFutbol.isChecked) deportes.add("Futbol")
            if(binding.checkBaloncesto.isChecked) deportes.add("Balonceste")
            if(binding.checkTenis.isChecked) deportes.add("Tenis")


            var personaVacia: Persona =  Persona()
            binding.usuario = personaVacia

            Log.d("Datos Formulario", "Nombre: ${nombre}")
            Log.d("Datos Formulario", "Estado civil:  ${estadoCivil}")
            Log.d("Datos Formulario", "Ciudad: ${ciudad}")
            Log.d("Datos Formulario", "Deportes: ${deportes.joinToString(", ")}")
        }


    }
}