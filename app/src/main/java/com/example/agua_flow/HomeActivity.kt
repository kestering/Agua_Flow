package com.example.agua_flow

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Encontra o botão e configura o listener
        val buttonStartFlow = findViewById<Button>(R.id.buttonStartFlow)
        buttonStartFlow.setOnClickListener {
            // Cria uma intenção para iniciar a FlowActivity
            val intent = Intent(this, FlowActivity::class.java)
            startActivity(intent)
        }
    }
}
