package com.example.agua_flow

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class TimerActivity : AppCompatActivity() {

    private lateinit var timer: CountDownTimer
    private var totalLitersUsed = 0.0
    private var litersSaved = 0.0
    private var pointsEarned = 0
    private var timeElapsed: Long = 0
    private var waterUsagePerMinute: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timer)

        val textTimer = findViewById<TextView>(R.id.textTimer)
        val stopButton = findViewById<ImageView>(R.id.stopButton)

        val durationInMinutes = intent.getIntExtra("timer_duration", 0)
        val durationInMillis = (durationInMinutes * 60 * 1000).toLong()
        waterUsagePerMinute = intent.getDoubleExtra("WATER_USAGE_PER_MINUTE", 0.0)

        timer = object : CountDownTimer(durationInMillis, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val seconds = millisUntilFinished / 1000
                val minutes = seconds / 60
                val remainingSeconds = seconds % 60
                textTimer.text = String.format("%02d:%02d", minutes, remainingSeconds)
                totalLitersUsed += waterUsagePerMinute / 60
                timeElapsed = durationInMillis - millisUntilFinished
            }

            override fun onFinish() {
                calculateSavings()
                goToSummary()
            }
        }.start()

        stopButton.setOnClickListener {
            timer.cancel()
            calculateSavings()
            goToSummary()
        }
    }

    private fun calculateSavings() {
        // Calcular a economia de água e pontos
        litersSaved = totalLitersUsed // Simplificando para demonstração
        pointsEarned = (litersSaved * 10).toInt()
    }

    private fun goToSummary() {
        val intent = Intent(this, SummaryActivity::class.java).apply {
            putExtra("total_liters_used", totalLitersUsed)
            putExtra("liters_saved", litersSaved)
            putExtra("points_earned", pointsEarned)
            putExtra("time_elapsed", timeElapsed)
        }
        startActivity(intent)
        finish()
    }
}
