package com.example.ejercicio15_votoselecciones

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.ejercicio15_votoselecciones.databinding.Activity2Binding

class Activity2: AppCompatActivity() {

    lateinit var binding: Activity2Binding
    private var votosPSOE:Int = 0
    private var votosPP:Int = 0
    private var votosVOX:Int = 0
    private var votosSUMAR:Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Activity2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        var partidos:Array<String> = arrayOf("PSOE", "PP", "VOX", "SUMAR")
        var adapterPartidos = ArrayAdapter(this, android.R.layout.simple_list_item_1, partidos)
        binding.listaPartidos.adapter = adapterPartidos

        binding.botonVotar2.setOnClickListener(){
    /*
            if (binding.listaPartidos.selectedItem.toString().equals("PSOE")){
                votosPSOE++
            } else if (binding.listaPartidos.selectedItem.toString().equals("PP")){
                votosPP++
            } else  if (binding.listaPartidos.selectedItem.toString().equals("VOX")){
                votosVOX++
            } else if (binding.listaPartidos.selectedItem.toString().equals("SUMAR")){
                votosSUMAR++
            }
            var resultado:String = "PSOE: $votosPSOE\nPP: $votosPP\nVOX: $votosVOX\nSUMAR: $votosSUMAR"
*/
            var resultado:String = "Juan"
            setResult(RESULT_OK, intent.putExtra("resultado", Dato(resultado)))
            finish()
        }
    }
}