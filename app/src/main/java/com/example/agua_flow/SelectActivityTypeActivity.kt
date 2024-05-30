package com.example.agua_flow

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SelectActivityTypeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_activity_type)

        val buttonShower = findViewById<Button>(R.id.buttonShower)
        val buttonWashDishes = findViewById<Button>(R.id.buttonWashDishes)
        val buttonCleanYard = findViewById<Button>(R.id.buttonCleanYard)

        buttonShower.setOnClickListener {
            navigateToFlowActivity("Banho", 12.0) // Exemplo: 12 litros por minuto
        }

        buttonWashDishes.setOnClickListener {
            navigateToFlowActivity("Lavar Louça", 8.0) // Exemplo: 8 litros por minuto
        }

        buttonCleanYard.setOnClickListener {
            navigateToFlowActivity("Lavar o Quintal", 15.0) // Exemplo: 15 litros por minuto
        }

        // Adicione listeners para mais botões aqui, se necessário
    }

    private fun navigateToFlowActivity(activityType: String, waterUsagePerMinute: Double) {
        val intent = Intent(this, FlowActivity::class.java).apply {
            putExtra("ACTIVITY_TYPE", activityType)
            putExtra("WATER_USAGE_PER_MINUTE", waterUsagePerMinute)
        }
        startActivity(intent)
    }
}
