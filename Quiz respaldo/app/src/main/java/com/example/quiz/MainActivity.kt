package com.example.quiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders

class MainActivity : AppCompatActivity() {

    private lateinit var tvQuestion: TextView
    private lateinit var btnTrue: Button
    private lateinit var btnFalse: Button
    private lateinit var btnPrev: Button
    private lateinit var btnNext: Button

    private val model by lazy { ViewModelProviders.of(this)[GameViewModel::class.java] }

    private fun updateQuestion() {
        tvQuestion.setText(model.getCurrentQuestion().id)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("MaingActivity", "onCreate")

        //val model = ViewModelProviders.of(this)[GameViewModel::class.java]


        tvQuestion = findViewById(R.id.question_text_view)
        btnTrue = findViewById(R.id.true_button)
        btnFalse = findViewById(R.id.false_button)
        btnPrev = findViewById(R.id.previous_button)
        btnNext = findViewById(R.id.next_button)


//        if(savedInstanceState != null)
//        {
//            currentQuestion = savedInstanceState?.getInt("KEY_CURRENT_QUESTION")
//        }

        updateQuestion()

        btnTrue.setOnClickListener()
        {
            Toast.makeText(this, "Correcto", Toast.LENGTH_SHORT).show()
        }
        btnFalse.setOnClickListener()
        {
            Toast.makeText(this, "Incorrecto", Toast.LENGTH_SHORT).show()
        }
        btnPrev.setOnClickListener()
        {
            model.nextQuestion()
            updateQuestion()
        }
        btnNext.setOnClickListener()
        {
            model.previousQuestion()
            updateQuestion()
        }
    }

    override fun onStart(){
        super.onStart()
        Log.d("MainActivity", "OnStart")
    }
    override fun onResume(){
        super.onResume()
        Log.d("MainActivity", "OnResume")
    }
    override fun onPause(){
        super.onPause()
        Log.d("MainActivity", "OnPause")
    }
    override fun onStop(){
        super.onStop()
        Log.d("MainActivity", "OnPause")
    }
    override fun onDestroy(){
        super.onDestroy()
        Log.d("MainActivity", "OnPause")
    }

//    override fun onSaveInstanceState(outState: Bundle?) {
//        super.onSaveInstanceState(outState)
//        Log.d("MainActivity", "onSaveInstanceState()")
//        outState?.putInt("KEY_CURRENT_QUESTION", currentQuestion)
//    }

}
