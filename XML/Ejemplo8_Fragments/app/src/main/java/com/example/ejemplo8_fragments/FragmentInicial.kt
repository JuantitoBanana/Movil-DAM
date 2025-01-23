package com.example.ejemplo8_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ejemplo8_fragments.databinding.FragmentInicialBinding

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentInicial.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentInicial : Fragment() {

    lateinit var binding: FragmentInicialBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentInicialBinding.inflate(inflater,container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.bContar.setOnClickListener{
            var contador= binding.tvSaludo.text.toString().toInt()
            binding.tvSaludo.text= (contador+1).toString()
        }
    }
}