package com.example.madarsofttask.data.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.madarsofttask.data.models.User;

@Database(entities = {User.class}, version = 1)
public abstract class UserDatabase extends RoomDatabase {
    public abstract MyDAO myDAO();

}
