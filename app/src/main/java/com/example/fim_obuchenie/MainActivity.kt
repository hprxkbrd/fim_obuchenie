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
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private val viewModel : SharedViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.restoreInstance(this)
        main(viewModel)
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.saveInstance(this)
        viewModel.dropLangs(this)
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
        
        val btnLangSlct = findViewById<Button>(R.id.lang_button)
        btnLangSlct.setOnClickListener {
            langSelect(viewModel)
        }

        val btnDfcltySlct = findViewById<Button>(R.id.difficulty_button)
        btnDfcltySlct.setOnClickListener {
            if (viewModel.getLangValue() == -1)
                Toast.makeText(this, getString(R.string.not_chosen)+" "+getString(R.string.lang_select), Toast.LENGTH_SHORT).show()
            else dfcltySelect(viewModel)
        }

        val btnTopicSlct = findViewById<Button>(R.id.theme_button)
        btnTopicSlct.setOnClickListener {
            if (viewModel.getDfcltyValue() == -1)
                Toast.makeText(this, getString(R.string.not_chosen)+" "+getString(R.string.difficulty_select), Toast.LENGTH_SHORT).show()
            else themeSelect(viewModel)
        }

        val btnTaskSlct = findViewById<Button>(R.id.task_button)
        btnTaskSlct.setOnClickListener {
            if (viewModel.getTopicValue() == -1)
                Toast.makeText(this, getString(R.string.not_chosen)+" "+getString(R.string.theme_select), Toast.LENGTH_SHORT).show()
            else taskSelect(viewModel)
        }
    }

    private fun langSelect(viewModel: SharedViewModel){
        setContentView(R.layout.activity_lang_select)
        //back
        val btnBack = findViewById<ImageButton>(R.id.back)
        btnBack.setBackgroundColor(Color.parseColor("#E7EAEF"))
        btnBack.setImageResource(R.drawable.back_arrow__1_)
        btnBack.setOnClickListener {
            main(viewModel)
        }
        //next

        val btnNext1 = findViewById<Button>(R.id.button1)
        val btnNext2 = findViewById<Button>(R.id.button2)
        val btnNext3 = findViewById<Button>(R.id.button3)
        val btnNext4 = findViewById<Button>(R.id.button4)

        CoroutineScope(Dispatchers.IO).launch(Dispatchers.IO + CoroutineName("language buttons text setting")) {
            btnNext1.text = viewModel.getLangName(this@MainActivity, 1)
            btnNext2.text = viewModel.getLangName(this@MainActivity, 2)
            btnNext3.text = viewModel.getLangName(this@MainActivity, 3)
            btnNext4.text = viewModel.getLangName(this@MainActivity, 4)
        }

        btnNext1.setOnClickListener {
            viewModel.setLang(1)
            if (viewModel.getDfcltyValue() != -1)
                main(viewModel)
            else dfcltySelect(viewModel)
        }

        btnNext2.setOnClickListener {
            viewModel.setLang(2)
            if (viewModel.getDfcltyValue() != -1)
                main(viewModel)
            else dfcltySelect(viewModel)
        }

        btnNext3.setOnClickListener {
            viewModel.setLang(3)
            if (viewModel.getDfcltyValue() != -1)
                main(viewModel)
            else dfcltySelect(viewModel)
        }

        btnNext4.setOnClickListener {
            viewModel.setLang(4)
            if (viewModel.getDfcltyValue() != -1)
                main(viewModel)
            else dfcltySelect(viewModel)
        }
    }
    
    private fun dfcltySelect(viewModel: SharedViewModel){ 
        setContentView(R.layout.activity_difficulty_select)

        //back
        val btnBack = findViewById<ImageButton>(R.id.back)
        btnBack.setBackgroundColor(Color.parseColor("#E7EAEF"))
        btnBack.setImageResource(R.drawable.back_arrow__1_)
        btnBack.setOnClickListener {
            if (viewModel.getLangValue() != -1)
                main(viewModel)
            else langSelect(viewModel)
        }
        //next
        val btnNext1 = findViewById<Button>(R.id.easyButton)
        btnNext1.setOnClickListener {
            viewModel.setDfclty(1)
            if (viewModel.getTopicValue() != -1)
                main(viewModel)
            else themeSelect(viewModel)
        }

        val btnNext2 = findViewById<Button>(R.id.midButton)
        btnNext2.setOnClickListener {
            viewModel.setDfclty(2)
            if (viewModel.getTopicValue() != -1)
                main(viewModel)
            else themeSelect(viewModel)
        }

        val btnNext3 = findViewById<Button>(R.id.hardButton)
        btnNext3.setOnClickListener {
            viewModel.setDfclty(3)
            if (viewModel.getTopicValue() != -1)
                main(viewModel)
            else themeSelect(viewModel)
        }

        val btnNext4 = findViewById<Button>(R.id.testButton)
        btnNext4.setOnClickListener {
            viewModel.setDfclty(0)
            if (viewModel.getTopicValue() != -1)
                main(viewModel)
            else themeSelect(viewModel)
        }
    }

    private fun themeSelect(viewModel: SharedViewModel){
        setContentView(R.layout.activity_theme_select)
        //back
        val btnBack = findViewById<ImageButton>(R.id.back)
        btnBack.setBackgroundColor(Color.parseColor("#E7EAEF"))
        btnBack.setImageResource(R.drawable.back_arrow__1_)
        btnBack.setOnClickListener {
            if (viewModel.getDfcltyValue() != -1)
                main(viewModel)
            else dfcltySelect(viewModel)
        }
        //next
        val btnNext1 = findViewById<Button>(R.id.topic1)
        val btnNext2 = findViewById<Button>(R.id.topic2)
        val btnNext3 = findViewById<Button>(R.id.topic3)
        val btnNext4 = findViewById<Button>(R.id.topic4)

        CoroutineScope(Dispatchers.IO).launch(Dispatchers.IO + CoroutineName("topic buttons text setting")) {
            btnNext1.text = viewModel.getTopicName(this@MainActivity,
                viewModel.getLangValue(), viewModel.getDfcltyValue(), 1)
            btnNext2.text = viewModel.getTopicName(this@MainActivity,
                viewModel.getLangValue(), viewModel.getDfcltyValue(), 2)
            btnNext3.text = viewModel.getTopicName(this@MainActivity,
                viewModel.getLangValue(), viewModel.getDfcltyValue(), 3)
            btnNext4.text = viewModel.getTopicName(this@MainActivity,
                viewModel.getLangValue(), viewModel.getDfcltyValue(), 4)
        }

        btnNext1.setOnClickListener {
            viewModel.setTopic(1)
            if (viewModel.getTaskValue() != -1)
                main(viewModel)
            else taskSelect(viewModel)
        }

        btnNext2.setOnClickListener {
            viewModel.setTopic(2)
            if (viewModel.getTaskValue() != -1)
                main(viewModel)
            else taskSelect(viewModel)
        }

        btnNext3.setOnClickListener {
            viewModel.setTopic(3)
            if (viewModel.getTaskValue() != -1)
                main(viewModel)
            else taskSelect(viewModel)
        }

        btnNext4.setOnClickListener {
            viewModel.setTopic(4)
            if (viewModel.getTaskValue() != -1)
                main(viewModel)
            else taskSelect(viewModel)
        }
    }
    
    private fun taskSelect(viewModel: SharedViewModel){
        setContentView(R.layout.activity_task_select)

        //back
        val btnBack = findViewById<ImageButton>(R.id.back)
        btnBack.setBackgroundColor(Color.parseColor("#E7EAEF"))
        btnBack.setImageResource(R.drawable.back_arrow__1_)
        btnBack.setOnClickListener {
            themeSelect(viewModel)
        }

        //next
        val btnNext1 = findViewById<Button>(R.id.task1)
        val btnNext2 = findViewById<Button>(R.id.task2)
        val btnNext3 = findViewById<Button>(R.id.task3)
        val btnNext4 = findViewById<Button>(R.id.task4)
        val btnNext5 = findViewById<Button>(R.id.task5)
        val btnNext6 = findViewById<Button>(R.id.task6)
        val btnNext7 = findViewById<Button>(R.id.task7)
        val btnNext8 = findViewById<Button>(R.id.task8)
        val btnNext9 = findViewById<Button>(R.id.task9)
        val btnNext10 = findViewById<Button>(R.id.task10)
        val btnNext11 = findViewById<Button>(R.id.task11)
        val btnNext12 = findViewById<Button>(R.id.task12)

        btnNext1.setOnClickListener {
            viewModel.setTask(1)
            userData(viewModel)
        }

        btnNext2.setOnClickListener {
            viewModel.setTask(2)
            userData(viewModel)
        }

        btnNext3.setOnClickListener {
            viewModel.setTask(3)
            userData(viewModel)
        }

        btnNext4.setOnClickListener {
            viewModel.setTask(4)
            userData(viewModel)
        }

        btnNext5.setOnClickListener {
            viewModel.setTask(5)
            userData(viewModel)
        }

        btnNext6.setOnClickListener {
            viewModel.setTask(6)
            userData(viewModel)
        }

        btnNext7.setOnClickListener {
            viewModel.setTask(7)
            userData(viewModel)
        }

        btnNext8.setOnClickListener {
            viewModel.setTask(8)
            userData(viewModel)
        }

        btnNext9.setOnClickListener {
            viewModel.setTask(9)
            userData(viewModel)
        }

        btnNext10.setOnClickListener {
            viewModel.setTask(10)
            userData(viewModel)
        }

        btnNext11.setOnClickListener {
            viewModel.setTask(11)
            userData(viewModel)
        }

        btnNext12.setOnClickListener {
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