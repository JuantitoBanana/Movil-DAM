package com.example.ejemplo9_pasardatosfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ejemplo9_pasardatosfragment.databinding.FragmentMiBinding
import com.example.ejemplo9_pasardatosfragment.databinding.FragmentOtroBinding

/**
 * A simple [Fragment] subclass.
 * Use the [OtroFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class OtroFragment : Fragment() {

    lateinit var binding: FragmentOtroBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOtroBinding.inflate(inflater, container, false)
        parentFragmentManager.setFragmentResultListener("DatoEnviar", this){
                key, bundle ->
            binding.tvDatoOtro.text = bundle.getString("dato")
        }
        return binding.root
    }
}