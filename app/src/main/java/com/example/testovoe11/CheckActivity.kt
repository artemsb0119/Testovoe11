package com.example.testovoe11

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import com.bumptech.glide.Glide
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.net.URL

class CheckActivity : AppCompatActivity() {
    private lateinit var imageViewFon2: ImageView
    private lateinit var textViewScore: TextView
    private lateinit var textViewQuestion: TextView
    private lateinit var button3: AppCompatButton
    private lateinit var button1: AppCompatButton
    private lateinit var button4: AppCompatButton
    private lateinit var button2: AppCompatButton

    private lateinit var questions: List<Quiz>

    private lateinit var activity: Activity

    private var answeredQuestion = 0
    private val countOfQuestions = 10
    private var countOfRightAnswers = 0
    private var score: String? = null
    private var clicked: String? = null
    private var getRightAnswerPosition: String? = null
    var list: MutableList<Int> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check)

        button1 = findViewById(R.id.button1)
        textViewScore = findViewById(R.id.textViewScore)
        textViewQuestion = findViewById(R.id.textViewQuestion)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button2 = findViewById(R.id.button2)
        imageViewFon2 = findViewById(R.id.imageViewFon2)

        Glide.with(this)
            .load("http://135.181.248.237/11/fon2.png")
            .into(imageViewFon2)

        score = String.format("%s / %s", answeredQuestion, countOfQuestions)
        textViewScore.text = score
        button1.setOnClickListener {
            clicked = "A"
            playGame()
        }
        button2.setOnClickListener {
            clicked = "B"
            playGame()
        }
        button3.setOnClickListener {
            clicked = "C"
            playGame()
        }
        button4.setOnClickListener {
            clicked = "D"
            playGame()
        }

        activity = this
        loadData()
    }

    private fun loadData() {
        GlobalScope.launch(Dispatchers.IO) {
            try {
                val data = URL("http://135.181.248.237/11/quiz.json").readText()
                val gson = Gson()
                questions = gson.fromJson(data, Array<Quiz>::class.java).toList()
                activity.runOnUiThread {
                    generateQuestion()
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    private fun generateQuestion() {
        var repeat = false
        val a = (Math.random() * questions.size).toInt()
        Log.d("asas", a.toString())
        for (lists in list) {
            if (lists == a) {
                repeat = true
            }
        }
        if (!repeat) {
            list.add(a)
            textViewQuestion.text = questions[a].question
            getRightAnswerPosition = questions[a].answer
            button1.text = questions[a].a
            button2.text = questions[a].b
            button3.text = questions[a].c
            button4.text = questions[a].d
        } else {
            generateQuestion()
        }
    }

    private fun playGame() {
        if(button1.isPressed||button2.isPressed||button3.isPressed||button4.isPressed){
            if (clicked.equals(getRightAnswerPosition)) {
                countOfRightAnswers++
            }
        }
        answeredQuestion++
        score = String.format("%s / %s", answeredQuestion, countOfQuestions)
        textViewScore.text = score
        if (answeredQuestion == 10){
            gameOver()
        } else {
            generateQuestion()
        }
    }
    private fun gameOver() {
        val sharedPreferences = getSharedPreferences("my_preferences", Context.MODE_PRIVATE)
        var max = sharedPreferences.getInt("max", 0)
        if (countOfRightAnswers >= max) {
            max = countOfRightAnswers
            val editor = getSharedPreferences("my_preferences", Context.MODE_PRIVATE).edit()
            editor.putInt("max", max)
            editor.apply()
        }
        val intent = Intent(this, ScoreActivity::class.java)
        intent.putExtra("current", countOfRightAnswers)
        startActivity(intent)
        finish()
    }
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        startActivity(Intent(this, MenuActivity::class.java))
        finish()
        return super.onKeyDown(keyCode, event)
    }
}