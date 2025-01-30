package com.example.fim_obuchenie

import android.content.Context
import android.database.sqlite.SQLiteConstraintException
import android.util.Log
import androidx.room.Room
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.fasterxml.jackson.module.kotlin.readValue
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.File

class Model {

    private val mapper = ObjectMapper().registerModule(KotlinModule.Builder().build())

    private fun getDataBase(context: Context) : TasksDatabase{
        return TasksDatabase.getDB(context)
    }

    fun insertLang(context: Context, item : LangEntity){
        val db = getDataBase(context)
        CoroutineScope(Dispatchers.IO).launch {
            try {
                db.langsDao().insertLang(item)
                Log.i("db-debug", "lang ${item.lang_name} inserted")
            }catch (e:SQLiteConstraintException){
                Log.e("db-debug", "could not insert ${item.lang_name}: ${e.message}")
            }
        }
    }

    fun clearLang(context: Context){
        val db = getDataBase(context)
        CoroutineScope(Dispatchers.IO).launch {
            db.langsDao().deleteLangs()
            Log.i("db-debug", "data cleared")
        }
    }

    suspend fun getLang(context: Context, langId: Int) : LangEntity{
        val db = getDataBase(context)
        return withContext(Dispatchers.IO) {
            when (langId) {
                1 -> db.langsDao().getLang1()
                2 -> db.langsDao().getLang2()
                3 -> db.langsDao().getLang3()
                4 -> db.langsDao().getLang4()
                else -> throw IllegalArgumentException("Invalid langId: $langId")
            }
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
