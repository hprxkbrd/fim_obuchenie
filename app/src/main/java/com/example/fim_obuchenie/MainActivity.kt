package com.example.fim_obuchenie

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_langSlct = findViewById<Button>(R.id.lang_button)
        btn_langSlct.setOnClickListener {
            val intent = Intent(this@MainActivity, LangSelectActivity::class.java)
            startActivity(intent)
        }

        val btn_dfcltySlct = findViewById<Button>(R.id.difficulty_button)
        btn_dfcltySlct.setOnClickListener {
            val intent = Intent(this@MainActivity, DifficultySelectActivity::class.java)
            startActivity(intent)
        }

        val btn_topicSlct = findViewById<Button>(R.id.theme_button)
        btn_topicSlct.setOnClickListener {
            val intent = Intent(this@MainActivity, ThemeSelectActivity::class.java)
            startActivity(intent)
        }
        val btn_lvlSlct = findViewById<Button>(R.id.task_button)
        btn_lvlSlct.setOnClickListener {
            val intent = Intent(this@MainActivity, TaskSelectActivity::class.java)
            startActivity(intent)
        }
    }
}