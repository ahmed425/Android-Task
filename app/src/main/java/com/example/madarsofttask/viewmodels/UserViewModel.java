package com.example.madarsofttask.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.madarsofttask.models.User;
import com.example.madarsofttask.repositories.UserRepository;

import java.util.List;

import static com.example.madarsofttask.ui.AddUser.myAppDatabase;


public class UserViewModel extends AndroidViewModel {
//    private UserRepository repository;
    private LiveData<List<User>> allUsers;

    private MutableLiveData<List<User>> mUsers;
    private UserRepository mUserRepo;
    public void init(){
//        if(mUsers!=null){
//            return;
//        }
        mUserRepo=UserRepository.getInstance();
        allUsers=mUserRepo.getUsers();
    }
    public UserViewModel(@NonNull Application application) {
        super(application);
        mUserRepo=UserRepository.getInstance();
        allUsers=mUserRepo.getUsers();
//        allUsers=mUserRepo.getUsers();

//        repository = new UserRepository(application);
//        allUsers = repository.getAllUsers();
    }

    public LiveData<List<User>> getAllUsers() {
        System.out.println("Users are : "+allUsers.toString());
        return allUsers;
    }

    public void addUser(String name,String title,double age,String gender){
    User user =new User();
    user.setName(name);
    user.setJobTitle(title);
    user.setAge(age);
    user.setGender(gender);
    myAppDatabase.myDAO().addUser(user);
}
}
//public class UserViewModel extends ViewModel {
//    private MutableLiveData<List<User>> mUsers;
//private UserRepository mUserRepo;
//    public void init(){
//        if(mUsers!=null){
//            return;
//        }
//        mUserRepo=UserRepository.getInstance();
//        mUsers=mUserRepo.getUsers();
//    }
//public void addUser(String name,String title,double age,String gender){
//    User user =new User();
//    user.setName(name);
//    user.setJobTitle(title);
//    user.setAge(age);
//    user.setGender(gender);
//    myAppDatabase.myDAO().addUser(user);
//}
//    public LiveData<List<User>> getUsers(){
//        return mUsers;
//    }
//}
