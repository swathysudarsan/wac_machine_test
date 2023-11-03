package com.example.sampleappwac.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.sampleappwac.api.HomeResponse

@Database(entities = [HomeResponse.HomeResponseItem::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}