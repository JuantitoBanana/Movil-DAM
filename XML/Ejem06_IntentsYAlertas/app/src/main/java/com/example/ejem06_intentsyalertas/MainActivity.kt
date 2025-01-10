package com.example.ejem06_intentsyalertas

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ejem06_intentsyalertas.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bNavagador.setOnClickListener(){
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.gregoriofer.com"))
            startActivity(intent)
        }

        binding.bMail.setOnClickListener(){
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_SUBJECT, "Asunto del correo")
            intent.putExtra(Intent.EXTRA_TEXT, "Cuerpo del correo")
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("victorvergel@verinsis.com"))
            startActivity(intent)
        }
        binding.bTelefono.setOnClickListener(){
            intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:123456789"))
            startActivity(intent)
        }
        binding.bMaps.setOnClickListener(){
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:41.6525,-4.7245"))
            startActivity(intent)
        }
        binding.bWhatsApp.setOnClickListener(){
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse("https//wa.es/3466666666"))
            startActivity(intent)
        }

        binding.bDialogoAlerta.setOnClickListener() {
            AlertDialog.Builder(this)
                .setTitle("Título del diálogo")
                .setMessage("Mensaje del diálogo")
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setPositiveButton("Aceptar") { dialog, which ->
                    Snackbar.make(binding.root, "Has pulsado Aceptar", Snackbar.LENGTH_SHORT).show()
                }
                .setNegativeButton("Cancelar") { dialog, which ->
                    Snackbar.make(binding.root, "Has pulsado Cancelar", Snackbar.LENGTH_SHORT).show()
                }
                .show()
        }

        binding.bDialogoSelectMultiple.setOnClickListener(){
            val colores = arrayOf("Rojo", "Verde", "Azul", "Amarillo")
            val seleccionados = booleanArrayOf(true, false, false, false)
            AlertDialog.Builder(this)
                .setTitle("Selecciona colores")
                .setMultiChoiceItems(colores, seleccionados) { dialog, which, isChecked ->
                    seleccionados[which] = isChecked
                }
                .setPositiveButton("Aceptar") { dialog, which ->
                    var coloresSeleccionados = ""
                    for (i in colores.indices) {
                        if (seleccionados[i]) {
                            coloresSeleccionados += colores[i] + ", "
                        }
                    }
                    Snackbar.make(binding.root, "Has seleccionado: $coloresSeleccionados", Snackbar.LENGTH_SHORT).show()
                }
                .setNegativeButton("Cancelar", null)
                .show()
        }
        binding.bDialogoOpcionUnica.setOnClickListener(){
            val colores = arrayOf("Rojo", "Verde", "Azul", "Amarillo")
            val seleccionados = booleanArrayOf(true, false, false, false)
            AlertDialog.Builder(this)
                .setTitle("Selecciona colores")
                .setSingleChoiceItems(colores, 0) { dialog, which ->
                    Snackbar.make(binding.root, "Has seleccionado: ${colores[which]}", Snackbar.LENGTH_SHORT).show()
                }
                .setPositiveButton("Aceptar") { dialog, which ->
                    var coloresSeleccionados = ""
                    for (i in colores.indices) {
                        if (seleccionados[i]) {
                            coloresSeleccionados += colores[i] + ", "
                        }
                    }
                    Snackbar.make(binding.root, "Has seleccionado: $coloresSeleccionados", Snackbar.LENGTH_SHORT).show()
                }
                .setNegativeButton("Cancelar", null)
                .show()
        }
    }
}