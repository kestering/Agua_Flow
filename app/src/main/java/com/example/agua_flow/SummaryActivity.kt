package com.example.agua_flow

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SummaryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary)

        // Recupera os dados passados pela TimerActivity
        val totalTime = intent.getStringExtra("total_time") ?: "00:00"
        val litrosGastos = intent.getDoubleExtra("litros_gastos", 0.0)

        // Exibe os dados nos TextViews correspondentes
        val textViewTimer = findViewById<TextView>(R.id.textTimer)
        textViewTimer.text = totalTime

        val textViewLitros = findViewById<TextView>(R.id.textLitros)
        textViewLitros.text = String.format("%.2f L", litrosGastos)
    }
}
