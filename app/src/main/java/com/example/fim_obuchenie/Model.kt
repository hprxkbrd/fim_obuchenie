package com.example.fim_obuchenie

import android.content.Context
import android.util.Log
import androidx.room.Room
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.fasterxml.jackson.module.kotlin.readValue
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.File

class Model {

    private val mapper = ObjectMapper().registerModule(KotlinModule.Builder().build())

    private fun getDataBase(context: Context) : TasksDatabase{
        return TasksDatabase.getDB(context)
    }

    fun insertLang(context: Context, item : LangEntity){
        val db = getDataBase(context)
        CoroutineScope(Dispatchers.IO).launch {
            db.langsDao().insertLang(item)
        }
    }

    fun clearLang(context: Context){
        val db = getDataBase(context)
        CoroutineScope(Dispatchers.IO).launch {
            db.langsDao().deleteLangs()
        }
    }

    fun insertTopic(context: Context, item : TopicEntity){
        val db = getDataBase(context)
        CoroutineScope(Dispatchers.IO).launch {
            db.topicDao().insertTopic(item)
        }
    }

    fun createJsonInstanceFile(context: Context, data: User) {
        try {
            mapper.writeValue(File(context.filesDir, "savedInstance.json"), data)
            Log.d("JSON", "file created. path: ${context.filesDir}")
        } catch (e: Exception) {
            Log.d("JSON", "failed to create file. error: ${e.message}")
        }
    }

    fun readJsonInstanceFile(context: Context) : User{
        return try {
            mapper.readValue(File(context.filesDir, "savedInstance.json"))
        } catch (e: Exception) {
            Log.d("JSON", "failed to read file. error: ${e.message}")
            User(-1,-1,-1)
        }
    }
}
