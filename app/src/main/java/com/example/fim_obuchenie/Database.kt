package com.example.fim_obuchenie

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [LangEntity::class, TopicEntity::class],  version = 2)
abstract class TasksDatabase : RoomDatabase() {
    abstract fun langsDao(): LangsDao
    abstract  fun topicDao(): TopicsDao

    companion object{
        fun getDB(context: Context) : TasksDatabase{
            return Room.databaseBuilder(context.applicationContext,
                TasksDatabase::class.java,
                "tasks.db"
            ).build()
        }
    }
}

