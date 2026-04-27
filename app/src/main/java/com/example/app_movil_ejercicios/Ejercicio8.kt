package com.example.app_movil_ejercicios

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Ejercicio8 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ejercicio8)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val etCantidad = findViewById<EditText>(R.id.etCantidad)
        val spOrigen = findViewById<Spinner>(R.id.spOrigen)
        val spDestino = findViewById<Spinner>(R.id.spDestino)
        val btnConvertir = findViewById<Button>(R.id.btnConvertir)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)
        val btnvolver8 = findViewById<Button>(R.id.btnvolver8)

        // Lista de monedas
        val monedas = arrayOf(
            "Seleccione",
            "USD (Dólar)",
            "EUR (Euro)",
            "PEN (Sol peruano)",
            "JPY (Yen japones)",
            "MXN (Peso mexicano)"
        )

        // Adapter con colores del diseño
        val adapter = object : ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, monedas) {
            override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
                val view = super.getView(position, convertView, parent)
                (view as TextView).setTextColor(Color.parseColor("#1A3A6A"))
                view.setBackgroundColor(Color.parseColor("#FFFFFF"))
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

        spOrigen.adapter = adapter
        spDestino.adapter = adapter

        // Tasas respecto al USD
        val tasasUSD = mapOf(
            "USD (Dólar)" to 1.0,
            "EUR (Euro)" to 0.92,
            "PEN (Sol peruano)" to 3.7,
            "JPY (Yen japones)" to 150.0,
            "MXN (Peso mexicano)" to 17.0
        )

        btnConvertir.setOnClickListener {

            val cantidad = etCantidad.text.toString().toDoubleOrNull()
            val origen = spOrigen.selectedItem.toString()
            val destino = spDestino.selectedItem.toString()

            if (cantidad == null) {
                etCantidad.error = "Ingrese una cantidad"
                return@setOnClickListener
            }

            if (cantidad <= 0) {
                etCantidad.error = "Debe ser mayor a 0"
                return@setOnClickListener
            }

            if (origen == "Seleccione" || destino == "Seleccione") {
                tvResultado.text = "Seleccione ambas monedas"
                return@setOnClickListener
            }

            val enUSD = cantidad / tasasUSD[origen]!!
            val resultado = enUSD * tasasUSD[destino]!!
            val resFormateado = String.format("%.2f", resultado)

            tvResultado.text = "Resultado: $resFormateado $destino"
        }

        btnvolver8.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}