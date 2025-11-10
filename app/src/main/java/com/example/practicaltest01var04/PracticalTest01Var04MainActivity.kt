package com.example.practicaltest01var07

import android.annotation.SuppressLint
import android.app.Activity
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.practicaltest01var04.R

class PracticalTest01Var04MainActivity : AppCompatActivity() {

    private lateinit var input1: EditText
    private lateinit var input2: EditText
    private lateinit var output: EditText

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practical_test01_var04_main)

        input1 = findViewById(R.id.input1)
        input2 = findViewById(R.id.input2)
        output = findViewById(R.id.output)


        val pressMeButton = findViewById<Button>(R.id.display_information)
        pressMeButton.setOnClickListener {
            if(input1 != null && input2 != null) {
                output.setText(input1.toString())
                output.setText(input2.toString())
                Toast.makeText(this, "The button has been pressed", Toast.LENGTH_LONG).show()
            }
            else
                Toast.makeText(this, "error", Toast.LENGTH_LONG).show()
        }

        val activityResultsLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val message = result.data?.getStringExtra("result")
                if(message != null)
                    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
                Toast.makeText(this, "The activity returned with result OK", Toast.LENGTH_LONG)
                    .show()
            }
        }


        //le trimit prin intent
        val navigateToSecondaryActivityButton = findViewById<Button>(R.id.set)
        navigateToSecondaryActivityButton.setOnClickListener {
            val intent = Intent(this, PracticalTest01Var04SecondaryActivity::class.java)
            intent.putExtra("INPUT1", Integer.valueOf(input1.text.toString()))
            intent.putExtra("INPUT2", Integer.valueOf(input2.text.toString()))
            activityResultsLauncher.launch(intent)
        }
    }
}