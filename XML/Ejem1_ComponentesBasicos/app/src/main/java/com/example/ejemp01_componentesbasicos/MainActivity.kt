package com.example.ejemp01_componentesbasicos

import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import android.view.inputmethod.InputBinding
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.TypedArrayUtils
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ejemp01_componentesbasicos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        /*
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        */
        /*
        val boton:Button = findViewById<Button>(R.id.boton_datos)
        boton.setOnClickListener(){
            val saludo:TextView = findViewById<TextView>(R.id.texto_saludo)
            val nombre:EditText = findViewById<EditText>(R.id.NombreUsuario)
            saludo.text = "Hola ${nombre.text}"
        }
        */
        binding.botonDatos.setOnClickListener(){
            binding.textoSaludo.text = "Hola a todos"
            var nombreIntroUsuario: String = binding.NombreUsuario.text.toString()
            (binding.lvListaNombres.adapter as ArrayAdapter<String>).add(nombreIntroUsuario)
        }
        var EstadoCivil:String = findViewById<RadioButton>(binding.RGroupEstadoCivil.checkedRadioButtonId).text.toString()
        binding.textoSaludo.text = "Tu estado civíl es ${EstadoCivil}"

        binding.spinner.onItemSelectedListener=object: AdapterView.OnItemSelectedListener{

            override fun onItemSelected(parent: AdapterView<*>?, view: android.view.View?, position: Int, id: Long) {
                Log.d("depurando", "Seleccionado: ${binding.spinner.selectedItem}")
                /*val temp:String = (parent as ArrayAdapter<String>).getItem(position).toString()
                Log.d("depurando", "Seleccionado: ${temp}")*/
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Log.d("depurando", "Nada seleccionado")
            }
        }
        var datos_Desplegable = arrayOf("Rojo", "Verde", "Azul", "Amarillo")

        //binding.spinner2.adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, datos_Desplegable)

        var listaNombres: ArrayList<String> = ArrayList()
        listaNombres.add("Juan")
        listaNombres.add("Pedro")
        binding.lvListaNombres.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, listaNombres)


    }


}