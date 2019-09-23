package com.example.examen2

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import java.lang.IllegalArgumentException
import android.widget.CheckBox
import androidx.core.view.get
import kotlinx.android.synthetic.main.activity_opciones2.*
import kotlinx.android.synthetic.main.activity_opciones2.view.*

object Configuration {
    var conf = Game_Configuration()
}

class Opciones2 : AppCompatActivity() {


    private lateinit var todosCheckBox: CheckBox
    private lateinit var cineCheckBox: CheckBox
    private lateinit var historiaCheckBox: CheckBox
    private lateinit var matematicasCheckBox: CheckBox
    private lateinit var fisicaCheckBox: CheckBox
    private lateinit var na1CheckBox: CheckBox
    private lateinit var na2CheckBox: CheckBox

    private lateinit var radioGroupDificultad: RadioGroup
    private lateinit var bajaRadioButton: RadioButton
    private lateinit var altaRadioButton: RadioButton

    private lateinit var pistasSwitch: Switch

    private lateinit var questionSpinner: AbsSpinner
    private lateinit var cheatsSpinner: AbsSpinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_opciones2)

        todosCheckBox = findViewById(R.id.todos_check)
        cineCheckBox= findViewById(R.id.cine_check)
        historiaCheckBox= findViewById(R.id.historia_check)
        matematicasCheckBox= findViewById(R.id.matematicas_check)
        fisicaCheckBox= findViewById(R.id.fisica_check)
        na1CheckBox= findViewById(R.id.na1_check)
        na2CheckBox= findViewById(R.id.na2_check)

        radioGroupDificultad = findViewById(R.id.radio_group_dificultad)
        bajaRadioButton = findViewById(R.id.baja_radio)
        altaRadioButton = findViewById(R.id.alta_radio)

        pistasSwitch = findViewById(R.id.pistas_switch)
        questionSpinner = findViewById(R.id.numbers_quest_spinner)
        cheatsSpinner = findViewById(R.id.numbers_cheat_no_spinner)

//      Categorias CheckBox logica

        todosCheckBox.isChecked = Configuration.conf.all_categories
        cineCheckBox.isChecked = Configuration.conf.categories[0].isEnabled
        historiaCheckBox.isChecked = Configuration.conf.categories[1].isEnabled
        matematicasCheckBox.isChecked = Configuration.conf.categories[2].isEnabled
        fisicaCheckBox.isChecked = Configuration.conf.categories[3].isEnabled
        na1CheckBox.isChecked = Configuration.conf.categories[4].isEnabled
        na2CheckBox.isChecked = Configuration.conf.categories[5].isEnabled

        todosCheckBox.setOnCheckedChangeListener { _, ischecked ->
            Configuration.conf.all_categories = ischecked
            if (ischecked) {
                cineCheckBox.isChecked=true
                historiaCheckBox.isChecked=true
                matematicasCheckBox.isChecked=true
                fisicaCheckBox.isChecked=true
                na1CheckBox.isChecked=true
                na2CheckBox.isChecked=true
            }
        }
        cineCheckBox.setOnCheckedChangeListener { _, ischecked ->
            onCheckedChangeListener(0,cineCheckBox)
        }
        historiaCheckBox.setOnCheckedChangeListener { _, ischecked ->
            onCheckedChangeListener(1, historiaCheckBox)
        }
        matematicasCheckBox.setOnCheckedChangeListener { _, ischecked ->
            onCheckedChangeListener(2, matematicasCheckBox)
        }
        fisicaCheckBox.setOnCheckedChangeListener { _, ischecked ->
            onCheckedChangeListener(3, fisicaCheckBox)
        }
        na1CheckBox.setOnCheckedChangeListener { _, ischecked ->
            onCheckedChangeListener(4, na1CheckBox)
        }
        na2CheckBox.setOnCheckedChangeListener { _, ischecked ->
            onCheckedChangeListener(5, na2CheckBox)
        }

//        Numero de preguntas

        var adapter: ArrayAdapter<Int> =
            ArrayAdapter<Int>(this, android.R.layout.simple_spinner_item, Configuration.conf.arrayQuestionsNumber)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)

        questionSpinner.adapter = adapter

        questionSpinner.setSelection(Configuration.conf.questions_number-5)

        questionSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                Configuration.conf.questions_number=questionSpinner.selectedItem.toString().toInt()
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
//          Dificultad
        var idCurrentRadio : Int= if(Configuration.conf.dificulty == 0) altaRadioButton.id else bajaRadioButton.id
        radioGroupDificultad.check(idCurrentRadio)
        radioGroupDificultad.setOnCheckedChangeListener{_, _->
            Configuration.conf.dificulty = if(radioGroupDificultad.checkedRadioButtonId == altaRadioButton.id) 0 else bajaRadioButton.id
        }

//          Habilitar pistas
        pistasSwitch.isChecked = Configuration.conf.cluesOn
        pistasSwitch.setOnCheckedChangeListener{_,ischecked->
            Configuration.conf.cluesOn = ischecked
            Toast.makeText(this,
                if(ischecked)"Pistas activadas" else "Pistas desactivadas",
                Toast.LENGTH_SHORT).show()
            cheatsSpinner.isEnabled = Configuration.conf.cluesOn
            if(!ischecked){Configuration.conf.clues_number = 1}
        }

//          Numero de pistas
        var adapter1: ArrayAdapter<Int> =
            ArrayAdapter<Int>(this, android.R.layout.simple_spinner_item, Configuration.conf.arrayCluesNumber)
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_item)

        //si las pistas no estan activas, pues esto tampoco
        cheatsSpinner.isEnabled = Configuration.conf.cluesOn
        cheatsSpinner.adapter = adapter1
        cheatsSpinner.setSelection(Configuration.conf.clues_number-1)

        cheatsSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                Configuration.conf.clues_number = cheatsSpinner.selectedItem.toString().toInt()
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
    }


    private fun onCheckedChangeListener(pos:Int, checkBox: CheckBox){
        Configuration.conf.setEnabledCategory(pos, checkBox.isChecked)
        todosCheckBox.isChecked = Configuration.conf.getNumOfCategories() == 6
    }

    fun onRadioButtonClick(view: View) {
        val radio = view as RadioButton
        var string: String = if(Configuration.conf.dificulty == 0) "Dificultad Alta" else "Dificultad baja"
        Toast.makeText(
            this,
            string,
            Toast.LENGTH_SHORT
        ).show()
    }
}
