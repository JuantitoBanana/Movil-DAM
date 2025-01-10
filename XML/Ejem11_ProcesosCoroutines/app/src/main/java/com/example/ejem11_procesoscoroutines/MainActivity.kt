package com.example.ejem11_procesoscoroutines

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ejem11_procesoscoroutines.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bIniciar.setOnClickListener(){
            binding.pgBarraProgreso.max = 100


            CoroutineScope(Dispatchers.Default).launch {
                for(i in 1 .. 100){
                    binding.pgBarraProgreso.progress = i
                    delay(100)
                }
            }
        }

    }
}