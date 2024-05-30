package com.example.agua_flow

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class FlowActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flow)

        val profileImage = findViewById<ImageView>(R.id.profileImage)
        val button5min = findViewById<Button>(R.id.button5min)
        val button10min = findViewById<Button>(R.id.button10min)
        val button15min = findViewById<Button>(R.id.button15min)
        val buttonOutros = findViewById<Button>(R.id.buttonOutros)
        val email = intent.getStringExtra("USER_EMAIL")
        val activityType = intent.getStringExtra("ACTIVITY_TYPE")
        val waterUsagePerMinute = intent.getDoubleExtra("WATER_USAGE_PER_MINUTE", 0.0)

        if (email == "user_masculino@example.com") {
            profileImage.setImageResource(R.drawable.avatar)
        } else if (email == "user_feminino@example.com") {
            profileImage.setImageResource(R.drawable.avatar_feminino)
        }

        button5min.setOnClickListener {
            startTimerActivity(5, activityType, waterUsagePerMinute)
        }

        button10min.setOnClickListener {
            startTimerActivity(10, activityType, waterUsagePerMinute)
        }

        button15min.setOnClickListener {
            startTimerActivity(15, activityType, waterUsagePerMinute)
        }

        buttonOutros.setOnClickListener {
            startTimerActivity(0, activityType, waterUsagePerMinute)
        }
    }

    private fun startTimerActivity(minutes: Int, activityType: String?, waterUsagePerMinute: Double) {
        val intent = Intent(this, TimerActivity::class.java).apply {
            putExtra("timer_duration", minutes)
            putExtra("ACTIVITY_TYPE", activityType)
            putExtra("WATER_USAGE_PER_MINUTE", waterUsagePerMinute)
        }
        startActivity(intent)
    }
}
