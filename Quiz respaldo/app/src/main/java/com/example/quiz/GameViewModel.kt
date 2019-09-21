package com.example.quiz

import androidx.lifecycle.ViewModel

class GameViewModel: ViewModel() {
    private lateinit var questions: List<Question>
    private var currentQuestion: Int = 0

    init{
        questions = listOf(
            Question(R.string.question_1, false),
            Question(R.string.question_2, false),
            Question(R.string.question_3, false),
            Question(R.string.question_4, true),
            Question(R.string.question_5, false),
            Question(R.string.question_6, true),
            Question(R.string.question_7, true)
        )
    }

    public val numOfQuestion
        get() = questions.size

    public fun getCurrentQuestion() = questions[currentQuestion]

    public fun nextQuestion(){
        currentQuestion = (currentQuestion + 1) % questions.size
    }
    public fun previousQuestion(){
        currentQuestion = (currentQuestion + questions.size - 1) % questions.size
    }
}