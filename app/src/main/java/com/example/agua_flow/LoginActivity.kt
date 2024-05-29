package com.example.agua_flow

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val buttonLogin = findViewById<Button>(R.id.buttonLogin)
        val editTextEmail = findViewById<EditText>(R.id.editTextEmail)
        val editTextPassword = findViewById<EditText>(R.id.editTextPassword)

        buttonLogin.setOnClickListener {
            val email = editTextEmail.text.toString()
            val password = editTextPassword.text.toString()

            if (isValidLogin(email, password)) {
                val intent = Intent(this, HomeActivity::class.java).apply {
                    putExtra("USER_EMAIL", email)
                }
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Login inválido", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun isValidLogin(email: String, password: String): Boolean {
        return (email == "user_masculino@example.com" && password == "123456") ||
                (email == "user_feminino@example.com" && password == "123456")
    }
}
