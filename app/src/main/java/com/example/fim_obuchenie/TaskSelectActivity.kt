package com.example.fim_obuchenie

import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

@AndroidEntryPoint
class TaskSelectActivity: AppCompatActivity() {
    private val viewModel: ViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_select)

        //back
        val btn_back = findViewById<ImageButton>(R.id.back)
        btn_back.setOnClickListener {
            
            val intent = Intent(this, DifficultySelectActivity::class.java)
            startActivity(intent)
        }

        //next
        val btn_next1 = findViewById<Button>(R.id.task1)
        val btn_next2 = findViewById<Button>(R.id.task2)
        val btn_next3 = findViewById<Button>(R.id.task3)
        val btn_next4 = findViewById<Button>(R.id.task4)
        val btn_next5 = findViewById<Button>(R.id.task5)
        val btn_next6 = findViewById<Button>(R.id.task6)
        val btn_next7 = findViewById<Button>(R.id.task7)
        val btn_next8 = findViewById<Button>(R.id.task8)
        val btn_next9 = findViewById<Button>(R.id.task9)
        val btn_next10 = findViewById<Button>(R.id.task10)
        val btn_next11 = findViewById<Button>(R.id.task11)
        val btn_next12 = findViewById<Button>(R.id.task12)

        btn_next1.setOnClickListener {
            viewModel.setTask(1)
            val intent = Intent(this, TestResultActivity::class.java)
            startActivity(intent)
        }

        btn_next2.setOnClickListener {
            viewModel.setTask(2)
            val intent = Intent(this, TestResultActivity::class.java)
            startActivity(intent)
        }

        btn_next3.setOnClickListener {
            viewModel.setTask(3)
            val intent = Intent(this, TestResultActivity::class.java)
            startActivity(intent)
        }

        btn_next4.setOnClickListener {
            viewModel.setTask(4)
            val intent = Intent(this, TestResultActivity::class.java)
            startActivity(intent)
        }

        btn_next5.setOnClickListener {
            viewModel.setTask(5)
            val intent = Intent(this, TestResultActivity::class.java)
            startActivity(intent)
        }

        btn_next6.setOnClickListener {
            viewModel.setTask(6)
            val intent = Intent(this, TestResultActivity::class.java)
            startActivity(intent)
        }

        btn_next7.setOnClickListener {
            viewModel.setTask(7)
            val intent = Intent(this, TestResultActivity::class.java)
            startActivity(intent)
        }

        btn_next8.setOnClickListener {
            viewModel.setTask(8)
            val intent = Intent(this, TestResultActivity::class.java)
            startActivity(intent)
        }

        btn_next9.setOnClickListener {
            viewModel.setTask(9)
            val intent = Intent(this, TestResultActivity::class.java)
            startActivity(intent)
        }

        btn_next10.setOnClickListener {
            viewModel.setTask(10)
            val intent = Intent(this, TestResultActivity::class.java)
            startActivity(intent)
        }

        btn_next11.setOnClickListener {
            viewModel.setTask(11)
            val intent = Intent(this, TestResultActivity::class.java)
            startActivity(intent)
        }

        btn_next12.setOnClickListener {
            viewModel.setTask(12)
            val intent = Intent(this, TestResultActivity::class.java)
            startActivity(intent)
        }
    }
}

