package com.example.fim_obuchenie

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TestResultActivity : AppCompatActivity(){
    private val viewModel: ViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_result)

        val toMain = findViewById<Button>(R.id.toMain)
        toMain.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val lang_field = findViewById<TextView>(R.id.lang)
        val topic_field = findViewById<TextView>(R.id.topic)
        val difficulty_field = findViewById<TextView>(R.id.difficulty)
        val task_field = findViewById<TextView>(R.id.task)

        lang_field.setText("Lang: "+viewModel.getLang().toString())
        topic_field.setText("Topic: "+viewModel.getTopic().toString())
        difficulty_field.setText("Difficulty: "+viewModel.getDfclty().toString())
        task_field.setText("Task #"+viewModel.getTask().toString())
    }
}