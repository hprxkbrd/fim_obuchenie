package com.example.fim_obuchenie

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class difficultySelectActivity :AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_difficulty_select)

        var viewModel = ViewModel()

        //back
        val btn_back = findViewById<ImageButton>(R.id.back)
        btn_back.setOnClickListener {
            val intent = Intent(this, themeSelectActivity::class.java)
            startActivity(intent)
        }
        //next
        val btn_next1 = findViewById<Button>(R.id.easyButton)
        btn_next1.setOnClickListener {
            btn_next1.text = viewModel.getLang().toString()
            val intent = Intent(this, task_selectActivity::class.java)
            startActivity(intent)
        }

        val btn_next2 = findViewById<Button>(R.id.midButton)
        btn_next2.setOnClickListener {
            val intent = Intent(this, task_selectActivity::class.java)
            startActivity(intent)
        }

        val btn_next3 = findViewById<Button>(R.id.hardButton)
        btn_next3.setOnClickListener {
            val intent = Intent(this, task_selectActivity::class.java)
            startActivity(intent)
        }

        val btn_next4 = findViewById<Button>(R.id.testButton)
        btn_next4.setOnClickListener {
            val intent = Intent(this, task_selectActivity::class.java)
            startActivity(intent)
        }
    }
}