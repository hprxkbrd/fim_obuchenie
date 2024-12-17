package com.example.fim_obuchenie

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class task_selectActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_select)


        var viewModel = ViewModel()
        //back
        val btn_back = findViewById<ImageButton>(R.id.back)
        btn_back.setOnClickListener {
            
            val intent = Intent(this, difficultySelectActivity::class.java)
            startActivity(intent)
        }

        //next
        val btn_next1 = findViewById<Button>(R.id.button1)
        btn_next1.setOnClickListener {
            btn_next1.text = viewModel.getLang().toString()
            val intent = Intent(this, level_selectActivity::class.java)
            viewModel.setDfclty(1)
            startActivity(intent)
        }
    }
}

