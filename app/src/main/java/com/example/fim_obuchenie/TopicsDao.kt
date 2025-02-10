package com.example.fim_obuchenie

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TopicsDao {
    @Query("SELECT * FROM topics WHERE lang_id = :langId AND difficulty = :difficulty")
    suspend fun getTopics(langId: Int, difficulty: Int): List<TopicEntity>

    @Insert
    suspend fun insertTopic(topic: TopicEntity)

    @Insert
    suspend fun insertTopics(topics: List<TopicEntity>)

    @Query("DELETE FROM topics")
    suspend fun deleteTopics()
}