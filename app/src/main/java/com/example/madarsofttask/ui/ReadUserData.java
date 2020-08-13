package com.example.madarsofttask.ui;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.widget.TextView;

import com.example.madarsofttask.R;
import com.example.madarsofttask.models.User;
import com.example.madarsofttask.viewmodels.UserViewModel;

import java.util.List;
import java.util.Observable;

public class ReadUserData extends AppCompatActivity {
private TextView txtInfo;
private UserViewModel myUserViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_user_data);

        txtInfo=findViewById(R.id.txt_display_user_info);

        myUserViewModel= ViewModelProviders.of(this).get(UserViewModel.class);
myUserViewModel.init();
        myUserViewModel.getUsers().observe(this, new Observer<List<User>>() {

    @Override
    public void onChanged(@Nullable List<User> users) {
        String info="";

        for(User user:users){
            double age=user.getAge();
            String name=user.getName();
            String title=user.getJobTitle();
            String gender=user.getGender();
info=info+"\n\n"+"  Name : "+name+"\n  Age :"+age+"\n"+"  Job Title :"+title+"\n"+"  Gender :"+gender;
        }
        txtInfo.setText(info);
    }
});
//        List<User> users=AddUser.myAppDatabase.myDAO().getUsers();
//
//        txtInfo.setText(info);

    }
}
