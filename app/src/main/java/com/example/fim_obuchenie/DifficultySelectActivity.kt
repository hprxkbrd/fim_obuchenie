package com.example.fim_obuchenie

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class DifficultySelectActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_difficulty_select)

        var viewModel = ViewModel()

        //back
        val btn_back = findViewById<ImageButton>(R.id.back)
        btn_back.setOnClickListener {
            val intent = Intent(this, ThemeSelectActivity::class.java)
            startActivity(intent)
        }
        //next
        val btn_next1 = findViewById<Button>(R.id.easyButton)
        btn_next1.setOnClickListener {
            viewModel.setDfclty(1)
            val intent = Intent(this, TaskSelectActivity::class.java)
            startActivity(intent)
        }

        val btn_next2 = findViewById<Button>(R.id.midButton)
        btn_next2.setOnClickListener {
            viewModel.setDfclty(2)
            val intent = Intent(this, TaskSelectActivity::class.java)
            startActivity(intent)
        }

        val btn_next3 = findViewById<Button>(R.id.hardButton)
        btn_next3.setOnClickListener {
            viewModel.setDfclty(3)
            val intent = Intent(this, TaskSelectActivity::class.java)
            startActivity(intent)
        }

        val btn_next4 = findViewById<Button>(R.id.testButton)
        btn_next4.setOnClickListener {
            viewModel.setDfclty(0)
            val intent = Intent(this, TaskSelectActivity::class.java)
            startActivity(intent)
        }
    }
}