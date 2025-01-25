package com.example.fim_obuchenie

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "languages",
    indices = [Index(value = ["name"], unique = true)]
)
data class LangEntity(
    @PrimaryKey(autoGenerate = true) val id: Int? = 1,
    @ColumnInfo(name = "name") val lang_name: String,
)
