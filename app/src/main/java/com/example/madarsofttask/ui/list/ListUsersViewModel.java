package com.example.madarsofttask.ui.list;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.madarsofttask.data.models.User;
import com.example.madarsofttask.data.repositories.UserRepository;

import java.util.List;


public class ListUsersViewModel extends ViewModel {

    private LiveData<List<User>> allUsers;

    public ListUsersViewModel(){
        UserRepository myUserRepo = UserRepository.getInstance();
        allUsers = myUserRepo.getUsers();
    }

    LiveData<List<User>> getAllUsers() {
        System.out.println("Users are : "+allUsers.toString());
        return allUsers;
    }
}
