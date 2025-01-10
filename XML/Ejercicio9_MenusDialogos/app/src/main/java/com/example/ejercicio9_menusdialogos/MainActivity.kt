package com.example.ejercicio9_menusdialogos

import android.content.res.Configuration
import android.content.res.Resources
import android.os.Bundle
import android.os.LocaleList
import android.util.DisplayMetrics
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ejercicio9_menusdialogos.databinding.ActivityMainBinding
import java.util.Locale

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonFinalizar.setOnClickListener(){
            mostrarDialog()
        }

        binding.buttonFinalizarTambien.setOnClickListener(){
            mostrarDialog()
        }

        binding.buttonCambiarIdioma.setOnClickListener(){
            cambiarIdioma()
            recreate()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Infla el menú, agregando elementos a la barra de acción
        menuInflater.inflate(R.menu.menu1, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_finalizar, R.id.action_finalizar_tambien -> {
                mostrarDialog()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun mostrarDialog() {
        val dialog = AlertDialog.Builder(this)
            .setTitle(getString(R.string.titulo))
            .setMessage(getString(R.string.confirmacion))
            .setPositiveButton(getString(R.string.si)) { _, _ ->
                Toast.makeText(this, getString(R.string.mensaje_despedida), Toast.LENGTH_SHORT).show()
                finish()
            }
            .setNegativeButton(getString(R.string.no)) { _, _ ->
            }
            .create()
        dialog.show()
    }

    private fun cambiarIdioma() {
        val res = this.resources
        val conf = res.configuration
        val locale = Locale("en")
        conf.setLocale(locale)
        res.updateConfiguration(conf, res.displayMetrics)
    }
}