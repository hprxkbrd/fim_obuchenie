package com.example.fim_obuchenie

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class themeSelectActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_theme_select)
        //back
        val btn_back = findViewById<ImageButton>(R.id.back)
        btn_back.setOnClickListener {
            val intent = Intent(this, langSelectActivity::class.java)
            startActivity(intent)
        }
        //next
        val btn_next1 = findViewById<Button>(R.id.button1)
        btn_next1.setOnClickListener {
            val intent = Intent(this, difficultySelectActivity::class.java)
            startActivity(intent)
        }

        val btn_next2 = findViewById<Button>(R.id.button2)
        btn_next2.setOnClickListener {
            val intent = Intent(this, difficultySelectActivity::class.java)
            startActivity(intent)
        }

        val btn_next3 = findViewById<Button>(R.id.button3)
        btn_next3.setOnClickListener {
            val intent = Intent(this, difficultySelectActivity::class.java)
            startActivity(intent)
        }

        val btn_next4 = findViewById<Button>(R.id.button4)
        btn_next4.setOnClickListener {
            val intent = Intent(this, difficultySelectActivity::class.java)
            startActivity(intent)
        }
        //
    }
}