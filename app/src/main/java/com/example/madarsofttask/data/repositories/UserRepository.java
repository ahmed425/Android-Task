package com.example.madarsofttask.data.repositories;

import androidx.lifecycle.LiveData;

import com.example.madarsofttask.data.models.User;

import java.util.List;

import static com.example.madarsofttask.application.BaseApplication.userDatabase;

public class UserRepository {
    private static UserRepository instance;

    public static UserRepository getInstance() {
        if (instance == null) {
            instance = new UserRepository();
        }
        return instance;
    }

    public LiveData<List<User>> getUsers() {
        return userDatabase.myDAO().retrieveUsers();
    }

    public void saveUser(User user) {
        userDatabase.myDAO().addUser(user);
    }
}
