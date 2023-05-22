package com.example.testovoe11

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatButton
import com.bumptech.glide.Glide

class MenuActivity : AppCompatActivity() {

    private lateinit var button1: AppCompatButton
    private lateinit var button2: AppCompatButton
    private lateinit var button3: AppCompatButton
    private lateinit var button4: AppCompatButton
    private lateinit var button5: AppCompatButton
    private lateinit var button6: AppCompatButton
    private lateinit var button7: AppCompatButton
    private lateinit var button8: AppCompatButton
    private lateinit var button9: AppCompatButton
    private lateinit var button10: AppCompatButton

    private lateinit var buttonCheck: AppCompatButton
    private lateinit var buttonSettings: AppCompatButton

    private lateinit var imageViewFon2: ImageView

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        imageViewFon2 = findViewById(R.id.imageViewFon2)

        Glide.with(this)
            .load("http://135.181.248.237/11/fon2.png")
            .into(imageViewFon2)

        val sharedPreferences = getSharedPreferences("my_preferences", Context.MODE_PRIVATE)

        val editor = getSharedPreferences("my_preferences", Context.MODE_PRIVATE).edit()

        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)
        button9 = findViewById(R.id.button9)
        button10 = findViewById(R.id.button10)

        buttonCheck = findViewById(R.id.buttonCheck)
        buttonSettings = findViewById(R.id.buttonSettings)

        for (i in 0..9) {
            val value = sharedPreferences.getBoolean("key_$i", false)
            if (i==0&&value==true){
                button1.setBackgroundResource(R.drawable.button_green)
            }
            if (i==1&&value==true){
                button2.setBackgroundResource(R.drawable.button_green)
            }
            if (i==2&&value==true){
                button3.setBackgroundResource(R.drawable.button_green)
            }
            if (i==3&&value==true){
                button4.setBackgroundResource(R.drawable.button_green)
            }
            if (i==4&&value==true){
                button5.setBackgroundResource(R.drawable.button_green)
            }
            if (i==5&&value==true){
                button6.setBackgroundResource(R.drawable.button_green)
            }
            if (i==6&&value==true){
                button7.setBackgroundResource(R.drawable.button_green)
            }
            if (i==7&&value==true){
                button8.setBackgroundResource(R.drawable.button_green)
            }
            if (i==8&&value==true){
                button9.setBackgroundResource(R.drawable.button_green)
            }
            if (i==9&&value==true){
                button10.setBackgroundResource(R.drawable.button_green)
            }
        }

        val max = sharedPreferences.getInt("max", 0)
        if (max==10){
            buttonCheck.setBackgroundResource(R.drawable.button_green)
        }

        button1.setOnClickListener {
            editor.putInt("day",1)
            editor.apply()
            val intent = Intent(this, LessonActivity::class.java)
            startActivity(intent)
            finish()
        }
        button2.setOnClickListener {
            editor.putInt("day",2)
            editor.apply()
            val intent = Intent(this, LessonActivity::class.java)
            startActivity(intent)
            finish()
        }
        button3.setOnClickListener {
            editor.putInt("day",3)
            editor.apply()
            val intent = Intent(this, LessonActivity::class.java)
            startActivity(intent)
            finish()
        }
        button4.setOnClickListener {
            editor.putInt("day",4)
            editor.apply()
            val intent = Intent(this, LessonActivity::class.java)
            startActivity(intent)
            finish()
        }
        button5.setOnClickListener {
            editor.putInt("day",5)
            editor.apply()
            val intent = Intent(this, LessonActivity::class.java)
            startActivity(intent)
            finish()
        }
        button6.setOnClickListener {
            editor.putInt("day",6)
            editor.apply()
            val intent = Intent(this, LessonActivity::class.java)
            startActivity(intent)
            finish()
        }
        button7.setOnClickListener {
            editor.putInt("day",7)
            editor.apply()
            val intent = Intent(this, LessonActivity::class.java)
            startActivity(intent)
            finish()
        }
        button8.setOnClickListener {
            editor.putInt("day",8)
            editor.apply()
            val intent = Intent(this, LessonActivity::class.java)
            startActivity(intent)
            finish()
        }
        button9.setOnClickListener {
            editor.putInt("day",9)
            editor.apply()
            val intent = Intent(this, LessonActivity::class.java)
            startActivity(intent)
            finish()
        }
        button10.setOnClickListener {
            editor.putInt("day", 10)
            editor.apply()
            val intent = Intent(this, LessonActivity::class.java)
            startActivity(intent)
            finish()
        }
        buttonCheck.setOnClickListener {
            val intent = Intent(this, CheckActivity::class.java)
            startActivity(intent)
            finish()
        }
        buttonSettings.setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}