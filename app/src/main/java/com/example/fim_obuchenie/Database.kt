package com.example.fim_obuchenie

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [LangEntity::class, TopicEntity::class],  version = 1)
abstract class TasksDatabase : RoomDatabase() {
    abstract fun langsDao(): LangsDao
    abstract  fun topicDao(): TopicsDao
}

