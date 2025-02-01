package com.example.fim_obuchenie

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface LangsDao {
    @Query("SELECT * FROM languages")
    suspend fun getLangages(): List<LangEntity>

    @Query("SELECT * FROM languages WHERE id = :langId")
    suspend fun getLang(langId: Int): LangEntity

    @Insert
    suspend fun insertLang(lang: LangEntity)

    @Insert
    suspend fun insertLangs(langs: List<LangEntity>)

    @Query("DELETE FROM languages")
    suspend fun deleteLangs()
}