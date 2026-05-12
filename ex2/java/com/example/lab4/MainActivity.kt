package com.example.lab4

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
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

        val text = findViewById<TextView>(R.id.textView)
        val reset_text = text.text.toString()
        val button = findViewById<Button>(R.id.button)
        val left_coin = findViewById<ImageView>(R.id.imageView)
        val right_coin = findViewById<ImageView>(R.id.imageView1)

        button.setOnClickListener {
            Toast.makeText(this, "Flipping coins..", Toast.LENGTH_SHORT).show()
            text.text = reset_text
            button.isEnabled = false


            left_coin.setImageResource(R.drawable.multiple_coins)
            right_coin.setImageResource(R.drawable.multiple_coins)

            val leftResult = Random.nextInt(2)
            val rightResult = Random.nextInt(2)

            val leftDrawable = if (leftResult == 0) R.drawable.front_coin else R.drawable.rear_coin
            val rightDrawable = if (rightResult == 0) R.drawable.front_coin else R.drawable.rear_coin


            fun animateCoin(coin: ImageView, drawable: Int, onComplete: () -> Unit = {}) {
                coin.animate()
                    .rotationYBy(1800f)
                    .translationY(-200f)
                    .scaleX(0.7f)
                    .scaleY(0.7f)
                    .setDuration(600)
                    .withEndAction {

                        coin.setImageResource(drawable)


                        coin.animate()
                            .translationY(0f)
                            .scaleX(1f)
                            .scaleY(1f)
                            .rotationYBy(1800f)
                            .setDuration(600)
                            .withEndAction {
                                onComplete()
                            }
                            .start()
                    }
                    .start()
            }


            animateCoin(left_coin, leftDrawable)
            animateCoin(right_coin, rightDrawable) {

                text.text = "Left: ${if (leftResult == 0) "Front" else "Rear"} | Right: ${if (rightResult == 0) "Front" else "Rear"}"
                button.isEnabled = true
            }
        }
    }


}

