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

class Ejercicio4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ejercicio4)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val etPeso = findViewById<EditText>(R.id.etPeso)
        val etAltura = findViewById<EditText>(R.id.etAltura)
        val btnCalcular = findViewById<Button>(R.id.btnCalcularIMC)
        val tvResultado = findViewById<TextView>(R.id.tvResultadoIMC)
        val btnvolver4 = findViewById<Button>(R.id.btnvolver4)

        btnCalcular.setOnClickListener {

            val peso = etPeso.text.toString().toDoubleOrNull()
            val altura = etAltura.text.toString().toDoubleOrNull()

            // Validación
            if (peso == null) {
                etPeso.error = "Ingrese el peso"
                return@setOnClickListener
            }

            if (altura == null) {
                etAltura.error = "Ingrese la altura"
                return@setOnClickListener
            }

            if (peso <= 0 || altura <= 0) {
                tvResultado.text = "Valores deben ser mayores a 0"
                return@setOnClickListener
            }

            // Cálculo IMC
            val imc = peso / (altura * altura)
            val imcFormateado = String.format("%.2f", imc)

            // Categoría
            val categoria = when {
                imc < 18.5 -> "Bajo peso"
                imc < 25 -> "Normal"
                imc < 30 -> "Sobrepeso"
                else -> "Obesidad"
            }

            tvResultado.text = "IMC: $imcFormateado\nCategoría: $categoria"
        }

        btnvolver4.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}