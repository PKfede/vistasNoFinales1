package com.example.examen2

import android.widget.CheckBox

data class Category(val id: Int,  val questions: List<Question>, var isEnabled : Boolean = true)