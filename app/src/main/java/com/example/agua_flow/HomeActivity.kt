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
        val email = intent.getStringExtra("USER_EMAIL")

        if (email == "user_masculino@example.com") {
            profileImage.setImageResource(R.drawable.avatar)
            textUsername.text = "João"
        } else if (email == "user_feminino@example.com") {
            profileImage.setImageResource(R.drawable.avatar_feminino)
            textUsername.text = "Maria"
        }

        buttonStartFlow.setOnClickListener {
            val intent = Intent(this, FlowActivity::class.java)
            intent.putExtra("USER_EMAIL", email)
            startActivity(intent)
        }
    }
}
