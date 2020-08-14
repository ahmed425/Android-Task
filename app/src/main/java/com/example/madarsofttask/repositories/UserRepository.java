package com.example.madarsofttask.repositories;

import androidx.lifecycle.MutableLiveData;

import com.example.madarsofttask.ui.AddUser;
import com.example.madarsofttask.models.User;

import java.util.List;

public class UserRepository {
private static UserRepository instance;
public static UserRepository getInstance(){
   if(instance==null){
       instance=new UserRepository();
   }
   return instance;
}
public MutableLiveData<List<User>> getUsers(){
    List<User> users= AddUser.myAppDatabase.myDAO().getUsers();
MutableLiveData<List<User>> usersData=new MutableLiveData<>();
usersData.setValue(users);
return usersData;
}

}
