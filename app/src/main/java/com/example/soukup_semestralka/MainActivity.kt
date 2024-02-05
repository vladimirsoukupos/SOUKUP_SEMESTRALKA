package com.example.soukup_semestralka

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button1: Button = findViewById(R.id.button1)
        val button2: Button = findViewById(R.id.button2)

        //Tlačítka

        button1.setOnClickListener {
            val intent = Intent(this, sekce1::class.java)
            startActivity(intent)
        }

        button2.setOnClickListener {
            val intent = Intent(this, sekce2::class.java)
            startActivity(intent)
        }
    }
}