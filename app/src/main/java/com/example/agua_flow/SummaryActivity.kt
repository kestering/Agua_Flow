package com.example.agua_flow

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SummaryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary)

        val profileImage = findViewById<ImageView>(R.id.profileImage)
        val textUsername = findViewById<TextView>(R.id.textUsername)
        val textTimer = findViewById<TextView>(R.id.textTimer)
        val textLitros = findViewById<TextView>(R.id.textLitros)
        val textSummaryMessage = findViewById<TextView>(R.id.textSummaryMessage)
        val buttonBackToHome = findViewById<Button>(R.id.buttonBackToHome)
        val email = intent.getStringExtra("USER_EMAIL")

        if (email == "user_masculino@example.com") {
            profileImage.setImageResource(R.drawable.avatar)
            textUsername.text = "João"
        } else if (email == "user_feminino@example.com") {
            profileImage.setImageResource(R.drawable.avatar_feminino)
            textUsername.text = "Maria"
        }

        val totalLitersUsed = intent.getDoubleExtra("total_liters_used", 0.0)
        val litersSaved = intent.getDoubleExtra("liters_saved", 0.0)
        val pointsEarned = intent.getIntExtra("points_earned", 0)
        val timeElapsed = intent.getLongExtra("time_elapsed", 0)

        val minutes = timeElapsed / 60000
        val seconds = (timeElapsed % 60000) / 1000

        textTimer.text = String.format("%02d:%02d", minutes, seconds)
        textLitros.text = String.format("%.2fL", litersSaved)
        textSummaryMessage.text = "Parabéns! Você economizou %.2f litros de água e ganhou %d pontos".format(litersSaved, pointsEarned)

        buttonBackToHome.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            intent.putExtra("USER_EMAIL", email)
            startActivity(intent)
            finish()
        }
    }
}
