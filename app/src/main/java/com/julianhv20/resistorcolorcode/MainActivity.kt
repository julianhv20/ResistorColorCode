package com.julianhv20.resistorcolorcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
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

        with(binding.actvColor1){
            setAdapter(colorsAdapter)
        }

        with(binding.actvColor2){
            setAdapter(colorsAdapter)
        }

        with(binding.actvColor3){
            setAdapter(multiplicadorAdapter)
        }
    }
}