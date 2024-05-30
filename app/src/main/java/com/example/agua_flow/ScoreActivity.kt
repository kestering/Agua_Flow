package com.example.agua_flow

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ScoreActivity : AppCompatActivity() {
    private var currentScore: Int = 0 // Exemplo: Pegue essa pontuação do banco de dados ou de preferências compartilhadas

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        val textCurrentScore = findViewById<TextView>(R.id.textCurrentScore)
        val buttonBackToHome = findViewById<Button>(R.id.buttonBackToHome)

        // Exibir a pontuação atual
        textCurrentScore.text = currentScore.toString()

        buttonBackToHome.setOnClickListener {
            finish() // Voltar para a tela anterior
        }
    }
}
