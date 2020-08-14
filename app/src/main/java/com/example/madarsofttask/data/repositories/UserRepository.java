package com.example.madarsofttask.data.repositories;

import androidx.lifecycle.MutableLiveData;
import com.example.madarsofttask.data.models.User;
import java.util.List;
import static com.example.madarsofttask.application.BaseApplication.userDatabase;

public class UserRepository {
    private static UserRepository instance;

    public static UserRepository getInstance(){
       if(instance == null){
           instance = new UserRepository();
       }
       return instance;
    }

    public MutableLiveData<List<User>> getUsers(){
        List<User> users = userDatabase.myDAO().retrieveUsers();
        MutableLiveData<List<User>> usersData = new MutableLiveData<>();
        usersData.setValue(users);
        return usersData;
    }

    public void saveUser(User user) {
        userDatabase.myDAO().addUser(user);
    }
}
