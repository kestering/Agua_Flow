package com.example.agua_flow

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class FlowActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flow)

        // Recebe o email do usuário
        val email = intent.getStringExtra("USER_EMAIL")

        // Configura o avatar e o nome do usuário
        val profileImage = findViewById<ImageView>(R.id.profileImage)
        val textUsername = findViewById<TextView>(R.id.textAguaFlow)

        if (email == "user_masculino@example.com") {
            profileImage.setImageResource(R.drawable.avatar)
            textUsername.text = "Usuário Masculino"
        } else if (email == "user_feminino@example.com") {
            profileImage.setImageResource(R.drawable.avatar_feminino)
            textUsername.text = "Usuária Feminina"
        }

        // Encontra os botões e configura os listeners
        val button5min = findViewById<Button>(R.id.button5min)
        val button10min = findViewById<Button>(R.id.button10min)
        val button15min = findViewById<Button>(R.id.button15min)
        val buttonOutros = findViewById<Button>(R.id.buttonOutros)

        // Configura o listener para o botão 5 min
        button5min.setOnClickListener {
            val intent = Intent(this, TimerActivity::class.java)
            intent.putExtra("timer_duration", 5)
            intent.putExtra("USER_EMAIL", email)
            startActivity(intent)
        }

        // Configura o listener para o botão 10 min
        button10min.setOnClickListener {
            val intent = Intent(this, TimerActivity::class.java)
            intent.putExtra("timer_duration", 10)
            intent.putExtra("USER_EMAIL", email)
            startActivity(intent)
        }

        // Configura o listener para o botão 15 min
        button15min.setOnClickListener {
            val intent = Intent(this, TimerActivity::class.java)
            intent.putExtra("timer_duration", 15)
            intent.putExtra("USER_EMAIL", email)
            startActivity(intent)
        }

        // Configura o listener para o botão Outros
        buttonOutros.setOnClickListener {
            val intent = Intent(this, TimerActivity::class.java)
            intent.putExtra("timer_duration", 0)
            intent.putExtra("USER_EMAIL", email)
            startActivity(intent)
        }
    }
}
