package com.example.app_movil_ejercicios

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.pow

class Ejercicio7 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio7)

        val editCapital = findViewById<EditText>(R.id.editCapital)
        val editTasa = findViewById<EditText>(R.id.editTasa)
        val editPeriodos = findViewById<EditText>(R.id.editPeriodos)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val textViewResultado = findViewById<TextView>(R.id.textViewResultado)

        btnCalcular.setOnClickListener {

            val capital = editCapital.text.toString().toDoubleOrNull()
            val tasa = editTasa.text.toString().toDoubleOrNull()
            val periodos = editPeriodos.text.toString().toIntOrNull()

            if (capital != null && tasa != null && periodos != null) {

                val r = tasa / 100
                var resultado = ""

                for (i in 1..periodos) {
                    val monto = capital * (1 + r).pow(i)
                    resultado += "Período $i: $${String.format("%.2f", monto)}\n"
                }

                val final = capital * (1 + r).pow(periodos)

                resultado += "\nMonto final: $${String.format("%.2f", final)}"

                textViewResultado.text = resultado

            } else {
                textViewResultado.text = "Complete todos los datos"
            }
        }

        val btnvolver7 = findViewById<Button>(R.id.btnvolver7)

        btnvolver7.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}