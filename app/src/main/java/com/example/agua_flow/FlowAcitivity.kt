package com.example.agua_flow

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class FlowActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flow)

        // Encontra os botões e configura os listeners
        val button5min = findViewById<Button>(R.id.button5min)
        val button10min = findViewById<Button>(R.id.button10min)
        val button15min = findViewById<Button>(R.id.button15min)
        val buttonOutros = findViewById<Button>(R.id.buttonOutros)

        // Configura o listener para o botão 5 min
        button5min.setOnClickListener {
            // Cria uma intenção para iniciar a TimerActivity
            val intent = Intent(this, TimerActivity::class.java)
            // Adiciona um extra para passar o tempo selecionado
            intent.putExtra("timer_duration", 5)
            startActivity(intent)
        }

        // Configura o listener para o botão 10 min
        button10min.setOnClickListener {
            // Cria uma intenção para iniciar a TimerActivity
            val intent = Intent(this, TimerActivity::class.java)
            // Adiciona um extra para passar o tempo selecionado
            intent.putExtra("timer_duration", 10)
            startActivity(intent)
        }

        // Configura o listener para o botão 15 min
        button15min.setOnClickListener {
            // Cria uma intenção para iniciar a TimerActivity
            val intent = Intent(this, TimerActivity::class.java)
            // Adiciona um extra para passar o tempo selecionado
            intent.putExtra("timer_duration", 15)
            startActivity(intent)
        }

        // Configura o listener para o botão Outros
        buttonOutros.setOnClickListener {
            // Cria uma intenção para iniciar a TimerActivity
            val intent = Intent(this, TimerActivity::class.java)
            // Adiciona um extra para passar o tempo selecionado
            intent.putExtra("timer_duration", 0) // 0 para "Outros"
            startActivity(intent)
        }
    }
}
