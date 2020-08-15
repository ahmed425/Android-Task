package com.example.madarsofttask.ui.add;

import androidx.lifecycle.ViewModel;

import com.example.madarsofttask.data.models.User;
import com.example.madarsofttask.data.repositories.UserRepository;

public class AddUserViewModel extends ViewModel {
    private UserRepository userRepo;

    public AddUserViewModel() {
        userRepo = UserRepository.getInstance();
    }

    void addUser(String name, String title, double age, String gender) {
        User user = new User();
        user.setName(name);
        user.setJobTitle(title);
        user.setAge(age);
        user.setGender(gender);
        userRepo.saveUser(user);
    }
}

