package com.example.fim_obuchenie

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "tasks",
    foreignKeys = [
        ForeignKey(
            entity = TopicEntity::class,
            parentColumns = ["id"],
            childColumns = ["topicId"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        )
    ])
data class TaskEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 1,
    @ColumnInfo(name = "type") val type: Int,
    @ColumnInfo(name = "description") val desc : String,
    @ColumnInfo(name = "codeFragments") val codeFragments : List<CodeFragment>,
    @ColumnInfo(name = "answers") val answers : List<List<Int>>,
    @ColumnInfo(name = "hint") val hint : String,
    @ColumnInfo(name = "topicId") val topicId : Int,
    @ColumnInfo(name = "isCompleted") val isCompl : Boolean = false
)
