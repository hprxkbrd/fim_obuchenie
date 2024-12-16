package com.example.fim_obuchenie

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class level_selectActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lvl_select)

        val btn_back = findViewById<ImageButton>(R.id.back)
        btn_back.setOnClickListener {
            
            val intent = Intent(this, difficultySelectActivity::class.java)
            startActivity(intent)
        }
    }
}

