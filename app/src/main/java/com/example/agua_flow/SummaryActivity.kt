package com.example.agua_flow

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SummaryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary)

        val profileImage = findViewById<ImageView>(R.id.profileImage)
        val textUsername = findViewById<TextView>(R.id.textAguaFlow)
        val textTimer = findViewById<TextView>(R.id.textTimer)
        val textLitros = findViewById<TextView>(R.id.textLitros)

        val email = intent.getStringExtra("USER_EMAIL")
        val totalLiters = intent.getDoubleExtra("TOTAL_LITERS", 0.0)

        if (email == "user_masculino@example.com") {
            profileImage.setImageResource(R.drawable.avatar)
            textUsername.text = "João"
        } else if (email == "user_feminino@example.com") {
            profileImage.setImageResource(R.drawable.avatar_feminino)
            textUsername.text = "Maria"
        }

        textLitros.text = String.format("%.2f L", totalLiters)
    }
}
