package com.example.agua_flow

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class TimerActivity : AppCompatActivity() {
    private lateinit var countDownTimer: CountDownTimer
    private var isRunning: Boolean = false
    private var timeLeftInMillis: Long = 0
    private var totalLiters: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timer)

        val textTimer = findViewById<TextView>(R.id.textTimer)
        val stopButton = findViewById<ImageView>(R.id.stopButton)

        // Recebe o email do usuário
        val email = intent.getStringExtra("USER_EMAIL")

        // Configura a duração do timer
        val duration = intent.getIntExtra("timer_duration", 0)
        timeLeftInMillis = duration * 60000L // Converte minutos para milissegundos

        startTimer(textTimer)

        stopButton.setOnClickListener {
            if (isRunning) {
                countDownTimer.cancel()
                isRunning = false
                totalLiters = calculateLiters(timeLeftInMillis)
                navigateToSummary(email, totalLiters)
            }
        }
    }

    private fun startTimer(textTimer: TextView) {
        countDownTimer = object : CountDownTimer(timeLeftInMillis, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                timeLeftInMillis = millisUntilFinished
                val secondsLeft = millisUntilFinished / 1000
                textTimer.text = String.format("%02d:%02d:%02d",
                    secondsLeft / 3600,
                    (secondsLeft % 3600) / 60,
                    secondsLeft % 60)
            }

            override fun onFinish() {
                isRunning = false
                totalLiters = calculateLiters(0)
                navigateToSummary(intent.getStringExtra("USER_EMAIL"), totalLiters)
            }
        }.start()
        isRunning = true
    }

    private fun calculateLiters(timeLeftInMillis: Long): Double {
        val secondsElapsed = (intent.getIntExtra("timer_duration", 0) * 60) - (timeLeftInMillis / 1000)
        return secondsElapsed * 0.3
    }

    private fun navigateToSummary(email: String?, totalLiters: Double) {
        val intent = Intent(this, SummaryActivity::class.java)
        intent.putExtra("USER_EMAIL", email)
        intent.putExtra("TOTAL_LITERS", totalLiters)
        startActivity(intent)
        finish()
    }
}
