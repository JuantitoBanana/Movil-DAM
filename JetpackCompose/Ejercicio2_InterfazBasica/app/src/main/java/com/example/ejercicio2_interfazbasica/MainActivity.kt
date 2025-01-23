package com.example.ejercicio2_interfazbasica

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ejercicio2_interfazbasica.ui.theme.Ejercicio2_InterfazBasicaTheme
import kotlin.math.log

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ejercicio2_InterfazBasicaTheme {
                Scaffold(modifier = Modifier.fillMaxSize(), color = Color.Green) { innerPadding ->
                    Logo(
                        modifier = Modifier.padding(innerPadding)
                    )
                    Contacto(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun MiAplicacion(){
    MaterialTheme(
        colorScheme = MaterialTheme.colorScheme.copy(background = Color.Green),
        content = null
    )
}

@Composable
fun Logo(modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.android_logo)
    Column (verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier.fillMaxSize()) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = modifier
                .background(Color.Blue)
                .size(100.dp)

        )
        Text(
            text = "Jennifer Doe",
            fontSize = 50.sp
        )
        Text(
            text = "Android Developer Extraordinaire",
            color = Color.Green,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun Contacto(modifier: Modifier = Modifier){
    Column (verticalArrangement = Arrangement.Bottom, horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier.fillMaxSize()){
        Row (modifier = modifier.padding(bottom = 10.dp)){
            val logo1 = painterResource(R.drawable.baseline_local_phone_24)
            Image(
                painter = logo1,
                contentDescription = null
            )
            Text(
                text = "+11 (123) 444 555 666",
            )
        }
        Row (modifier = modifier.padding(bottom = 10.dp)){
            val logo2 = painterResource(R.drawable.baseline_share_24)
            Image(
                painter = logo2,
                contentDescription = null
            )
            Text(
                text = "@AndroidDev"
            )
        }
        Row (modifier = modifier.padding(bottom = 10.dp)) {
            val logo3 = painterResource(R.drawable.baseline_email_24)
            Image(
                painter = logo3,
                contentDescription = null
            )
            Text(
                text = "jen.doe@android.com"
            )
        }
    }
}