package com.example.ejemplo8_fragments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ejemplo8_fragments.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bReemplazar.isEnabled= false

        binding.bCargar.setOnClickListener{
            supportFragmentManager.beginTransaction().apply {
                add(R.id.fragmentContainerView, FragmentInicial())
                commit()
            }
            binding.bReemplazar.isEnabled= true
        }

        binding.bReemplazar.setOnClickListener{
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragmentContainerView, Fragment2())
                commit()
            }
        }
    }
}