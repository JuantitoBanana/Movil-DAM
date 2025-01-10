package com.example.examen_2eva.ui.FragmentRegistro

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.examen_2eva.Usuario
import com.example.examen_2eva.databinding.FragmentRegistroBinding

class FragmentRegistro : Fragment() {

    private var _binding: FragmentRegistroBinding? = null
    private var listaUsuarios: ArrayList<Usuario> = ArrayList();
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentRegistroBinding.inflate(inflater, container, false)


        binding.bGuardar.setOnClickListener(){
            var nuevoUsuario : Usuario = Usuario(binding.etUsuario.text.toString(), binding.etContrasena.text.toString())
            listaUsuarios.add(nuevoUsuario)
            binding.etUsuario.text.clear()
            binding.etContrasena.text.clear()
        }

        binding.bListarDatos.setOnClickListener(){
            for ( usuario in listaUsuarios){
                Log.d("Resultado", "${usuario.nombre}, ${usuario.contrasena}")
            }
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}