package com.example.app_movil_ejercicios

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class Ejercicio6 : AppCompatActivity() {

    var numeroSecreto = Random.nextInt(1, 101)
    var intentos = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio6)

        val editTextNumero = findViewById<EditText>(R.id.editTextNumero)
        val btnProbar = findViewById<Button>(R.id.btnProbar)
        val textViewPista = findViewById<TextView>(R.id.textViewPista)
        val textViewIntentos = findViewById<TextView>(R.id.textViewIntentos)
        val btnReiniciar = findViewById<Button>(R.id.button2)
        val btnvolver6 = findViewById<Button>(R.id.btnvolver6)


        btnProbar.setOnClickListener {

            val numero = editTextNumero.text.toString().toIntOrNull()

            if (numero != null) {

                intentos++

                if (numero < numeroSecreto) {
                    textViewPista.text = "El número es mayor"

                } else if (numero > numeroSecreto) {
                    textViewPista.text = "El número es menor"

                } else {
                    textViewPista.text = "¡Correcto! Adivinaste"
                }

                textViewIntentos.text = "Intentos: $intentos"

            } else {
                textViewPista.text = "Ingrese un número válido"
            }
        }
        btnReiniciar.setOnClickListener {

            numeroSecreto = Random.nextInt(1, 101)
            intentos = 0

            editTextNumero.text.clear()

            textViewPista.text = ""
            textViewIntentos.text = "Intentos: 0"
        }
        btnvolver6.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}