package com.example.fim_obuchenie

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.fasterxml.jackson.module.kotlin.readValue
import java.io.File

class Model {

    private val mapper = ObjectMapper().registerModule(KotlinModule.Builder().build())

    fun createJsonInstanceFile(data: User) {
        try {
            mapper.writeValue(File("savedInstance.json"), data)
            println("JSON файл savedInstance.json успешно создан.")
        } catch (e: Exception) {
            println("Ошибка при создании JSON файла: ${e.message}")
        }
    }

    fun readJsonInstanceFile() : User{
        return try {
            mapper.readValue(File("savedInstance.json"))
        } catch (e: Exception) {
            println("Error during JSON to POJO conversion: ${e.message}")
            User(-1,-1,-1)
        }
    }
}
