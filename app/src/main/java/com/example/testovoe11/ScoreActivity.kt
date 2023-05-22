package com.example.testovoe11

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import com.bumptech.glide.Glide

class ScoreActivity : AppCompatActivity() {
    private lateinit var textViewResult: TextView
    private lateinit var textViewMax: TextView
    private lateinit var textViewLevel: TextView
    private lateinit var buttonRetry: AppCompatButton
    private lateinit var imageViewFon2: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        textViewResult = findViewById(R.id.textViewResult)
        textViewMax = findViewById(R.id.textViewMax)
        textViewLevel = findViewById(R.id.textViewLevel)
        buttonRetry = findViewById(R.id.buttonRetry)
        imageViewFon2 = findViewById(R.id.imageViewFon2)
        val result = intent.getIntExtra("current",0)
        val sharedPreferences = getSharedPreferences("my_preferences", Context.MODE_PRIVATE)
        val max = sharedPreferences.getInt("max", 0)
        val score = String.format("Your result: %s", result)
        textViewResult.text = score
        val maxResult = String.format("Maximum result: %s", max)
        textViewMax.text = maxResult
        textViewResult.text = score
        val level = when (result) {
            in 0..3 -> "Beginner"
            in 4..6 -> "Curious"
            in 7..9 -> "Experienced"
            else -> "Expert"
        }
        val resLevel = String.format("Your level: %s", level)
        textViewLevel.text = resLevel

        buttonRetry.setOnClickListener {
            val intent = Intent(this, CheckActivity::class.java)
            startActivity(intent)
            finish()
        }

        Glide.with(this)
            .load("http://135.181.248.237/11/fon2.png")
            .into(imageViewFon2)
    }
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        startActivity(Intent(this, MenuActivity::class.java))
        finish()
        return super.onKeyDown(keyCode, event)
    }

}