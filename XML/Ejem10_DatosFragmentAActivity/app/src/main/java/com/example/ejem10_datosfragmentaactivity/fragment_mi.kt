package com.example.ejem10_datosfragmentaactivity

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.ejem10_datosfragmentaactivity.databinding.ActivityMainBinding.inflate
import com.example.ejem10_datosfragmentaactivity.databinding.FragmentMiBinding
import com.google.android.material.snackbar.Snackbar

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [fragment_mi.newInstance] factory method to
 * create an instance of this fragment.
 */
class fragment_mi : Fragment() {

    private lateinit var activityDependiente : EnviandoDatos

    override fun onAttach(context: Context) {
        super.onAttach(context)
        activityDependiente = context as EnviandoDatos
    }

    // TODO: Rename and change types of parameters
    private var param1: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }
    }

    lateinit var binding: FragmentMiBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMiBinding.inflate(inflater, container, false)

        var dato : Dato = ViewModelProvider(requireActivity()).get(Dato::class.java)

        binding.bPasarDato.setOnClickListener(){
            dato.dato = binding.etPasarDato.text.toString()
            (activity as MainActivity).actualizarDatos()
        }

        binding.bPasarDatoFragment1Al2.setOnClickListener(){
            val dato:String = binding.tietDatoDentroFragment1.text.toString()

            activityDependiente?.enviarDatos(binding.tietDatoDentroFragment1.text.toString())

            Snackbar.make(binding.root, "Dato enviado: $dato",Snackbar.LENGTH_SHORT).show()
        }

        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment fragment_mi.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String) =
            fragment_mi().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }

        interface EnviandoDatos {
            fun enviarDatos(dato : String)
        }

    }
}