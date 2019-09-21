package com.example.basicwidgets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.IllegalArgumentException

class MainActivity : AppCompatActivity() {

    private lateinit var toggleButton : ToggleButton
    private lateinit var planetSpinner: AbsSpinner
    private lateinit var toolButton : ImageButton
    private lateinit var enableSwitch: Switch
    private lateinit var redCheckbox: CheckBox
    private lateinit var blueCheckbox: CheckBox
    private lateinit var greenCheckBox: CheckBox
    private lateinit var cyanCheckBox: CheckBox
    private lateinit var colorsEditText: EditText


    private lateinit var samsungRadioButton: RadioButton
    private lateinit var lgRadioButton: RadioButton
    private lateinit var huaweiRadioButton: RadioButton
    private lateinit var motorolaRadioButton: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolButton = findViewById(R.id.tool_button)
        enableSwitch = findViewById(R.id.enable_switch)
        redCheckbox = findViewById(R.id.red_checkbox)
        blueCheckbox = findViewById(R.id.blue_checkbox)
        greenCheckBox = findViewById(R.id.green_checkbox)
        cyanCheckBox = findViewById(R.id.cyan_checkbox)
        colorsEditText = findViewById(R.id.colors_text)

        samsungRadioButton = findViewById(R.id.samsung_radio_button)
        lgRadioButton = findViewById(R.id.lg_radio_button)
        huaweiRadioButton = findViewById(R.id.huawei_radio_button)
        motorolaRadioButton = findViewById(R.id.motorola_radio_button)

        planetSpinner = findViewById(R.id.planets_spinner)

        toolButton.setOnClickListener {
            Toast.makeText(
                this, "Tool button pressed-...", Toast.LENGTH_SHORT
            ).show()
        }

        enableSwitch.setOnCheckedChangeListener { v, ischecked ->
            if (ischecked) {
                Toast.makeText(this, "switch enabled...", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "switch disabled...", Toast.LENGTH_SHORT).show()
            }


        }
        var event =
            CompoundButton.OnCheckedChangeListener { v, ischecked ->
                var colors: String = ""
                colors += if (redCheckbox.isChecked()) "rojo" else ""
                colors += if (greenCheckBox.isChecked()) "verde" else ""
                colors += if (cyanCheckBox.isChecked()) "cyan" else ""
                colors += if (blueCheckbox.isChecked()) "azul" else ""
                colorsEditText.setText(colors)
            }

        redCheckbox.setOnCheckedChangeListener(event)
        greenCheckBox.setOnCheckedChangeListener(event)
        blueCheckbox.setOnCheckedChangeListener(event)
        cyanCheckBox.setOnCheckedChangeListener(event)

        true_false_toggle_button.setOnCheckedChangeListener { _, ischecked ->
            Toast.makeText(
                this,
                if (ischecked) "TRUE" else "FALSE",
                Toast.LENGTH_SHORT
            ).show()
        }

        val data = arrayOf("java", "Kotlin", "Python","Swift","C++")

        var adapter : ArrayAdapter<String>
                = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
        planetSpinner.adapter = adapter

        planetSpinner.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                val planetsArray = resources.getStringArray(R.array.planets_array)
                Toast.makeText(
                    this@MainActivity,
                    planetSpinner.selectedItem.toString(),
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
                R.id.samsung_radio_button -> "SAMSUNG"
                R.id.lg_radio_button -> "LG"
                R.id.motorola_radio_button -> "MOTOROLA"
                R.id.huawei_radio_button -> "HUAWEI"
                else -> throw IllegalArgumentException("radio.id")
            },
            Toast.LENGTH_SHORT
        ).show()
    }
}
