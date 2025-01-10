package com.example.ejercicio6_cafetera

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.ejercicio6_cafetera.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var recaudacion : Double = 0.0
        binding.dinero = "Recaudación: ${recaudacion}€"

        val cafes : Array<String> = arrayOf("Café con leche", "Café solo", "Café Cappuccino", "Café Bombón", "Café Machiatto")
        var adaptadorCafes = ArrayAdapter(this, android.R.layout.simple_list_item_1, cafes)

        binding.selectorCafe.adapter = adaptadorCafes

        binding.botonOnOff.setOnClickListener(){
            if(binding.botonOnOff.text.equals("On")){
                binding.botonOnOff.text = "Off"
                binding.botonCafe.isEnabled = false
                binding.botonCafe.alpha = 0.75f
            }
            else{
                binding.botonOnOff.text = "On"
                binding.botonCafe.isEnabled = true
                binding.botonCafe.alpha = 1f
            }
        }

        binding.botonCafe.setOnClickListener(){

            var cafe = binding.selectorCafe.selectedItem.toString()

            if (binding.checkAzucar.isChecked) {
                binding.textoResultado.text = "Servido ${cafe} extra de azúcar"
                recaudacion += 1.5
            }
            else {
                binding.textoResultado.text = "Servido ${cafe}"
                recaudacion += 1.0
            }

            binding.dinero = "Recaudación: ${recaudacion}€"

        }

    }
}