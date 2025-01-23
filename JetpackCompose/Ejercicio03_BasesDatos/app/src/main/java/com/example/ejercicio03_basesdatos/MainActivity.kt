package com.example.ejercicio03_basesdatos

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentCompositionLocalContext
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.ejercicio03_basesdatos.ui.theme.Ejercicio03_BasesDatosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           InterfazPrincipal()
        }
    }
}

@Composable
fun InterfazPrincipal(modifier: Modifier = Modifier) {

    val basedatos: BD =
        Room.databaseBuilder(LocalContext.current, BD::class.java, "bdPersonas").allowMainThreadQueries().build()
    val personaDAO : PersonaDAO? = basedatos.personaDao()
    var texto by remember { mutableStateOf("") }
    var casado by remember { mutableStateOf(false) }
    var estadoCivil by remember { mutableStateOf("") }
    var soltero by remember { mutableStateOf(false) }
    var p by remember { mutableStateOf(Persona(0,"", "")) }
    Column {
        TextField(value = texto,
            onValueChange ={
                texto = it
            })
        Row {
            Text(text = "Estado Civil: ")
            Checkbox(checked = casado, onCheckedChange = {
                casado = it
                estadoCivil = "Casado"
                soltero = false
            })
            Text(text = " Casado")
            Checkbox(checked = soltero, onCheckedChange = {
                soltero = it
                estadoCivil = "Soltero"
                casado = false
            })
            Text(text = " Soltero")
        }
        Button({
            p = Persona(0, texto, estadoCivil)
            personaDAO?.insertar(p)
            Log.d("depurando", "Nombre: " + texto + ", Estado Civil: " + estadoCivil)
        }) {
            Text(text = "Enviar")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun InterfazPrincipalPreview() {

}