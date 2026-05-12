package com.example.lab4

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        var act = arrayOf("Run", "Read", "Rest", "Eat", "Swim", "Walk")
        var text = findViewById<TextView>(R.id.textView)
        var button = findViewById<Button>(R.id.button)

        button.setOnClickListener {
            Toast.makeText(this, "Trwa losowanie..", Toast.LENGTH_SHORT).show()
            text.text = "..."
            button.isEnabled = false

            Handler(Looper.getMainLooper()).postDelayed({
                var index = Random.nextInt(act.size)
                text.text = act[index]
                button.isEnabled = true

            }, 2000)

        }
    }
}