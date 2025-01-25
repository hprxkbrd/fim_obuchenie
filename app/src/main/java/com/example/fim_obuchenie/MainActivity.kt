package com.example.fim_obuchenie

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.viewModels

class MainActivity : ComponentActivity() {

    private val viewModel : SharedViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.dropLangs(this)
        viewModel.getDataBase(this)
        viewModel.restoreInstance(this)
        main(viewModel)
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.saveInstance(this)
    }
    
    private fun main (viewModel: SharedViewModel){
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
            if (viewModel.getLangValue() == -1)
                Toast.makeText(this, getString(R.string.not_chosen)+" "+getString(R.string.lang_select), Toast.LENGTH_SHORT).show()
            else dfcltySelect(viewModel)
        }

        val btn_topicSlct = findViewById<Button>(R.id.theme_button)
        btn_topicSlct.setOnClickListener {
            if (viewModel.getDfcltyValue() == -1)
                Toast.makeText(this, getString(R.string.not_chosen)+" "+getString(R.string.difficulty_select), Toast.LENGTH_SHORT).show()
            else themeSelect(viewModel)
        }

        val btn_lvlSlct = findViewById<Button>(R.id.task_button)
        btn_lvlSlct.setOnClickListener {
            if (viewModel.getTopicValue() == -1)
                Toast.makeText(this, getString(R.string.not_chosen)+" "+getString(R.string.theme_select), Toast.LENGTH_SHORT).show()
            else taskSelect(viewModel)
        }
    }

    private fun langSelect(viewModel: SharedViewModel){
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
            if (viewModel.getDfcltyValue() != null)
                main(viewModel)
            else dfcltySelect(viewModel)
        }

        val btn_next2 = findViewById<Button>(R.id.button2)
        btn_next2.setOnClickListener {
            viewModel.setLang(2)
            if (viewModel.getDfcltyValue() != null)
                main(viewModel)
            else dfcltySelect(viewModel)
        }

        val btn_next3 = findViewById<Button>(R.id.button3)
        btn_next3.setOnClickListener {
            viewModel.setLang(3)
            if (viewModel.getDfcltyValue() != null)
                main(viewModel)
            else dfcltySelect(viewModel)
        }

        val btn_next4 = findViewById<Button>(R.id.button4)
        btn_next4.setOnClickListener {
            viewModel.setLang(4)
            if (viewModel.getDfcltyValue() != null)
                main(viewModel)
            else dfcltySelect(viewModel)
        }
    }
    
    private fun dfcltySelect(viewModel: SharedViewModel){ 
        setContentView(R.layout.activity_difficulty_select)

        //back
        val btn_back = findViewById<ImageButton>(R.id.back)
        btn_back.setBackgroundColor(Color.parseColor("#E7EAEF"))
        btn_back.setImageResource(R.drawable.back_arrow__1_)
        btn_back.setOnClickListener {
            if (viewModel.getLangValue() != null)
                main(viewModel)
            else langSelect(viewModel)
        }
        //next
        val btn_next1 = findViewById<Button>(R.id.easyButton)
        btn_next1.setOnClickListener {
            viewModel.setDfclty(1)
            if (viewModel.getTopicValue() != null)
                main(viewModel)
            else themeSelect(viewModel)
        }

        val btn_next2 = findViewById<Button>(R.id.midButton)
        btn_next2.setOnClickListener {
            viewModel.setDfclty(2)
            if (viewModel.getTopicValue() != null)
                main(viewModel)
            else themeSelect(viewModel)
        }

        val btn_next3 = findViewById<Button>(R.id.hardButton)
        btn_next3.setOnClickListener {
            viewModel.setDfclty(3)
            if (viewModel.getTopicValue() != null)
                main(viewModel)
            else themeSelect(viewModel)
        }

        val btn_next4 = findViewById<Button>(R.id.testButton)
        btn_next4.setOnClickListener {
            viewModel.setDfclty(0)
            if (viewModel.getTopicValue() != null)
                main(viewModel)
            else themeSelect(viewModel)
        }
    }

    private fun themeSelect(viewModel: SharedViewModel){
        setContentView(R.layout.activity_theme_select)
        //back
        val btn_back = findViewById<ImageButton>(R.id.back)
        btn_back.setBackgroundColor(Color.parseColor("#E7EAEF"))
        btn_back.setImageResource(R.drawable.back_arrow__1_)
        btn_back.setOnClickListener {
            if (viewModel.getDfcltyValue() != null)
                main(viewModel)
            else dfcltySelect(viewModel)
        }
        //next
        val btn_next1 = findViewById<Button>(R.id.topic1)
        btn_next1.setOnClickListener {
            viewModel.setTopic(1)
            if (viewModel.getTaskValue() != null)
                main(viewModel)
            else taskSelect(viewModel)
        }

        val btn_next2 = findViewById<Button>(R.id.topic2)
        btn_next2.setOnClickListener {
            viewModel.setTopic(2)
            if (viewModel.getTaskValue() != null)
                main(viewModel)
            else taskSelect(viewModel)
        }

        val btn_next3 = findViewById<Button>(R.id.topic3)
        btn_next3.setOnClickListener {
            viewModel.setTopic(3)
            if (viewModel.getTaskValue() != null)
                main(viewModel)
            else taskSelect(viewModel)
        }

        val btn_next4 = findViewById<Button>(R.id.topic4)
        btn_next4.setOnClickListener {
            viewModel.setTopic(4)
            if (viewModel.getTaskValue() != null)
                main(viewModel)
            else taskSelect(viewModel)
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

        val clearData = findViewById<Button>(R.id.reset)
        clearData.setOnClickListener{
            viewModel.clearInstance(this)
            main(viewModel)
        }

        val l : String = when (viewModel.lang.value){
            1 -> getString(R.string.lang_value1)
            2 -> getString(R.string.lang_value2)
            3 -> getString(R.string.lang_value3)
            4 -> getString(R.string.lang_value4)
            else -> getString(R.string.not_chosen)
        }

        val d : String = when (viewModel.dfclty.value){
            1 -> getString(R.string.easy)
            2 -> getString(R.string.mid)
            3 -> getString(R.string.hard)
            0 -> getString(R.string.test)
            else -> getString(R.string.not_chosen)
        }

        val to : String = when (viewModel.topic.value){
            1 -> getString(R.string.topic1)
            2 -> getString(R.string.topic2)
            3 -> getString(R.string.topic3)
            4 -> getString(R.string.topic4)
            else -> getString(R.string.not_chosen)
        }

        var ta : String = getString(R.string.not_chosen)
        viewModel.task.value?.let {
            ta = if(it > 12 || it < 0) getString(R.string.not_chosen)
            else viewModel.task.value.toString()
        }


        lang_field.text = "Язык: " + l
        topic_field.text = "Тема: " + to
        difficulty_field.text = "Сложность: " + d
        task_field.text = "Задание: " + ta
    }
}