package com.example.mainactivity

import android.app.Application


class CaloriesApplication: Application() {
    val db by lazy { AppDatabase.getInstance(this) }
}