package com.example.ejercicio2_spinnerlistview

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ejercicio2_spinnerlistview.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        var datos = ArrayList<Dato>()
        var adaptadorDatos = ArrayAdapter(this,android.R.layout.simple_list_item_1,datos)

        binding.listaDatos.adapter = adaptadorDatos

        binding.bAniadir.setOnClickListener(){
            var d:Dato = Dato(binding.textoDato.text.toString())
            datos.add(d)
            adaptadorDatos.notifyDataSetChanged()
            binding.textoDato.text.clear()
        }

        binding.bBorrar.setOnClickListener(){
            var posicion = binding.listaDatos.checkedItemPosition
            datos.removeAt(posicion)
            adaptadorDatos.notifyDataSetChanged()
            binding.listaDatos.clearChoices()
        }

        binding.listaDatos.setOnItemClickListener { adapterView: AdapterView<*>, view2: View, i: Int, l: Long ->
            var posicion = binding.listaDatos.checkedItemPosition
            binding.dato = datos[posicion]
        }


        /*binding.main.setOnTouchListener { view, motionEvent ->
            Toast.makeText(this,"Touch en el layout",Toast.LENGTH_SHORT).show()
            Snackbar.make(view,"Touch en el layout",Snackbar.LENGTH_SHORT).show()
            false
        } */

       /* binding.main.setOnLongClickListener(View.OnLongClickListener { vistaPulsada ->
            Toast.makeText(this,"Touch en el layout",Toast.LENGTH_SHORT).show()
            Snackbar.make(vistaPulsada,"Touch en el layout",Snackbar.LENGTH_SHORT).show()
            false
        }) */

        binding.listaDatos.setOnItemLongClickListener{ adapterView, vistaPulsada,i,l ->
            Snackbar.make(vistaPulsada,"${(vistaPulsada as TextView).text.toString()}",Snackbar.LENGTH_SHORT).show()
            false
        }

    }
}