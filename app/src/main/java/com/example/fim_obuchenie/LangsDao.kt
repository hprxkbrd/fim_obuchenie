package com.example.fim_obuchenie

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface LangsDao {
    @Query("SELECT * FROM languages")
    suspend fun getLangages(): List<LangEntity>

    @Query("SELECT * FROM languages WHERE id = 1")
    suspend fun getLang1(): LangEntity

    @Query("SELECT * FROM languages WHERE id = 2")
    suspend fun getLang2(): LangEntity

    @Query("SELECT * FROM languages WHERE id = 3")
    suspend fun getLang3(): LangEntity

    @Query("SELECT * FROM languages WHERE id = 4")
    suspend fun getLang4(): LangEntity

    @Insert
    suspend fun insertLang(lang: LangEntity)

    @Insert
    suspend fun insertLangs(langs: List<LangEntity>)

    @Query("DELETE FROM languages")
    suspend fun deleteLangs()
}