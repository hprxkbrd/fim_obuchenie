package com.example.fim_obuchenie

import android.app.Application
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner

abstract class FIM_Obuchenie : Application(), ViewModelStoreOwner{
    private lateinit var appViewModelStore: ViewModelStore

    override fun onCreate() {
        super.onCreate()
        appViewModelStore = ViewModelStore()
    }
}