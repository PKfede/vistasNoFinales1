package com.example.examen2

data class Question(val question: Int, val answer : String, val op1: String, val op2: String, val op3: String,  var state : Boolean = true)