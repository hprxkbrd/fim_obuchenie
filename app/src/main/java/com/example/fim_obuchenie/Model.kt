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

    suspend fun getLang(context: Context, langId: Int) : LangEntity{
        Log.d("getLang", "getLang start. langId: $langId")
        val db = getDataBase(context)
        Log.d("getLang", "getDataBase completed successfully")
        return withContext(Dispatchers.IO) {
            Log.d("getLang", "query to db started")
            val langEntity = db.langsDao().getLang(langId)
            Log.d("getLang", "query executed successfully, result: $langEntity")
            langEntity
        }
    }

    suspend fun getTopicList(context: Context, langId: Int, difficulty: Int) : List<TopicEntity>{
        Log.d("getTopicList", "getTopicList start. langId: $langId, difficulty: $difficulty")
        val db = getDataBase(context)
        Log.d("getTopicList", "getDataBase completed successfully")
        return withContext(Dispatchers.IO){
            Log.d("getTopicList", "query to db started")
            val topicEntity = db.topicDao().getTopics(langId, difficulty)
            Log.d("getTopicList", "query executed successfully, result: $topicEntity")
            topicEntity
        }
    }

    fun DBinit(context: Context){
        Log.d("DBinit", "model: connecting to db...")
        val db = getDataBase(context)
        Log.d("DBinit", "model: connected to db V")
        val langs : List<LangEntity> = listOf(
            LangEntity(1, "C++"),
            LangEntity(2, "Java"),
            LangEntity(3, "Python"),
            LangEntity(4, "JavaScript")
        )
        val topics: List<TopicEntity> = listOf(
            TopicEntity(1, "Переменные и типы данных", 1, 1),
            TopicEntity(2, "Условные конструкции", 1, 1),
            TopicEntity(3, "Циклы", 1, 1),
            TopicEntity(4, "Массивы", 1, 1),
            TopicEntity(5, "Работа со строками", 1, 2),
            TopicEntity(6, "Функции", 1, 2),
            TopicEntity(7, "Указатели", 1, 2),
            TopicEntity(8, "Работа с файлами", 1, 2),
            TopicEntity(9, "Создание классов и объектов", 1, 3),
            TopicEntity(10, "Конструкторы", 1, 3),
            TopicEntity(11, "Дружественные классы, наследование", 1, 3),
            TopicEntity(12, "Абстрактные классы и методы", 1, 3),
            TopicEntity(13, "Переменные и типы данных", 2, 1),
            TopicEntity(14, "Условные конструкции", 2, 1),
            TopicEntity(15, "Циклы", 2, 1),
            TopicEntity(16, "Массивы", 2, 1),
            TopicEntity(17, "Коллекции", 2, 2),
            TopicEntity(18, "Функции", 2, 2),
            TopicEntity(19, "Создание классов и объектов", 2, 2),
            TopicEntity(20, "Конструкторы класса", 2, 2),
            TopicEntity(21, "Наследование", 2, 3),
            TopicEntity(22, "Полиморфизм", 2, 3),
            TopicEntity(23, "Абстракции + Интерфейсы", 2, 3),
            TopicEntity(24, "Анонимные классы", 2, 3),
            TopicEntity(25, "Переменные и типы данных", 3, 1),
            TopicEntity(26, "Условные конструкции", 3, 1),
            TopicEntity(27, "Циклы", 3, 1),
            TopicEntity(28, "Списки", 3, 1),
            TopicEntity(29, "Работа со строками", 3, 2),
            TopicEntity(30, "Кортежи + Словари", 3, 2),
            TopicEntity(31, "Функции", 3, 2),
            TopicEntity(32, "Работа с файлами", 3, 2),
            TopicEntity(33, "Модули", 3, 3),
            TopicEntity(34, "Создание классов и объектов", 3, 3),
            TopicEntity(35, "Конструкторы", 3, 3),
            TopicEntity(36, "Наследование", 3, 3),
            TopicEntity(37, "Вывод информации", 4, 1),
            TopicEntity(38, "Переменные и типы данных", 4, 1),
            TopicEntity(39, "Математические действия", 4, 1),
            TopicEntity(40, "Условные конструкции", 4, 1),
            TopicEntity(41, "Циклы", 4, 2),
            TopicEntity(42, "Массивы", 4, 2),
            TopicEntity(43, "Функции", 4, 2),
            TopicEntity(44, "Всплывающие окна", 4, 2),
            TopicEntity(45, "Обработчик событий", 4, 3),
            TopicEntity(46, "Управление HTML", 4, 3),
            TopicEntity(47, "Таймеры и интервалы", 4, 3),
            TopicEntity(48, "Создание объектов, встроенные функции", 4, 3)
        )
        CoroutineScope(Dispatchers.IO).launch {
            Log.d("DBinit", "model: coroutine started V")

            Log.i("DBinit", "model coroutine: deleting langs...")
            try {
                db.langsDao().deleteLangs()
                Log.i("DBinit", "model coroutine: langs deleted V")
            }catch (e:Exception){
                Log.e("DBinit", "model coroutine: could not delete langs, error: ${e.message}")
            }

            Log.i("DBinit", "model coroutine: deleting topics...")
            try {
                db.topicDao().deleteTopics()
                Log.i("DBinit", "model coroutine: topics deleted V")
            }catch (e:Exception){
                Log.e("DBinit", "model coroutine: could not delete topics, error: ${e.message}")
            }

            try {
                Log.d("DBinit", "model coroutine: inserting langs...")
                db.langsDao().insertLangs(langs)
                Log.d("DBinit", "model coroutine: langs inserted successfully V")
            }catch (e:Exception){
                Log.e("DBinit", "model coroutine: could not insert langs, error: ${e.message}")
            }

            try {
                Log.d("DBinit", "model coroutine: inserting topics...")
                db.topicDao().insertTopics(topics)
                Log.d("DBinit", "model coroutine: topics inserted successfully V")
            }catch (e:Exception){
                Log.e("DBinit", "model coroutine: could not insert topics, error: ${e.message}")
            }
            Log.d("DBinit", "model: coroutine finished V")
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
