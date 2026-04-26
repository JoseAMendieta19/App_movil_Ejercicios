package com.example.app_movil_ejercicios

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Ejercicio1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ejercicio1)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Referencias
        val rbCirculo = findViewById<RadioButton>(R.id.rbCirculo)
        val rbRectangulo = findViewById<RadioButton>(R.id.rbRectangulo)
        val rbTriangulo = findViewById<RadioButton>(R.id.rbTriangulo)

        val et1 = findViewById<EditText>(R.id.etValor1)
        val et2 = findViewById<EditText>(R.id.etValor2)
        val et3 = findViewById<EditText>(R.id.etValor3)

        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)
        val btnvolver1 = findViewById<Button>(R.id.btnvolver1)

        // Mostrar/ocultar campos según figura
        rbCirculo.setOnClickListener {
            et1.hint = "Radio"
            et2.visibility = View.GONE
            et3.visibility = View.GONE
        }

        rbRectangulo.setOnClickListener {
            et1.hint = "Base"
            et2.hint = "Altura"
            et2.visibility = View.VISIBLE
            et3.visibility = View.GONE
        }

        rbTriangulo.setOnClickListener {
            et1.hint = "Base"
            et2.hint = "Altura"
            et3.hint = "Lado 3"
            et2.visibility = View.VISIBLE
            et3.visibility = View.VISIBLE
        }

        // Botón calcular
        btnCalcular.setOnClickListener {

            val v1 = et1.text.toString().toDoubleOrNull()
            val v2 = et2.text.toString().toDoubleOrNull()
            val v3 = et3.text.toString().toDoubleOrNull()


            //  Validar negativos y ceros
            if ((v1 != null && v1 <= 0) ||
                (v2 != null && v2 <= 0) ||
                (v3 != null && v3 <= 0)) {

                if (v1 != null && v1 <= 0) et1.error = "Debe ser mayor que 0"
                if (v2 != null && v2 <= 0) et2.error = "Debe ser mayor que 0"
                if (v3 != null && v3 <= 0) et3.error = "Debe ser mayor que 0"

                return@setOnClickListener
            }


            if (rbCirculo.isChecked) {

                if (v1 != null) {
                    val area = String.format("%.2f", Math.PI * v1 * v1)
                    val perimetro = String.format("%.2f", 2 * Math.PI * v1)

                    tvResultado.text = "Área: $area\nPerímetro: $perimetro"
                } else {
                    tvResultado.text = "Ingrese el radio"
                }

            } else if (rbRectangulo.isChecked) {

                if (v1 != null && v2 != null) {
                    val area = String.format("%.2f", v1 * v2)
                    val perimetro = String.format("%.2f", 2 * (v1 + v2))

                    tvResultado.text = "Área: $area\nPerímetro: $perimetro"
                } else {
                    tvResultado.text = "Ingrese base y altura"
                }

            } else if (rbTriangulo.isChecked) {

                if (v1 != null && v2 != null && v3 != null) {
                    val area = String.format("%.2f", (v1 * v2) / 2)
                    val perimetro = String.format("%.2f", v1 + v2 + v3)

                    tvResultado.text = "Área: $area\nPerímetro: $perimetro"
                } else {
                    tvResultado.text = "Complete todos los valores"
                }

            } else {
                tvResultado.text = "Seleccione una figura"
            }
        }

        // Botón volver
        btnvolver1.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}