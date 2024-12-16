package com.example.fim_obuchenie

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var viewModel = ViewModel()

        val btn_dfcltySlct = findViewById<Button>(R.id.button3)

        btn_dfcltySlct.setOnClickListener {
            val intent = Intent(this@MainActivity, difficultySelectActivity::class.java)
            startActivity(intent)
        }
        val btn_langSlct = findViewById<Button>(R.id.button1)
        btn_langSlct.setOnClickListener {
            val intent = Intent(this@MainActivity, langSelectActivity::class.java)
            startActivity(intent)
        }
        val btn_topicSlct = findViewById<Button>(R.id.button2)
        btn_topicSlct.setOnClickListener {
            val intent = Intent(this@MainActivity, themeSelectActivity::class.java)
            startActivity(intent)
        }
        val btn_lvlSlct = findViewById<Button>(R.id.button4)
        btn_lvlSlct.setOnClickListener {
            val intent = Intent(this@MainActivity, level_selectActivity::class.java)
            startActivity(intent)
        }
    }
}