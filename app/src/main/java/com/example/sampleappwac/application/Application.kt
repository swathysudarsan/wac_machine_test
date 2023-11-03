package com.example.sampleappwac.application

import android.app.Application
import androidx.room.Room
import com.example.sampleappwac.database.AppDatabase

class Application : Application() {

    companion object {

        lateinit var instance: com.example.sampleappwac.application.Application
        lateinit var appDatabase: AppDatabase
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        appDatabase = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "app-database").build()

    }
}