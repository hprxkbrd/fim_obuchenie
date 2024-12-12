package com.example.fim_obuchenie

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_lvlSlct = findViewById<Button>(R.id.button3)
        btn_lvlSlct.setOnClickListener {
            setContentView(R.layout.activity_lvl_select)
        }
    }
}