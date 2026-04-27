package com.example.app_movil_ejercicios

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Ejercicio5 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio5)

        val editTextLimite = findViewById<EditText>(R.id.editTextLimite)
        val btnGenerar = findViewById<Button>(R.id.btnGenerar)
        val textViewPrimos = findViewById<TextView>(R.id.textViewPrimos)

        btnGenerar.setOnClickListener {

            val limite = editTextLimite.text.toString().toIntOrNull()

            if (limite != null && limite >= 2) {

                var resultado = ""

                for (num in 2..limite) {

                    var esPrimo = true

                    for (i in 2 until num) {
                        if (num % i == 0) {
                            esPrimo = false
                            break
                        }
                    }

                    if (esPrimo) {
                        resultado += "$num, "
                    }
                }

                textViewPrimos.text = resultado

            } else {
                textViewPrimos.text = "Ingrese un número mayor o igual a 2"
            }
        }

        val btnvolver5 = findViewById<Button>(R.id.btnvolver5)

        btnvolver5.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}