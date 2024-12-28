package com.example.fim_obuchenie

import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

@AndroidEntryPoint
class ThemeSelectActivity : AppCompatActivity() {
    private val viewModel: ViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_theme_select)
        //back
        val btn_back = findViewById<ImageButton>(R.id.back)
        btn_back.setOnClickListener {
            val intent = Intent(this, LangSelectActivity::class.java)
            startActivity(intent)
        }
        //next
        val btn_next1 = findViewById<Button>(R.id.topic1)
        btn_next1.setOnClickListener {
            val intent = Intent(this, DifficultySelectActivity::class.java)
            viewModel.setTopic(1)
            startActivity(intent)
        }

        val btn_next2 = findViewById<Button>(R.id.topic2)
        btn_next2.setOnClickListener {
            val intent = Intent(this, DifficultySelectActivity::class.java)
            viewModel.setTopic(2)
            startActivity(intent)
        }

        val btn_next3 = findViewById<Button>(R.id.topic3)
        btn_next3.setOnClickListener {
            val intent = Intent(this, DifficultySelectActivity::class.java)
            viewModel.setTopic(3)
            startActivity(intent)
        }

        val btn_next4 = findViewById<Button>(R.id.topic4)
        btn_next4.setOnClickListener {
            val intent = Intent(this, DifficultySelectActivity::class.java)
            viewModel.setTopic(4)
            startActivity(intent)
        }
        //
    }
}