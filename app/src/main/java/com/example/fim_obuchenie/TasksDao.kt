package com.example.fim_obuchenie

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TasksDao {
    @Query("SELECT * FROM tasks WHERE topicId = :topicId")
    suspend fun getTasks(topicId : Int): List<TaskEntity>

    @Query("UPDATE tasks SET isCompleted = 1 WHERE id = :taskId")
    suspend fun completeTask(taskId : Int)

    @Insert
    suspend fun insertTask(task : TaskEntity)

    @Insert
    suspend fun insertTasks(tasks : List<TaskEntity>)

    @Query("DELETE FROM tasks")
    suspend fun deleteTasks()
}