package com.example.ejem1_jetpackcomposeholamundo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ejem1_jetpackcomposeholamundo.ui.theme.Ejem1_JetpackComposeHolaMundoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ejem1_JetpackComposeHolaMundoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
     Column  (modifier = Modifier.background(Color.Red).fillMaxWidth().padding(18.dp)){
        Text(
            text = "Hello $name!"
        )

         Row (modifier = Modifier.background(Color.Yellow).fillMaxWidth().padding(9.dp)){
             Text(
                 text = "Hola $name!"
             )

             Text(
                 text = "Hallo $name!"
             )
         }

         Row (modifier = Modifier.background(Color.Red).fillMaxWidth().padding(18.dp)){
             Text(
                 text = "Hola $name!"
             )

             Text(
                 text = "Hallo $name!"
             )
         }
    }
}


//@PreviewScreenSizes
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    Ejem1_JetpackComposeHolaMundoTheme {
        Greeting("DAM")
    }
}