package com.example.examen2.Views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter

import android.widget.ListView
import com.example.examen2.R


class ScoreboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scoreboard)
        val valores= arrayOf("hola","MDUND","PATAS")

        val lista: ListView=findViewById(R.id.list_view)
        val adaptador: ArrayAdapter<String>


        adaptador = ArrayAdapter(this, android.R.layout.simple_list_item_1, valores)

        lista.adapter = adaptador


    }
}
