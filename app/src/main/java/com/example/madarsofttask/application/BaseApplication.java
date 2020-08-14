package com.example.madarsofttask.application;

import android.app.Application;

import androidx.room.Room;

import com.example.madarsofttask.data.db.UserDatabase;

public class BaseApplication extends Application {
    public static UserDatabase userDatabase;

    @Override
    public void onCreate() {
        super.onCreate();
        initDB();
    }

    private void initDB() {
        userDatabase = Room.databaseBuilder(getApplicationContext(), UserDatabase.class, "userDB").allowMainThreadQueries().build();
    }
}
