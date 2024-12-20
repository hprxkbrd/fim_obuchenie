package com.example.fim_obuchenie

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface TasksDao {
    @Insert
    suspend fun insert(task: Tasks)

    @Query("SELECT * FROM tasks")
    suspend fun getAll(): List<Tasks>

    @Query("SELECT * FROM tasks WHERE id = :uid")
    suspend fun getTaskById(uid: Int): Tasks?

    @Update
    suspend fun update(task: Tasks)

    @Delete
    suspend fun delete(task: Tasks)
}