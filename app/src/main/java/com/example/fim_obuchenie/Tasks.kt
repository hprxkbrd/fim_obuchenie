package com.example.fim_obuchenie

import androidx.room.*

@Entity(tableName = "tasks")
data class Tasks(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "language_ID") val langId: String,
    @ColumnInfo(name = "theme_ID") val themeId: String,
    @ColumnInfo(name = "difficulty") val difficulty: Int = -1
)