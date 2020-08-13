package com.example.madarsofttask.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.madarsofttask.models.User;

@Database(entities = {User.class},version = 1)
public abstract class MyAppDatabase extends RoomDatabase {
public abstract MyDAO myDAO();

}
