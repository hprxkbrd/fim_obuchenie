package com.example.fim_obuchenie

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.io.File
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.fasterxml.jackson.module.kotlin.readValue
import java.io.FileNotFoundException
import java.io.IOException


data class User(val lang: Int?, val diff: Int?, val topic: Int?)

class SharedViewModel : ViewModel(){

    private val model = Model()

    private val _lang = MutableLiveData<Int>()
    private val _topic = MutableLiveData<Int>()
    private val _dfclty = MutableLiveData<Int>()
    private val _task = MutableLiveData<Int>()
    private val _cmpltdtask = MutableLiveData<Int>()

    // Публичные LiveData для наблюдения
    val lang: LiveData<Int> get() = _lang
    val topic: LiveData<Int> get() = _topic
    val dfclty: LiveData<Int> get() = _dfclty
    val task: LiveData<Int> get() = _task
    val cmpltdtask: LiveData<Int> get() = _cmpltdtask

    fun saveInstance(context: Context){
        model.createJsonInstanceFile(context, User(_lang.value, _dfclty.value, _topic.value))
    }

    fun clearInstance(context: Context){
        model.createJsonInstanceFile(context, User(-1, -1, -1))
        setTask(-1)
        restoreInstance(context)
    }

    fun restoreInstance(context: Context){
        try {
            setLang(model.readJsonInstanceFile(context).lang)
            setDfclty(model.readJsonInstanceFile(context).diff)
            setTopic(model.readJsonInstanceFile(context).topic)
        } catch (e:FileNotFoundException){
            Log.d("JSON", "could not restore the instance. error : ${e.message}")
        }
    }

    // Функции для изменения приватных MutableLiveData
    fun setLang(lang_new: Int?) {
        _lang.value = lang_new ?: -1
    }

    fun setTopic(topic_new: Int?) {
        _topic.value = topic_new ?: -1
    }

    fun setDfclty(dfclty_new: Int?) {
        _dfclty.value = dfclty_new ?: -1
    }

    fun setTask(task_new: Int) {
        _task.value = task_new
    }

    fun setCmpltdTask(cmpltd_new: Int) {
        _cmpltdtask.value = cmpltd_new
    }

    // Функции для получения текущего значения (могут быть полезны в некоторых случаях)
    fun getLangValue() : Int? = _lang.value
    fun getTopicValue() : Int? = _topic.value
    fun getDfcltyValue() : Int? = _dfclty.value
    fun getTaskValue() : Int? = _task.value
    fun getCmpltdTaskValue() : Int? = _cmpltdtask.value
}
