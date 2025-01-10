package com.example.ejem12_navigationcomponents

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.ejem12_navigationcomponents.databinding.Fragment1Binding


class Fragment1 : Fragment() {

    lateinit var binding : Fragment1Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Fragment1Binding.inflate(inflater, container, false)

        val mensaje =  requireArguments()?.getString("dato_recibido")
        binding.tvVisualizarDato.text = mensaje

        binding.bAvanzar.setOnClickListener(){
            val dato : Bundle = Bundle()
            dato.putString("dato_recibido", binding.tietDato.text.toString())
            findNavController().navigate(R.id.action_fragment1_to_fragment2, dato)
        }

        return binding.root
    }
}