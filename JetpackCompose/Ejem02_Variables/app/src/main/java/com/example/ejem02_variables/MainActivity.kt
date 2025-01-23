package com.example.ejem02_variables

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ejem02_variables.ui.theme.Ejem02_VariablesTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //InterfazPrincipal()
            //SnackbarExample()
            //SimpleSliderExample()
            SimpleSwitchExample()
        }
    }
}

@Composable
fun InterfazPrincipal(modifier: Modifier = Modifier) {
    var contador by remember { mutableIntStateOf(0) }
    var texto by remember { mutableStateOf("") }
    var persona by remember { mutableStateOf(Persona("", 0, "")) }
    var genero by remember { mutableStateOf("Hombre") }
    var isSet by remember { mutableStateOf(false) }
    var listaPersonas = remember { mutableListOf<Persona>() }
    var h : String = "Hombre"
    var m : String = "Mujer"
    if(!isSet) {
        Column {
            Row(
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Nombre:",
                    modifier = Modifier.weight(0.25f),
                )
                TextField(value = texto, modifier = Modifier.weight(0.75f), onValueChange = {
                    texto = it
                }
                )
            }

            Row(
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Button(onClick = {
                    contador++
                    Log.d("depurando", "Hola " + contador)
                }) {
                    Text(text = "Pulsar para incrementar")
                }
                Text(
                    text = contador.toString(),
                    modifier = Modifier.padding(20.dp)
                )
            }

            Row(
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(text = h)
                RadioButton(selected = genero == h, onClick = {
                    genero = h
                })
                Text(text = m)
                RadioButton(selected = genero == m, onClick = {
                    genero = m
                })
            }

            Row(
                modifier = Modifier
                    .padding(20.dp)

                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Button(onClick = {
                    persona = Persona(texto, contador, genero)
                    listaPersonas.add(persona)
                    isSet = true
                    Log.d("depurando", persona.toString())
                }) {
                    Text(text = "Mostrar Persona")
                }

            }
            LazyColumn {
                itemsIndexed(listaPersonas) { index, item ->
                    Text(listaPersonas[index].nombre, modifier = Modifier.padding(8.dp))
                }
            }

        }
    } else{
        Column {
            Row(
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {

                Text(text = "Hola " + persona.nombre.toString())
            }
            Row(
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Button(onClick = {
                    isSet = false
                }) {
                    Text(text = "Volver")
                }
            }
        }
    }
}

@Composable
fun SnackbarExample() {
    // Estado del SnackbarHost
    val snackbarHostState = remember { SnackbarHostState() }

    // Crear un alcance de corrutinas
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentAlignment = Alignment.Center
        ) {
            Button(onClick = {
                coroutineScope.launch {
                    snackbarHostState.showSnackbar(
                        message = "Hola Snackbar",
                        actionLabel = "OK"
                    )
                }
            }) {
                Text("Mostrar Snackbar")
            }
        }
    }
}

@Composable
fun SimpleSliderExample() {
    // Estado para almacenar el valor del slider
    var sliderValue by remember { mutableStateOf(0f) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(25.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Mostrar el valor actual del slider
        Text(text = "Valor: ${sliderValue.toInt()}")

        Spacer(modifier = Modifier.height(16.dp))

        // Slider para seleccionar un valor
        Slider(
            value = sliderValue,
            onValueChange = { sliderValue = it },
            valueRange = 0f..100f, // Rango de valores (0 a 100)
            steps = 100 // Número de pasos intermedios (opcional)
        )
    }
}

@Composable
fun SimpleSwitchExample() {
    // Estado para controlar el estado del switch
    var isChecked by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Mostrar el estado actual
        Text(text = if (isChecked) "Switch Encendido" else "Switch Apagado")

        Spacer(modifier = Modifier.height(16.dp))

        // Componente Switch
        Switch(
            checked = isChecked,
            onCheckedChange = { isChecked = it } // Actualizar el estado cuando cambia
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewInterfaz() {
    InterfazPrincipal()
}