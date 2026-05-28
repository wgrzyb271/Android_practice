package com.example.lab_07

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lab_07.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tResult.setTypeface(null, android.graphics.Typeface.BOLD)
        binding.tResult.text = "${binding.tResult.text}:"

        val receivedText = intent.getStringExtra("TEXT-KEY") ?: ""
        binding.tResultValue.text = " $receivedText"
    }
}