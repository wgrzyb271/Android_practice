package com.example.lab4

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.navigationevent.NavigationEventInfo
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val text = findViewById<TextView>(R.id.textView)
        val reset_text = text.text.toString()
        val button = findViewById<Button>(R.id.button)
        val left_coin = findViewById<ImageView>(R.id.imageView)
        val right_coin = findViewById<ImageView>(R.id.imageView1)

        button.setOnClickListener {
            Toast.makeText(this, "Flipping coins..", Toast.LENGTH_SHORT).show()
            text.text = reset_text


            left_coin.setImageResource(R.drawable.multiple_coins)
            right_coin.setImageResource(R.drawable.multiple_coins)


            left_coin.rotation = 0f
            right_coin.rotation = 0f
            button.isEnabled = false

            Handler(Looper.getMainLooper()).postDelayed({

                val leftResult = Random.nextInt(2)
                val rightResult = Random.nextInt(2)

                val leftDrawable = if (leftResult == 0) R.drawable.front_coin else R.drawable.rear_coin
                val rightDrawable = if (rightResult == 0) R.drawable.front_coin else R.drawable.rear_coin


                val resultString = "Left: ${if (leftResult == 0) "Front" else "Rear"} | Right: ${if (rightResult == 0) "Front" else "Rear"}"


                left_coin.animate()
                    .rotation(180f)
                    .setDuration(500)
                    .withEndAction {
                        left_coin.setImageResource(leftDrawable)
                        left_coin.animate().rotation(360f).setDuration(300).start()
                    }
                    .start()


                right_coin.animate()
                    .rotation(180f)
                    .setDuration(500)
                    .withEndAction {
                        right_coin.setImageResource(rightDrawable)
                        text.text = resultString
                        right_coin.animate()
                            .rotation(360f)
                            .setDuration(300)
                            .withEndAction {
                                button.isEnabled = true
                            }
                            .start()
                    }
                    .start()

            }, 500)
        }
    }

//    fun toss() : NavigationEventInfo.None {
//
//    }
}

