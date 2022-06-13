package com.julianhv20.resistorcolorcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import com.julianhv20.resistorcolorcode.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val colors = resources.getStringArray(R.array.color_list)

        val colorsAdapter = ArrayAdapter(this, R.layout.color_list, colors)
        val multiplicador = resources.getStringArray(R.array.multiplicador_list)
        val multiplicadorAdapter = ArrayAdapter(this, R.layout.color_list, multiplicador)

        with(binding.actvColor1) {
            setAdapter(colorsAdapter)
        }

        with(binding.actvColor2) {
            setAdapter(colorsAdapter)
        }

        with(binding.actvColor3) {
            setAdapter(multiplicadorAdapter)
        }

        binding.btnCalcular.setOnClickListener {
            val color1 = binding.actvColor1.text.toString()
            val color2 = binding.actvColor2.text.toString()
            val multiplicador = binding.actvColor3.text.toString()

            //Check for empty fields
            if (color1.isEmpty() || color2.isEmpty() || multiplicador.isEmpty()) {
                Toast.makeText(this, "Selecciona todos los campos", Toast.LENGTH_SHORT).show()

                //Clear result
                binding.tvResistance.text = ""
            } else {
                val colorBanda1 = color1(color1)
                val colorBanda2 = color2(color2)
                val colorBanda3 = color3(multiplicador)
                val resultado = calcularResistencia(colorBanda1, colorBanda2, colorBanda3)
                val resistencia = "${resultado} Ω"
                binding.tvResistance.text = resistencia
            }


        }
    }



    private fun color1(color1: String): String {

        return when (color1) {
            "Negro (0)" -> "0"
            "Cafe (1)" -> "1"
            "Rojo (2)" -> "2"
            "Naranja (3)" -> "3"
            "Amarillo (4)" -> "4"
            "Verde (5)" -> "5"
            "Azul (6)" -> "6"
            "Violeta (7)" -> "7"
            "Gris (8)" -> "8"
            "Blanco (9)" -> "9"

            else -> ""
        }
    }

    private fun color3(color3: String): String {

        return when (color3) {
            "Negro (x1)" -> "1"
            "Cafe (x10)" -> "10"
            "Rojo (x100)" -> "100"
            "Naranja (x1k)" -> "1000"
            "Amarillo (x10k)" -> "10000"
            "Verde (x100k)" -> "100000"
            "Azul (x1M)" -> "1000000"
            "Violeta (x10M)" -> "10000000"
            "Gris (x100M)" -> "100000000"
            "Blanco (x1G)" -> "1000000000"

            else -> ""


        }
    }

    private fun color2(color2: String): String {
        return when (color2) {
            "Negro (0)" -> "0"
            "Cafe (1)" -> "1"
            "Rojo (2)" -> "2"
            "Naranja (3)" -> "3"
            "Amarillo (4)" -> "4"
            "Verde (5)" -> "5"
            "Azul (6)" -> "6"
            "Violeta (7)" -> "7"
            "Gris (8)" -> "8"
            "Blanco (9)" -> "9"

            else -> ""
        }
    }

    private fun calcularResistencia(colorBanda1: String, colorBanda2: String, colorBanda3: String): CharSequence? {
        val numResistencia = colorBanda1 + colorBanda2
        val resultado = numResistencia.toInt() * colorBanda3.toInt()
        return resultado.toString()
    }

}
