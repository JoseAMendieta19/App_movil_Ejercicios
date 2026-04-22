package com.example.app_movil_ejercicios

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btnejercicio1 = findViewById<Button>(R.id.btnejercicio1)
        val btnejercicio2 = findViewById<Button>(R.id.btnejercicio2)
        val btnejercicio3 = findViewById<Button>(R.id.btnejercicio3)
        val btnejercicio4 = findViewById<Button>(R.id.btnejercicio4)
        val btnejercicio5 = findViewById<Button>(R.id.btnejercicio5)
        val btnejercicio6 = findViewById<Button>(R.id.btnejercicio6)
        val btnejercicio7 = findViewById<Button>(R.id.btnejercicio7)
        val btnejercicio8 = findViewById<Button>(R.id.btnejercicio8)

        btnejercicio1.setOnClickListener {
            val intent = Intent(this, Ejercicio1::class.java)
            startActivity(intent)
        }
        btnejercicio2.setOnClickListener {
            val intent = Intent(this, Ejercicio2::class.java)
            startActivity(intent)
        }
        btnejercicio3.setOnClickListener {
            val intent = Intent(this, Ejercicio3::class.java)
            startActivity(intent)
        }
        btnejercicio4.setOnClickListener {
            val intent = Intent(this, Ejercicio4::class.java)
            startActivity(intent)
        }
        btnejercicio5.setOnClickListener {
            val intent = Intent(this, Ejercicio5::class.java)
            startActivity(intent)
        }
        btnejercicio6.setOnClickListener {
            val intent = Intent(this, Ejercicio6::class.java)
            startActivity(intent)
        }
        btnejercicio7.setOnClickListener {
            val intent = Intent(this, Ejercicio7::class.java)
            startActivity(intent)
        }
        btnejercicio8.setOnClickListener {
            val intent = Intent(this, Ejercicio8::class.java)
            startActivity(intent)
        }
    }

}