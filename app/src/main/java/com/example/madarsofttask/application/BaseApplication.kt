package com.example.madarsofttask.application

import android.app.Application
import androidx.room.Room
import com.example.madarsofttask.data.db.UserDatabase

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initDB()
    }

    private fun initDB() {
        userDatabase = Room.databaseBuilder(applicationContext, UserDatabase::class.java, "userDB").allowMainThreadQueries().build()
    }

    companion object {
        @JvmField
        var userDatabase: UserDatabase? = null
    }
}