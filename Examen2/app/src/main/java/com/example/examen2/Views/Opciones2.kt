package com.example.examen2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import java.lang.IllegalArgumentException
import android.widget.CompoundButton
import android.widget.CheckBox



class Opciones2 : AppCompatActivity() {



    private lateinit var todosCheckBox: CheckBox
    private lateinit var cineCheckBox: CheckBox
    private lateinit var historiaCheckBox: CheckBox
    private lateinit var matematicasCheckBox: CheckBox
    private lateinit var fisicaCheckBox: CheckBox
    private lateinit var na1CheckBox: CheckBox
    private lateinit var na2CheckBox: CheckBox

    private lateinit var bajaRadioButton: RadioButton
    private lateinit var altaRadioButton: RadioButton

    private lateinit var pistasSwitch: Switch

    private lateinit var questionSpinner: AbsSpinner
    private lateinit var cheatsSpinner: AbsSpinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_opciones2)

        todosCheckBox =findViewById(R.id.todos_check)
        cineCheckBox =findViewById(R.id.cine_check)
        historiaCheckBox =findViewById(R.id.historia_check)
        matematicasCheckBox =findViewById(R.id.matematicas_check)
        fisicaCheckBox =findViewById(R.id.fisica_check)
        na1CheckBox =findViewById(R.id.na1_check)
        na2CheckBox=findViewById(R.id.na2_check)

        bajaRadioButton=findViewById(R.id.baja_radio)
        altaRadioButton=findViewById(R.id.alta_radio)

        pistasSwitch=findViewById(R.id.pistas_switch)
        questionSpinner=findViewById(R.id.numbers_quest_spinner)
        cheatsSpinner=findViewById(R.id.numbers_cheat_no_spinner)


        pistasSwitch.setOnCheckedChangeListener { v, ischecked ->
            if (ischecked) {
                Toast.makeText(this, "Pistas activadas...", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "pistas desactivadas...", Toast.LENGTH_SHORT).show()
            }


        }

        val data = arrayOf(5, 4, 3,2,1)

        var adapter : ArrayAdapter<Int>
                = ArrayAdapter<Int>(this, android.R.layout.simple_spinner_item, data)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
        questionSpinner.adapter = adapter

        questionSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                val questionArray = resources.getStringArray(R.array.quest_array)
                Toast.makeText(
                    this@Opciones2,
                    questionSpinner.selectedItem.toString(),
                    // planetsArray(p2),
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }
        val data1 = arrayOf(3,2,1)

        var adapter1 : ArrayAdapter<Int>
                = ArrayAdapter<Int>(this, android.R.layout.simple_spinner_item, data1)
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_item)
        cheatsSpinner.adapter = adapter1
        cheatsSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                val cheatsArray = resources.getStringArray(R.array.cheats_no_array)
                Toast.makeText(
                    this@Opciones2,
                    cheatsSpinner.selectedItem.toString(),
                    // planetsArray(p2),
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }



    }
    fun onRadioButtonClick(view: View) {
        val radio = view as RadioButton

        Toast.makeText(this,
            when (radio.id){
                R.id.alta_radio -> "Dificultad Alta"
                R.id.baja_radio -> "Dificultad Baja"
                else -> throw IllegalArgumentException("radio.id")
            },
            Toast.LENGTH_SHORT
        ).show()
    }
}
