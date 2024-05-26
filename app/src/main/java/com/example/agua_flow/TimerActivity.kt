package com.example.agua_flow

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class TimerActivity : AppCompatActivity() {

    private lateinit var countDownTimer: CountDownTimer
    private lateinit var textViewTimer: TextView
    private var timerDuration: Int = 0
    private var millisUntilFinished: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timer)

        // Recupera o tempo do extra
        timerDuration = intent.getIntExtra("timer_duration", 0)

        // Encontra o TextView do timer
        textViewTimer = findViewById(R.id.textTimer)

        // Encontra o botão stop e configura o listener
        val stopButton = findViewById<ImageView>(R.id.stopButton)
        stopButton.setOnClickListener {
            stopTimer()
        }

        // Converte o tempo para milissegundos
        val durationInMillis = timerDuration * 60 * 1000L

        // Inicia a contagem regressiva
        startTimer(durationInMillis)
    }

    private fun startTimer(durationInMillis: Long) {
        countDownTimer = object : CountDownTimer(durationInMillis, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                this@TimerActivity.millisUntilFinished = millisUntilFinished
                // Calcula o tempo restante em minutos e segundos
                val minutes = millisUntilFinished / 1000 / 60
                val seconds = millisUntilFinished / 1000 % 60
                // Atualiza o TextView com o tempo restante
                textViewTimer.text = String.format("%02d:%02d", minutes, seconds)
            }

            override fun onFinish() {
                // Quando o tempo acabar, vai para a SummaryActivity
                navigateToSummaryActivity()
            }
        }.start()
    }

    private fun stopTimer() {
        countDownTimer.cancel()
        navigateToSummaryActivity()
    }

    private fun navigateToSummaryActivity() {
        // Calcula o tempo decorrido
        val elapsedMillis = timerDuration * 60 * 1000L - millisUntilFinished
        val elapsedMinutes = elapsedMillis / 1000 / 60
        val elapsedSeconds = elapsedMillis / 1000 % 60
        val elapsedTime = String.format("%02d:%02d", elapsedMinutes, elapsedSeconds)

        // Calcula os litros gastos
        val totalElapsedSeconds = elapsedMillis / 1000
        val litrosGastos = totalElapsedSeconds * 0.30 / 1000 // Convertendo ml para litros

        // Inicia a SummaryActivity com os dados
        val intent = Intent(this, SummaryActivity::class.java)
        intent.putExtra("total_time", elapsedTime)
        intent.putExtra("litros_gastos", litrosGastos)
        startActivity(intent)
        finish()
    }

    override fun onDestroy() {
        super.onDestroy()
        // Cancela a contagem regressiva se a atividade for destruída
        countDownTimer.cancel()
    }
}
