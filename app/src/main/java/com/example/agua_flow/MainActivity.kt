package com.example.agua_flow

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textAguaFlow = findViewById<TextView>(R.id.textAguaFlow)
        val lineBelowText = findViewById<View>(R.id.lineBelowText)

        val fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in)

        textAguaFlow.startAnimation(fadeIn)
        lineBelowText.startAnimation(fadeIn)

        Handler(Looper.getMainLooper()).postDelayed({
            // Inicia a LoginActivity
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            // Fecha a MainActivity
            finish()
        }, 3000) // 3000 milissegundos = 3 segundos
    }
}
