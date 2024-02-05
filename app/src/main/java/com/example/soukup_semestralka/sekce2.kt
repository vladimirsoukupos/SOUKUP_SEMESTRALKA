package com.example.soukup_semestralka

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class sekce2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.druha_sekce)

        val backButton: Button = findViewById(R.id.backButton)

        backButton.setOnClickListener {
            finish()
        }

    }
}