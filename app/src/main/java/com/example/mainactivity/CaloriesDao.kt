package com.example.mainactivity

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface CaloriesDao {
    @Query("SELECT * FROM calories_table")
    fun getAll(): Flow<List<CaloriesEntity>>

    @Insert
    fun insert(caloriesItem: CaloriesEntity)

    @Query("DELETE FROM calories_table")
    fun deleteAll()
}