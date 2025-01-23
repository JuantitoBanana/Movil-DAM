package com.example.ejercicio03_basesdatos

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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

    //val basedatos: BD = Room.databaseBuilder(LocalContext.current, BD::class.java, "bdPersonas").allowMainThreadQueries().build()
    //val personaDAO : PersonaDAO? = basedatos.personaDao()
    var texto by remember { mutableStateOf("") }
    var casado by remember { mutableStateOf(false) }
    var p by remember { mutableStateOf(Persona(0, "", "")) }
    val cities = listOf("Madrid", "Barcelona", "Valencia", "Vigo", "Sevilla")
    var expanded by remember { mutableStateOf(false) }
    var selectedCity by remember { mutableStateOf(cities[0]) }
    Column {
        TextField(value = texto,
            onValueChange = {
                texto = it
            })
        Row {
            Text(text = "Estado Civil: ")
            Checkbox(checked = casado, onCheckedChange = {
                casado = it
            })
            Text(text = " Casado")

            OutlinedTextField(
                value = selectedCity,
                onValueChange = {},
                readOnly = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { expanded = true },
                label = { Text("Selecciona una ciudad") },
                shape = RoundedCornerShape(8.dp)
            )

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                cities.forEach { city ->
                    DropdownMenuItem(text = {
                        Text(text = city, fontSize = 16.sp)
                    },
                        onClick = {
                            selectedCity = city
                            expanded = false
                        }
                    )
                }
                Button({
                    //p = Persona(0, texto, estadoCivil)
                    //personaDAO?.insertar(p)
                    Log.d("depurando", "Nombre: " + texto + ", Casado: " + casado)
                }) {
                    Text(text = "Enviar")
                }
            }
        }
    }
}