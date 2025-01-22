package com.example.fim_obuchenie

import android.content.Context
import android.util.Log
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.fasterxml.jackson.module.kotlin.readValue
import java.io.File

data class User(val lang: Int?, val diff: Int?, val topic: Int?)

class Model {

    private val mapper = ObjectMapper().registerModule(KotlinModule.Builder().build())

    fun createJsonInstanceFile(context: Context, data: User) {
        val json = File(context.filesDir, "savedInstance.json")
        try {
            mapper.writeValue(json, data)
            Log.d("JSON", "file created. path: ${context.filesDir}")
        } catch (e: Exception) {
            Log.e("JSON", "failed to CREATE file. error: ${e.message}")
        }
    }

    fun readJsonInstanceFile(context: Context) : User{
        val json = File(context.filesDir, "savedInstance.json")
        return try {
            Log.d("JSON", "file reading")
            mapper.readValue(json)
        } catch (e: Exception) {
            Log.e("JSON", "failed to READ file. error: ${e.message} \ntrying to read from: ${context.filesDir}")
            User(-1,-1,-1)
        }
    }
}
