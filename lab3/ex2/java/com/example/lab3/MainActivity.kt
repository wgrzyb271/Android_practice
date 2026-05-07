package com.example.lab3

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val reset = findViewById<Button>(R.id.button2)
        val inc = findViewById<Button>(R.id.button1)
        val dec = findViewById<Button>(R.id.button3)

        val textView = findViewById<TextView>(R.id.textView)
        reset.setOnClickListener {
            textView.text = "Wyzerowano zliczanie"
            textView.postDelayed({textView.text="0"}, 1000)

        }

        inc.setOnClickListener {
            val data = textView.text.toString().toInt() + 1
            textView.text = "$data"
        }

        dec.setOnClickListener {
            val data = textView.text.toString().toInt() - 1
            textView.text = "$data"
        }
    }
}