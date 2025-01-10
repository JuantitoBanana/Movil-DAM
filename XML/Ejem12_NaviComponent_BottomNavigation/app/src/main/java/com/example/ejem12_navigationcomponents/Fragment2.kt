package com.example.ejem12_navigationcomponents

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.ejem12_navigationcomponents.databinding.Fragment1Binding
import com.example.ejem12_navigationcomponents.databinding.Fragment2Binding

class Fragment2 : Fragment() {

    lateinit var binding: Fragment2Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Fragment2Binding.inflate(inflater, container, false)

        val mensaje =  requireArguments()?.getString("dato_recibido")
        binding.tvVisualizarDato.text = mensaje

        binding.bAvanzar.setOnClickListener(){
            val dato : Bundle = Bundle()
            dato.putString("dato_recibido", binding.tietDato.text.toString())
            findNavController().navigate(R.id.action_fragment2_to_fragment3, dato)
        }
        binding.bRetroceder.setOnClickListener(){
            val dato : Bundle = Bundle()
            dato.putString("dato_recibido", binding.tietDato.text.toString())
            findNavController().navigate(R.id.action_fragment2_to_fragment1, dato)
        }

        return binding.root
    }
}