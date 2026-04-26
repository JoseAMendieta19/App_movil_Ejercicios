package com.example.app_movil_ejercicios

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Ejercicio3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ejercicio3)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Referencias a los controles
        val TextNumber = findViewById<EditText>(R.id.TextNumber)
        val btncalcular = findViewById<Button>(R.id.btncalcular)
        val textViewTabla = findViewById<TextView>(R.id.textViewTabla)

        // Evento del botón
        btncalcular.setOnClickListener {

            val numero = TextNumber.text.toString().toIntOrNull()

            if (numero != null) {

                var tabla = ""

                for (i in 1..10) {
                    tabla += "$numero x $i = ${numero * i}\n"
                }

                textViewTabla.text = tabla

            } else {
                textViewTabla.text = "Ingrese un número válido"
            }
        }
    }
}