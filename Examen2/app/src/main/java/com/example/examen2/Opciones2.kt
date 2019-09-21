package com.example.examen2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import java.lang.IllegalArgumentException

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

        questionSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                val planetsArray = resources.getStringArray(R.array.quest_array)
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
        cheatsSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                val planetsArray = resources.getStringArray(R.array.cheats_no_array)
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
