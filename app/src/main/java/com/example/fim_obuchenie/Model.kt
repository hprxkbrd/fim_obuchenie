package com.example.fim_obuchenie

import android.content.Context
import android.util.Log
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

    suspend fun getTopic(context: Context, langId: Int, difficulty: Int) : List<TopicEntity>{
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

    suspend fun getTasks(context: Context, topicId : Int): List<TaskEntity>{
        Log.d("getTasks", "getTasks start. topicId: $topicId")
        val db = getDataBase(context)
        Log.d("getTasks", "getDataBase completed successfully")
        return withContext(Dispatchers.IO) {
            Log.d("getTasks", "query to db started")
            val taskEntity = db.taskDao().getTasks(topicId)
            Log.d("getTasks", "query executed successfully, result: $taskEntity")
            taskEntity
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

//            --copypaste--
//            TaskEntity(id = 1, type = 1, desc = "",
//                codeFragments = listOf(
//                    CodeFragment(0, ""),
//                    CodeFragment(1, ""),
//                    CodeFragment(2, ""),
//                    CodeFragment(3, ""),
//                    CodeFragment(4, "")
//                ),
//                answers = listOf(
//                    listOf(0,1,2,3,4)
//                ),
//                hint = "",
//                topicId = 1
//            )

        val tasks: List<TaskEntity> = listOf(
            TaskEntity(id = 1, type = 1, desc = "Напишите программу, которая запрашивает у пользователя температуру в градусах Цельсия, а затем выводит эту температуру в градусах Фаренгейта.",
                codeFragments = listOf(
                    CodeFragment(0, "float celsius, fahrenheit;"),
                    CodeFragment(1, "cout << \"Введите температуру в градусах Цельсия: \";"),
                    CodeFragment(2, "cin >> celsius;"),
                    CodeFragment(3, "fahrenheit = (celsius * 9.0 / 5.0) + 32.0;"),
                    CodeFragment(4, "cout << \"Температура в градусах Фаренгейта: \" << fahrenheit << endl;")
                ),
                answers = listOf(
                    listOf(0,1,2,3,4)
                ),
                hint = "Используйте типы данных float или double для хранения температуры, чтобы избежать потери точности при вычислениях. Не забудьте о вводе и выводе данных (cin и cout).",
                topicId = 1
            ),
            TaskEntity(id = 2, type = 1, desc = "Напишите программу, которая запрашивает у пользователя длину и ширину прямоугольника, а затем выводит его площадь и периметр.",
                codeFragments = listOf(
                    CodeFragment(0, "float length, width, area, perimeter;"),
                    CodeFragment(1, "cout << \"Введите длину прямоугольника: \";"),
                    CodeFragment(2, "cin >> length;"),
                    CodeFragment(3, "cout << \"Введите ширину прямоугольника: \";"),
                    CodeFragment(4, "cin >> width;"),
                    CodeFragment(5, "area = length * width;")
                ),
                answers = listOf(
                    listOf(0,1,2,3,4,5),
                    listOf(0,3,4,1,2,5)
                ),
                hint = "Используйте типы данных int или float для хранения длины и ширины.",
                topicId = 1
            ),
            TaskEntity(id = 3, type = 1, desc = "Напишите программу, которая запрашивает у пользователя три целых числа, а затем выводит их среднее арифметическое.",
                codeFragments = listOf(
                    CodeFragment(0, "int num1, num2, num3;"),
                    CodeFragment(1, "float average;"),
                    CodeFragment(2, "cout << \"Введите первое целое число: \";"),
                    CodeFragment(3, "cin >> num1;"),
                    CodeFragment(4, "cout << \"Введите второе целое число: \";"),
                    CodeFragment(5, "cin >> num2;"),
                    CodeFragment(6, "cout << \"Введите третье целое число: \";"),
                    CodeFragment(7, "cin >> num3;"),
                    CodeFragment(8, "average = (float)(num1 + num2 + num3) / 3.0;"),
                    CodeFragment(9, "cout << \"Среднее арифметическое: \" << average << endl;")
                ),answers = listOf(
                    listOf(0,1,2,3,4,5,6,7,8,9),
                    listOf(1,0,2,3,4,5,6,7,8,9)
                ),
                hint = "Используйте тип данных int для хранения чисел. Чтобы получить более точное среднее арифметическое, можно привести сумму к типу float или double перед делением..",
                topicId = 1
            ),
            TaskEntity(id = 4,type = 1, desc = "Напишите программу, которая запрашивает у пользователя два целых числа, а затем меняет их значения местами и выводит результат.",
                codeFragments = listOf(
                    CodeFragment(0, "int num1, num2, temp;"),
                    CodeFragment(1, "cout << \"Введите первое целое число: \";"),
                    CodeFragment(2, "cin >> num1;"),
                    CodeFragment(3, "cout << \"Введите второе целое число: \";"),
                    CodeFragment(4, "cin >> num2;"),
                    CodeFragment(5, "cout << \"До обмена: num1 = \" << num1 << \", num2 = \" << num2 << endl;"),
                    CodeFragment(6, "temp = num1;"),
                    CodeFragment(7, "num1 = num2;"),
                    CodeFragment(8, "num2 = temp;"),
                    CodeFragment(9, "cout << \"После обмена: num1 = \" << num1 << \", num2 = \" << num2 << endl;"),
                ),
                answers = listOf(
                    listOf()
                ),
                hint = "Используйте временную переменную для хранения значения одного из чисел во время обмена. (Это классический способ).",
                topicId = 1
            ),
            TaskEntity(id = 5, type = 1, desc = "Напишите программу, которая запрашивает у пользователя его год рождения, а затем вычисляет и выводит его возраст в текущем году. Предположим, что текущий год - 2024.",
                codeFragments = listOf(
                    CodeFragment(0, "int birthYear, age;"),
                    CodeFragment(1, "int currentYear = 2025;"),
                    CodeFragment(2, "cout << \"Введите год вашего рождения: \";"),
                    CodeFragment(3, "cin >> birthYear;"),
                    CodeFragment(4, "age = currentYear - birthYear;"),
                    CodeFragment(5, "cout << \"Ваш возраст в \" << currentYear << \" году: \" << age << endl;")
                ),
                answers = listOf(
                    listOf(0,1,2,3,4,5),
                    listOf(1,0,2,3,4,5)
                ),
                hint = "Используйте тип данных int для хранения года рождения. Для простоты предположите, что у пользователя уже был день рождения в текущем году.",
                topicId = 1
            )
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
