package com.example.fim_obuchenie

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class level_selectActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lvl_select)

        val btn_task = findViewById<Button>(R.id.button1_select)
        btn_task.setOnClickListener {
            setContentView(R.layout.activity_task)
        }
    }
}

