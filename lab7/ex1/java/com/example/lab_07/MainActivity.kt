package com.example.lab_07

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lab_07.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSubmit.setOnClickListener {

            val text = binding.etName.text.toString()

            val intent = Intent(this, SecondActivity::class.java)

            intent.putExtra("TEXT-KEY", text)

            startActivity(intent)
        }
    }
}