package com.example.fim_obuchenie

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.viewModels

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val viewModel : SharedViewModel by viewModels()
        super.onCreate(savedInstanceState)
        main(viewModel)
    }
    
    fun main (viewModel: SharedViewModel){
        setContentView(R.layout.activity_main)

        val logo = findViewById<ImageView>(R.id.logoIMG)
        val lk = findViewById<ImageButton>(R.id.account_button)

        logo.setImageResource(R.drawable.logo_cyan)
        lk.setImageResource(R.drawable.acc_icon)
        
        lk.setOnClickListener {
            userData(viewModel)
        }
        
        val btn_langSlct = findViewById<Button>(R.id.lang_button)
        btn_langSlct.setOnClickListener {
            langSelect(viewModel)
        }

        val btn_dfcltySlct = findViewById<Button>(R.id.difficulty_button)
        btn_dfcltySlct.setOnClickListener {
            dfcltySelect(viewModel)
        }

        val btn_topicSlct = findViewById<Button>(R.id.theme_button)
        btn_topicSlct.setOnClickListener {
            themeSelect(viewModel)
        }
        val btn_lvlSlct = findViewById<Button>(R.id.task_button)
        btn_lvlSlct.setOnClickListener {
            taskSelect(viewModel)
        }
    }

    fun langSelect(viewModel: SharedViewModel){
        setContentView(R.layout.activity_lang_select)
        //back
        val btn_back = findViewById<ImageButton>(R.id.back)
        btn_back.setBackgroundColor(Color.parseColor("#E7EAEF"))
        btn_back.setImageResource(R.drawable.back_arrow__1_)
        btn_back.setOnClickListener {
            main(viewModel)
        }
        //next
        val btn_next1 = findViewById<Button>(R.id.button1)
        btn_next1.setOnClickListener {
            viewModel.setLang(1)
            dfcltySelect(viewModel)
        }

        val btn_next2 = findViewById<Button>(R.id.button2)
        btn_next2.setOnClickListener {
            viewModel.setLang(2)
            dfcltySelect(viewModel)
        }

        val btn_next3 = findViewById<Button>(R.id.button3)
        btn_next3.setOnClickListener {
            viewModel.setLang(3)
            dfcltySelect(viewModel)
        }

        val btn_next4 = findViewById<Button>(R.id.button4)
        btn_next4.setOnClickListener {
            viewModel.setLang(4)
            dfcltySelect(viewModel)
        }
    }
    
    private fun dfcltySelect(viewModel: SharedViewModel){ 
        setContentView(R.layout.activity_difficulty_select)

        //back
        val btn_back = findViewById<ImageButton>(R.id.back)
        btn_back.setBackgroundColor(Color.parseColor("#E7EAEF"))
        btn_back.setImageResource(R.drawable.back_arrow__1_)
        btn_back.setOnClickListener {
            langSelect(viewModel)
        }
        //next
        val btn_next1 = findViewById<Button>(R.id.easyButton)
        btn_next1.setOnClickListener {
            viewModel.setDfclty(1)
            themeSelect(viewModel)
        }

        val btn_next2 = findViewById<Button>(R.id.midButton)
        btn_next2.setOnClickListener {
            viewModel.setDfclty(2)
            themeSelect(viewModel)
        }

        val btn_next3 = findViewById<Button>(R.id.hardButton)
        btn_next3.setOnClickListener {
            viewModel.setDfclty(3)
            themeSelect(viewModel)
        }

        val btn_next4 = findViewById<Button>(R.id.testButton)
        btn_next4.setOnClickListener {
            viewModel.setDfclty(0)
            themeSelect(viewModel)
        }
    }
    
    private fun themeSelect(viewModel: SharedViewModel){
        setContentView(R.layout.activity_theme_select)
        //back
        val btn_back = findViewById<ImageButton>(R.id.back)
        btn_back.setBackgroundColor(Color.parseColor("#E7EAEF"))
        btn_back.setImageResource(R.drawable.back_arrow__1_)
        btn_back.setOnClickListener {
            dfcltySelect(viewModel)
        }
        //next
        val btn_next1 = findViewById<Button>(R.id.topic1)
        btn_next1.setOnClickListener {
            viewModel.setTopic(1)
            taskSelect(viewModel)
        }

        val btn_next2 = findViewById<Button>(R.id.topic2)
        btn_next2.setOnClickListener {
            viewModel.setTopic(2)
            taskSelect(viewModel)
        }

        val btn_next3 = findViewById<Button>(R.id.topic3)
        btn_next3.setOnClickListener {
            viewModel.setTopic(3)
            taskSelect(viewModel)
        }

        val btn_next4 = findViewById<Button>(R.id.topic4)
        btn_next4.setOnClickListener {
            viewModel.setTopic(4)
            taskSelect(viewModel)
        }
    }
    
    private fun taskSelect(viewModel: SharedViewModel){
        setContentView(R.layout.activity_task_select)

        //back
        val btn_back = findViewById<ImageButton>(R.id.back)
        btn_back.setBackgroundColor(Color.parseColor("#E7EAEF"))
        btn_back.setImageResource(R.drawable.back_arrow__1_)
        btn_back.setOnClickListener {
            themeSelect(viewModel)
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
            userData(viewModel)
        }

        btn_next2.setOnClickListener {
            viewModel.setTask(2)
            userData(viewModel)
        }

        btn_next3.setOnClickListener {
            viewModel.setTask(3)
            userData(viewModel)
        }

        btn_next4.setOnClickListener {
            viewModel.setTask(4)
            userData(viewModel)
        }

        btn_next5.setOnClickListener {
            viewModel.setTask(5)
            userData(viewModel)
        }

        btn_next6.setOnClickListener {
            viewModel.setTask(6)
            userData(viewModel)
        }

        btn_next7.setOnClickListener {
            viewModel.setTask(7)
            userData(viewModel)
        }

        btn_next8.setOnClickListener {
            viewModel.setTask(8)
            userData(viewModel)
        }

        btn_next9.setOnClickListener {
            viewModel.setTask(9)
            userData(viewModel)
        }

        btn_next10.setOnClickListener {
            viewModel.setTask(10)
            userData(viewModel)
        }

        btn_next11.setOnClickListener {
            viewModel.setTask(11)
            userData(viewModel)
        }

        btn_next12.setOnClickListener {
            viewModel.setTask(12)
            userData(viewModel)
        }
    }

    private fun userData(viewModel: SharedViewModel){
        setContentView(R.layout.activity_lk)
        val lang_field = findViewById<TextView>(R.id.lang)
        val topic_field = findViewById<TextView>(R.id.topic)
        val difficulty_field = findViewById<TextView>(R.id.difficulty)
        val task_field = findViewById<TextView>(R.id.task)

        val logoW = findViewById<ImageView>(R.id.logoWhite)
        logoW.setImageResource(R.drawable.logo_white)

        val toMain = findViewById<Button>(R.id.toMain)
        toMain.setOnClickListener{
            main(viewModel)
        }
        var l : String
        var to : String
        var d : String
        var ta : String

        if (viewModel.lang.value == 1) l = getString(R.string.lang_value1)
        else if (viewModel.lang.value == 2) l = getString(R.string.lang_value2)
        else if (viewModel.lang.value == 3) l = getString(R.string.lang_value3)
        else if (viewModel.lang.value == 4) l = getString(R.string.lang_value4)
        else l = getString(R.string.not_chosen)

        if (viewModel.topic.value == 1) to = getString(R.string.topic1)
        else if (viewModel.topic.value == 2) to = getString(R.string.topic2)
        else if (viewModel.topic.value == 3) to = getString(R.string.topic3)
        else if (viewModel.topic.value == 4) to = getString(R.string.topic4)
        else to = getString(R.string.not_chosen)

        if (viewModel.dfclty.value == 1) d = getString(R.string.easy)
        else if (viewModel.lang.value == 2) d = getString(R.string.mid)
        else if (viewModel.lang.value == 3) d = getString(R.string.hard)
        else if (viewModel.lang.value == 4) d = getString(R.string.test)
        else d = getString(R.string.not_chosen)

        if (viewModel.task.value == null) ta = getString(R.string.not_chosen)
        else ta = viewModel.task.value.toString()

        lang_field.setText("Язык: " + l)
        topic_field.setText("Тема: " + to)
        difficulty_field.setText("Сложность: " + d)
        task_field.setText("Задание: " + ta)
    }
}