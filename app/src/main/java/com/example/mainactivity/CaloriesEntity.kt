package com.example.mainactivity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "calories_table")
data class CaloriesEntity (
    @ColumnInfo(name = "food") val food: String?,
    @ColumnInfo(name = "calories") val calories: Int?,
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
)