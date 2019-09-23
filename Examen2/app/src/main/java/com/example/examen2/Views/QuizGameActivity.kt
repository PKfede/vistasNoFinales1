package com.example.examen2.Views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.lifecycle.ViewModelProviders
import com.example.examen2.R
import com.example.examen2.gameViewModel

class QuizGameActivity : AppCompatActivity() {


    private lateinit var  questionText: TextView
    private lateinit var answerOnebtn: Button
    private lateinit var answerTwobtn: Button
    private lateinit var answerThreebtn: Button
    private lateinit var answerFourbtn: Button
    private lateinit var nextQuestion: ImageButton
    private lateinit var prevQuestion: ImageButton

    private val model by lazy { ViewModelProviders.of( this)[gameViewModel::class.java] }

    private fun updateQuestion() {
       // questionText.setText(model.getCurrentQuestion().id)
        questionText.setText(model.getCurrentQuestion().question)
    }
    private fun updateAnswer() {
        // questionText.setText(model.getCurrentQuestion().id)
        answerOnebtn.setText(model.getCurrentQuestion().answer)
        answerTwobtn.setText(model.getCurrentQuestion().op1)
        answerThreebtn.setText(model.getCurrentQuestion().op2)
        answerFourbtn.setText(model.getCurrentQuestion().op3)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_game)

        questionText = findViewById(R.id.quesTl_text)
        answerOnebtn = findViewById(R.id.answ1_btn)
        answerTwobtn = findViewById(R.id.answ2_btn)
        answerThreebtn = findViewById(R.id.answ3_btn)
        answerFourbtn = findViewById(R.id.answ4_btn)


        questionText.setText(model.getCurrentQuestion().question)
        answerOnebtn.setText(model.getCurrentQuestion().answer)
        answerTwobtn.setText(model.getCurrentQuestion().op1)
        answerThreebtn.setText(model.getCurrentQuestion().op2)
        answerFourbtn.setText(model.getCurrentQuestion().op3)

        nextQuestion = findViewById(R.id.nxt_Btn)
        prevQuestion = findViewById(R.id.prev_Btn)


        nextQuestion.setOnClickListener()
        {
            model.nextQuestion()
            updateQuestion()
            updateAnswer()
        }

        prevQuestion.setOnClickListener()
        {
            model.previousQuestion()
            updateQuestion()
            updateAnswer()
        }
    }




}
