package com.example.fim_obuchenie

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class TaskSelectActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_select)


        var viewModel = ViewModel()
        //back
        val btn_back = findViewById<ImageButton>(R.id.back)
        btn_back.setOnClickListener {
            
            val intent = Intent(this, DifficultySelectActivity::class.java)
            startActivity(intent)
        }

        //next
        val btn_next1 = findViewById<Button>(R.id.button1_select)
        btn_next1.setOnClickListener {
            btn_next1.text = viewModel.getLang().toString()
            val intent = Intent(this, TaskSelectActivity::class.java)
            viewModel.setDfclty(1)
            startActivity(intent)
        }
    }
}

