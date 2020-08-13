package com.example.madarsofttask.viewmodels;
import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.example.madarsofttask.models.User;
import com.example.madarsofttask.repositories.UserRepository;
import java.util.List;
import static com.example.madarsofttask.ui.AddUser.myAppDatabase;


public class UserViewModel extends AndroidViewModel {
    private LiveData<List<User>> allUsers;
    private UserRepository myUserRepo;
    public void init(){
        myUserRepo=UserRepository.getInstance();
        allUsers=myUserRepo.getUsers();
    }
    public UserViewModel(@NonNull Application application) {
        super(application);
        myUserRepo=UserRepository.getInstance();
        allUsers=myUserRepo.getUsers();
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

