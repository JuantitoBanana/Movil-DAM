package com.example.ejem17_recycledview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ejem17_recycledview.databinding.PersonaBinding
import com.google.android.material.snackbar.Snackbar

class AdaptadorPersona(val listaPersonas: MutableList<Persona>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

   lateinit var  binding : PersonaBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        binding = PersonaBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PersonaViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val persona = listaPersonas[position]
        binding.persona = persona

        binding.bBorrarUsuario.setOnClickListener() { boton ->
            Snackbar.make(boton,"Borrando " + persona.nombre, Snackbar.LENGTH_SHORT).show()
            listaPersonas.remove(persona)
            notifyItemRemoved(position)
        }


    }

    override fun getItemCount(): Int {
        return  listaPersonas.size
    }

    class PersonaViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

    }

}


