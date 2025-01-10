package com.example.examen1

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.examen1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var alumno:Alumno = Alumno("Juan")
        binding.alumno = alumno
        var contSuspensos:Int = 0
        binding.textoSuspensos.text = contSuspensos.toString()
        var listaAlumno = mutableListOf<Alumno>()
        var adaptadorAlumnos = ArrayAdapter(this,android.R.layout.simple_list_item_1,listaAlumno)
        binding.listaAlumnos.adapter = adaptadorAlumnos

        binding.botonOpciones.setOnClickListener(){
            var alum:Alumno = Alumno(binding.campoNombre.text.toString(),binding.ListaCalificacion.selectedItem.toString())
            adaptadorAlumnos.add(alum)
            if(alum.calificacion.equals("Suspenso")){
                contSuspensos++
                binding.textoSuspensos.text = contSuspensos.toString()
            }
        }

        binding.listaAlumnos.setOnItemClickListener { _, _, i, _ ->
            var alumnoSeleccionado:Alumno = listaAlumno[i]
            Log.d("Resultado", "${alumnoSeleccionado.nombre},${alumnoSeleccionado.calificacion}")
        }
    }
}