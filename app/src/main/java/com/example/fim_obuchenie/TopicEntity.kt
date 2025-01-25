package com.example.fim_obuchenie

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "topics",
    indices = [Index(value = ["name", "lang_id"], unique = true)],
    foreignKeys = [
        ForeignKey(
            entity = LangEntity::class, // на какую таблицу ссылаемся
            parentColumns = ["id"], // столбец в родительской таблице
            childColumns = ["lang_id"], // наш столбец с внешним ключом
            onDelete = ForeignKey.CASCADE, // что делать при удалении родительской записи
            onUpdate = ForeignKey.CASCADE // что делать при обновлении родительской записи
        )
    ])
data class TopicEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 1,
    @ColumnInfo(name = "name") val topic_name: String,
    @ColumnInfo(name = "lang_id") val lang_id: Int,
    @ColumnInfo(name = "difficulty") val dfclty: Int,
)