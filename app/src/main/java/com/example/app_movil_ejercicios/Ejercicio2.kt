package com.example.app_movil_ejercicios

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Ejercicio2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ejercicio2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val etTemp = findViewById<EditText>(R.id.etTemperatura)
        val spinner = findViewById<Spinner>(R.id.spConversion)
        val btnConvertir = findViewById<Button>(R.id.btnConvertir)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)
        val btnvolver2 = findViewById<Button>(R.id.btnvolver2)

        // Opciones del Spinner
        val opciones = arrayOf(
            "Seleccione una opción",
            "Celsius a Fahrenheit",
            "Fahrenheit a Celsius"
        )

        // Adapter con colores personalizados
        val adapter = object : ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opciones) {
            override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
                val view = super.getView(position, convertView, parent)
                (view as TextView).setTextColor(Color.parseColor("#1A3A6A"))
                return view
            }
            override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
                val view = super.getDropDownView(position, convertView, parent)
                (view as TextView).setTextColor(Color.parseColor("#1A3A6A"))
                view.setBackgroundColor(Color.parseColor("#EEF4FB"))
                return view
            }
        }
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
        spinner.setSelection(0)

        // Cambiar hint dinámicamente
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                when (position) {
                    1 -> etTemp.hint = "Ingrese °C"
                    2 -> etTemp.hint = "Ingrese °F"
                    else -> etTemp.hint = "Valor"
                }
            }
            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

        // Botón convertir
        btnConvertir.setOnClickListener {
            val valor = etTemp.text.toString().toDoubleOrNull()
            val seleccion = spinner.selectedItemPosition

            if (seleccion == 0) {
                tvResultado.text = "Seleccione una conversión"
                return@setOnClickListener
            }

            if (valor == null) {
                etTemp.error = "Ingrese un valor"
                return@setOnClickListener
            }

            val (resultado, unidad) = when (seleccion) {
                1 -> {
                    val res = valor * 9 / 5 + 32
                    Pair(String.format("%.2f", res), "°F")
                }
                2 -> {
                    val res = (valor - 32) * 5 / 9
                    Pair(String.format("%.2f", res), "°C")
                }
                else -> Pair("Error", "")
            }

            tvResultado.text = "Resultado: $resultado $unidad"
        }

        // Botón volver
        btnvolver2.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}