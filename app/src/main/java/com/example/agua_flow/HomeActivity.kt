package com.example.agua_flow

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val profileImage = findViewById<ImageView>(R.id.profileImage)
        val textUsername = findViewById<TextView>(R.id.textUsername)
        val buttonStartFlow = findViewById<Button>(R.id.buttonStartFlow)
        val buttonScore = findViewById<Button>(R.id.buttonScore)
        val buttonExit = findViewById<Button>(R.id.buttonExit)
        val email = intent.getStringExtra("USER_EMAIL")

        if (email == "user_masculino@example.com") {
            profileImage.setImageResource(R.drawable.avatar)
            textUsername.text = "João"
        } else if (email == "user_feminino@example.com") {
            profileImage.setImageResource(R.drawable.avatar_feminino)
            textUsername.text = "Maria"
        }

        buttonStartFlow.setOnClickListener {
            val intent = Intent(this, SelectActivityTypeActivity::class.java)
            intent.putExtra("USER_EMAIL", email)
            startActivity(intent)
        }

        buttonScore.setOnClickListener {
            val intent = Intent(this, SummaryActivity::class.java)
            intent.putExtra("USER_EMAIL", email)
            startActivity(intent)
        }

        buttonExit.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            finish()
        }
    }
}
