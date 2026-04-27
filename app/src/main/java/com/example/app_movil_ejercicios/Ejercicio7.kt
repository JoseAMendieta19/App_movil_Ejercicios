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
        val spinnerTipo = findViewById<Spinner>(R.id.spinnerTipo)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val textViewResultado = findViewById<TextView>(R.id.textViewResultado)

        btnCalcular.setOnClickListener {

            val capital = editCapital.text.toString().toDoubleOrNull()
            val tasaAnual = editTasa.text.toString().toDoubleOrNull()
            val periodos = editPeriodos.text.toString().toIntOrNull() // años

            if (capital != null && tasaAnual != null && periodos != null) {

                // Veces que se capitaliza por año según el Spinner
                val n = when (spinnerTipo.selectedItem.toString().lowercase()) {
                    "anual"      -> 1
                    "semestral"  -> 2
                    "trimestral" -> 4
                    "mensual"    -> 12
                    else         -> 1
                }

                val r = tasaAnual / 100  // tasa anual en decimal
                var resultado = ""

                // Muestra el monto al final de cada AÑO
                for (i in 1..periodos) {
                    val monto = capital * (1 + r / n).pow((n * i).toDouble())
                    resultado += "Año $i: $${String.format("%.2f", monto)}\n"
                }

                val montoFinal = capital * (1 + r / n).pow((n * periodos).toDouble())
                val interesGanado = montoFinal - capital

                resultado += "\nMonto final:     $${String.format("%.2f", montoFinal)}"
                resultado += "\nInterés ganado:  $${String.format("%.2f", interesGanado)}"

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