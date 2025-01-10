package com.example.ejemplo0_holamundo

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        Log.d("Depurando", getString(R.string.saludo_log))

        var numero:Int = 10
        Log.d("Depurando", "El numero es $numero")
        //Int, Long, Float, Double, Char, String, Boolean

        var altura:Double = 1.75
        altura = altura*0.2

        Log.d("Depurando", "La altura es $altura")

        var datoFloat: Float = 1.0F
        var datoLong: Long = 1L

        if (numero > 10 && numero < 20){
            Log.d("Depurando", "El numero es mayor a 10")
            Log.d("Depurando", "El numero es menor a 20")

        }
        else Log.d("Depurando", "El numero es $numero")


        var edad = 19
        var tipoUsuario = if(edad>17) "Mayor de edad" else "Menor de edad"

        Log.d("Depurando", tipoUsuario)

        var posibleNulo:String? = null
        if (posibleNulo.isNullOrBlank()) Log.d("depurando", "La variable es nula o vacía")
        else Log.d("depurando", "La variable tiene contenido")

        when (edad) {
            18 -> Log.d("depurando", "Tiene 18 años")
            in 19..25 -> Log.d("depurando", "Tiene entre 19 y 25")
            1,2,3,4 -> Log.d("depurando", "Tiene entre 1, 2, 3 o 4 años")
            else -> Log.d("depurando", "Tiene otra edad")
        }

        var fecha:String = "2021-09-01"
        when(fecha.substring(0,4)){
            "2021" -> Log.d("depurando", "Es del 2021")
            "2022" -> Log.d("depurando", "Es del 2022")
            else -> Log.d("depurando", "Es otra fecha")
        }

        //Hoy 20 de Septiembre

        var arrayNumber = arrayOf(1,2,3,4,5)
        var arrayNumber2 = arrayOf<Int>(1,2,3,4,5)
        var arrayNumber3 = intArrayOf(1,2,3,4,5)
        var arrayCharacters = charArrayOf('a','b','c','d','e')

        for (numero in arrayNumber){
            Log.d("depurando", "El número es $numero")
        }
        for (i in 0 until arrayNumber.size){
            Log.d("depurando", "El número es $numero")
            Log.d("depurando", "El número es ${arrayNumber.get(i)}")
        }
        var i = 0
        do {
            Log.d("depurando", "El número es ${arrayNumber[i]}")
            i++
        }while (i<arrayNumber.size)


        i=0
        while (i<arrayNumber.size){
            Log.d("depurando", "El número es ${arrayNumber[i]}")
            i++
        }

        //Arrays bidimensionales
        var matriz: Array<Array<Int>> = arrayOf(
            arrayOf(1, 2, 3),
            arrayOf(4, 5, 6),
            arrayOf(7, 8, 9)
        )
        for (fila in matriz) {
            for (elemento in fila)
                Log.d("depurando", "El número es $elemento")

        }
    }
}