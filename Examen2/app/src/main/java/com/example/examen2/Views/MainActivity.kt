package com.example.examen2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.R.attr.button
import android.content.DialogInterface
import android.view.View


class MainActivity : AppCompatActivity() {





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnOpenActivity : Button = findViewById(R.id.btn_start_new_activity)
        btnOpenActivity.setOnClickListener{
            val intent  = Intent(this, Opciones2 :: class.java)
            startActivity(intent)
        }
    }

}
