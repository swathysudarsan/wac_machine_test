package com.example.sampleappwac.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.sampleappwac.api.HomeResponse

@Dao
interface UserDao {
    @Insert
    suspend fun insertUser(user: HomeResponse)

    @Query("SELECT * FROM HomeResponseItem")
    fun getAllData(): LiveData<List<HomeResponse>>
}