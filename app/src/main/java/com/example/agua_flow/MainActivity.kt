package com.example.agua_flow

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Handler(Looper.getMainLooper()).postDelayed({
            // Inicia a HomeActivity
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            // Fecha a MainActivity
            finish()
        }, 1000) // 3000 milissegundos = 3 segundos
    }
}
