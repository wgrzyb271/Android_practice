package com.lab.kartka.lab4

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.lab.kartka.lab4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.buttonSubmit.setOnClickListener {
            val heightStr = binding.editTextHeight.text.toString()
            val weightStr = binding.editTextWeight.text.toString()

            if (heightStr.isNotEmpty() && weightStr.isNotEmpty()) {
                val height = heightStr.toFloat() / 100
                val weight = weightStr.toFloat()

                if (height > 0) {
                    val bmi = weight / (height * height)
                    displayResult(bmi)
                }
            } else {
                binding.textViewTitle.text = "Insert data!"
                binding.textViewTitle.setTextColor(ContextCompat.getColor(this, R.color.red_main))
            }
        }
    }

    private fun displayResult(bmi: Float) {
        val (description, colorRes) = when {
            bmi < 18.5 -> "Underweight" to R.color.red_main
            bmi in 18.5..24.99 -> "Normal weight" to R.color.green_main
            bmi in 25.0..29.99 -> "Overweight" to R.color.orange_main
            else -> "Obesity" to R.color.red_main
        }

        binding.textViewTitle.text = "BMI: %.2f\n%s".format(bmi, description)
        binding.textViewTitle.setTextColor(ContextCompat.getColor(this, colorRes))
    }
}