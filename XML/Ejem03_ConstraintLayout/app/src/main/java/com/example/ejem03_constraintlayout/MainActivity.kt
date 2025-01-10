package com.example.ejem03_constraintlayout

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ejem03_constraintlayout.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.botonEnviar.setOnClickListener(){
            var p : Persona = Persona(binding.tietNombre.text.toString(), binding.tietApellido1.text.toString(), binding.tietApellido2.text.toString())
            binding.usuario = p
        }

        val listenerTeclado:TextWatcher = object:TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(tiet_editado: Editable?) {

                Log.d("depurando" , tiet_editado.toString())
                validarCampos(binding.tilNombre, binding.tietNombre, {texto -> texto.length > 10})
                validarCampos(binding.tilApellido1, binding.tietApellido1, {texto -> texto.length > 5})
                validarCampos(binding.tilApellido2, binding.tietApellido2,{texto -> texto.length > 2})
            }

        }

        binding.tietNombre.addTextChangedListener(listenerTeclado)
        binding.tietApellido1.addTextChangedListener(listenerTeclado)
        binding.tietApellido2.addTextChangedListener(listenerTeclado)


    }

    private fun validarCampos(layoutCampo: TextInputLayout,campo: TextInputEditText, condicion:(String) -> Boolean){

        //if (campo.text.toString().length == 0){
        if(condicion(campo.text.toString())){
            campo.error = "Error"
            layoutCampo.error = "Error"
        }else {
            campo.error = null
            layoutCampo.error = null
        }
    }

}