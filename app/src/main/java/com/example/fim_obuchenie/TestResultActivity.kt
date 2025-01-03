package com.example.fim_obuchenie

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity

class TestResultActivity : ComponentActivity(){

    private val viewModel: SharedViewModel by viewModels()

    val lang_field = findViewById<TextView>(R.id.lang)
    val topic_field = findViewById<TextView>(R.id.topic)
    val difficulty_field = findViewById<TextView>(R.id.difficulty)
    val task_field = findViewById<TextView>(R.id.task)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_result)

        val toMain = findViewById<Button>(R.id.toMain)
        toMain.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        viewModel.lang.observe(this) {
            lang_field.setText("Lang: " + viewModel.getLangValue().toString())
        }
        viewModel.topic.observe(this){
            topic_field.setText("Topic: " + viewModel.getTopicValue().toString())
        }
        viewModel.dfclty.observe(this){
            difficulty_field.setText("Difficulty: " + viewModel.getDfcltyValue().toString())
        }
        viewModel.task.observe(this){
            task_field.setText("Task #" + viewModel.getTaskValue().toString())
        }
    }
}