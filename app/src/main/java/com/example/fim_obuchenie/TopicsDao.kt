package com.example.fim_obuchenie

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TopicsDao {
    @Query("SELECT * FROM topics")
    suspend fun getAllTopics(): List<LangEntity>

    @Query("SELECT * FROM topics WHERE lang_id = 1 AND difficulty = 1")
    suspend fun getTopics1E(): List<LangEntity>

    @Query("SELECT * FROM topics WHERE lang_id = 1 AND difficulty = 2")
    suspend fun getTopics1M(): List<LangEntity>

    @Query("SELECT * FROM topics WHERE lang_id = 1 AND difficulty = 3")
    suspend fun getTopics1H(): List<LangEntity>

    @Query("SELECT * FROM topics WHERE lang_id = 2 AND difficulty = 1")
    suspend fun getTopics2E(): List<LangEntity>

    @Query("SELECT * FROM topics WHERE lang_id = 2 AND difficulty = 2")
    suspend fun getTopics2M(): List<LangEntity>

    @Query("SELECT * FROM topics WHERE lang_id = 2 AND difficulty = 3")
    suspend fun getTopics2H(): List<LangEntity>

    @Query("SELECT * FROM topics WHERE lang_id = 3 AND difficulty = 1")
    suspend fun getTopics3E(): List<LangEntity>

    @Query("SELECT * FROM topics WHERE lang_id = 3 AND difficulty = 2")
    suspend fun getTopics3M(): List<LangEntity>

    @Query("SELECT * FROM topics WHERE lang_id = 3 AND difficulty = 3")
    suspend fun getTopics3H(): List<LangEntity>

    @Query("SELECT * FROM topics WHERE lang_id = 4 AND difficulty = 1")
    suspend fun getTopics4E(): List<LangEntity>

    @Query("SELECT * FROM topics WHERE lang_id = 4 AND difficulty = 2")
    suspend fun getTopics4M(): List<LangEntity>

    @Query("SELECT * FROM topics WHERE lang_id = 4 AND difficulty = 3")
    suspend fun getTopics4H(): List<LangEntity>

    @Insert
    suspend fun insertTopic(topic: TopicEntity)

    @Insert
    suspend fun insertTopics(topics: List<TopicEntity>)
}