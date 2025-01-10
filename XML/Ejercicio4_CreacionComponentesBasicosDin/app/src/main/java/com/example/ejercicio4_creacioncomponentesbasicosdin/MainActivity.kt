package com.example.ejercicio4_creacioncomponentesbasicosdin

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ejercicio4_creacioncomponentesbasicosdin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        var contrasena: String = ""
        var contrasenaValida: String = "1234"
        var contrasenaEnmascarada: String = ""
        var numeros = arrayOf("0" , "1", "2", "3", "4", "5", "6", "7", "8", "9")
        var listener: View.OnClickListener = View.OnClickListener { boton ->
            contrasena += (boton as Button).text.toString()
            contrasenaEnmascarada += "•"
            binding.textoContrasena.text = contrasenaEnmascarada
        }
        binding.boton0.setOnClickListener(listener)
        binding.boton1.setOnClickListener(listener)
        binding.boton2.setOnClickListener(listener)
        binding.boton3.setOnClickListener(listener)
        binding.boton4.setOnClickListener(listener)
        binding.boton5.setOnClickListener(listener)
        binding.boton6.setOnClickListener(listener)
        binding.boton7.setOnClickListener(listener)
        binding.boton8.setOnClickListener(listener)
        binding.boton9.setOnClickListener(listener)

        binding.botonValidar.setOnClickListener(){
            if (contrasena.equals(contrasenaValida)) {
                binding.textoValidacion.text = "Contraseña Válida"
            } else {
                binding.textoValidacion.text = "Contraseña no Válida"
            }
            contrasena = ""
            contrasenaEnmascarada = ""
            binding.textoContrasena.text = ""
        }

        binding.checkContrasena.setOnCheckedChangeListener{_, isChecked ->
            if(isChecked){
                binding.textoContrasena.text = contrasena
            }
            else{
                binding.textoContrasena.text = contrasenaEnmascarada
            }
        }
        binding.imagenDado.setOnClickListener(){
            numeros.shuffle()
            binding.boton0.text = numeros[0]
            binding.boton1.text = numeros[1]
            binding.boton2.text = numeros[2]
            binding.boton3.text = numeros[3]
            binding.boton4.text = numeros[4]
            binding.boton5.text = numeros[5]
            binding.boton6.text = numeros[6]
            binding.boton7.text = numeros[7]
            binding.boton8.text = numeros[8]
            binding.boton9.text = numeros[9]

        }
    }
}