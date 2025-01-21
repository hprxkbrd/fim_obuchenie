package com.example.fim_obuchenie

import android.content.Context
import android.nfc.Tag
import android.util.Log
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.fasterxml.jackson.module.kotlin.readValue
import java.io.File

class Model {

    private val mapper = ObjectMapper().registerModule(KotlinModule.Builder().build())

    fun createJsonInstanceFile(context: Context, data: User) {
        try {
            mapper.writeValue(File(context.filesDir, "savedInstance.json"), data)
            Log.d("JSON", "file created")
        } catch (e: Exception) {
            Log.d("JSON", "failed to create file. error: ${e.message}")
        }
    }

    fun readJsonInstanceFile(context: Context) : User{
        return try {
            mapper.readValue(File(context.filesDir, "savedInstance.json"))
        } catch (e: Exception) {
            Log.d("JSON", "failed to read file. error: ${e.message}")
            User(-1,-1,-1)
        }
    }
}
