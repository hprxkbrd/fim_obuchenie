package com.example.fim_obuchenie

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [Tasks::class],
    version = 1,
)

abstract class TasksDB : RoomDatabase() {
    abstract fun tasksDao(): TasksDao

    companion object {
        fun getDatabase(context: Context): TasksDB {
            return Room.databaseBuilder(
                context.applicationContext,
                TasksDB::class.java,
                "tasks_database"
            ).build()
        }
    }
}
