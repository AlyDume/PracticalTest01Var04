package com.example.practicaltest01var07

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class PracticalTest01Var04SecondaryActivity : AppCompatActivity() {
    //am declarat cele 2 inputuri de tip textview
    private lateinit var input1: TextView
    private lateinit var input2: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_secondary)

        //niste variabile in care primesc de la main activity le primesc prin intent
        val in1 = intent.getStringExtra("input1")
        val in2 = intent.getStringExtra("input2")


        //ascoiere cu id-uri din xml
        input1 = findViewById(R.id.input1)
        input2 = findViewById(R.id.input2)

        //setat text din variabile de mai sus in inputurile aferente
        input1.text = in1.toString()
        input2.text = in2.toString()






    }
}


