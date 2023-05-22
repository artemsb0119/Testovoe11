package com.example.testovoe11

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.net.URL

class LessonActivity : AppCompatActivity() {

    private lateinit var lesson: List<Lesson>
    private lateinit var activity: Activity
    private lateinit var imageViewFon2: ImageView

    private lateinit var viewpager: ViewPager2
    private lateinit var buttonNext: AppCompatButton
    private lateinit var adapter: LessonAdapter
    private lateinit var textViewLesson: TextView

    private var currentItemIndex = 0

    private var day = 0

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson)

        textViewLesson = findViewById(R.id.textViewLesson)
        buttonNext = findViewById(R.id.buttonNext)
        viewpager = findViewById(R.id.viewpager)
        imageViewFon2 = findViewById(R.id.imageViewFon2)
        activity = this

        sharedPreferences = getSharedPreferences("my_preferences", Context.MODE_PRIVATE)
        currentItemIndex = sharedPreferences.getInt("day", 1)-1

        when (currentItemIndex) {
            0 -> textViewLesson.text = "FIRST LESSON"
            1 -> textViewLesson.text = "SECOND LESSON"
            2 -> textViewLesson.text = "THIRD LESSON"
            3 -> textViewLesson.text = "FOURTH LESSON"
            4 -> textViewLesson.text = "FIFTH LESSON"
            5 -> textViewLesson.text = "SIXTH LESSON"
            6 -> textViewLesson.text = "SEVENTH LESSON"
            7 -> textViewLesson.text = "EIGHTH LESSON"
            8 -> textViewLesson.text = "NINTH LESSON"
            9 -> textViewLesson.text = "TENTH LESSON"
            else -> textViewLesson.text = "INVALID LESSON"
        }

        Glide.with(this)
            .load("http://135.181.248.237/11/fon2.png")
            .into(imageViewFon2)
        loadData()

        buttonNext.setOnClickListener {
            val editor = getSharedPreferences("my_preferences", Context.MODE_PRIVATE).edit()
            editor.putBoolean("key_$currentItemIndex", true)
            editor.apply()
            currentItemIndex = viewpager.currentItem
            currentItemIndex++
            if (currentItemIndex >= lesson.size) {
                val intent = Intent(this, CheckActivity::class.java)
                startActivity(intent)
                finish()
            }
            viewpager.setCurrentItem(currentItemIndex, true)
            when (currentItemIndex) {
                0 -> textViewLesson.text = "FIRST LESSON"
                1 -> textViewLesson.text = "SECOND LESSON"
                2 -> textViewLesson.text = "THIRD LESSON"
                3 -> textViewLesson.text = "FOURTH LESSON"
                4 -> textViewLesson.text = "FIFTH LESSON"
                5 -> textViewLesson.text = "SIXTH LESSON"
                6 -> textViewLesson.text = "SEVENTH LESSON"
                7 -> textViewLesson.text = "EIGHTH LESSON"
                8 -> textViewLesson.text = "NINTH LESSON"
                9 -> textViewLesson.text = "TENTH LESSON"
                else -> textViewLesson.text = "INVALID LESSON"
            }
        }
    }

    private fun loadData() {
        GlobalScope.launch(Dispatchers.IO) {
            try {
                val data = URL("http://135.181.248.237/11/lessons.json").readText()
                val gson = Gson()
                lesson = gson.fromJson(data, Array<Lesson>::class.java).toList()

                activity.runOnUiThread {
                    adapter = LessonAdapter(lesson)
                    viewpager.adapter = adapter
                    viewpager.setCurrentItem(currentItemIndex, true)
                    viewpager.clipToPadding = false
                    viewpager.clipChildren = false
                    viewpager.isUserInputEnabled = false
                    viewpager.offscreenPageLimit = 2
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        startActivity(Intent(this, MenuActivity::class.java))
        finish()
        return super.onKeyDown(keyCode, event)
    }
}