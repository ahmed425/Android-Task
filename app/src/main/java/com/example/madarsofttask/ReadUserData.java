package com.example.madarsofttask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class ReadUserData extends AppCompatActivity {
private TextView txtInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_user_data);
    txtInfo=findViewById(R.id.txt_display_user_info);
        List<User> users=AddUser.myAppDatabase.myDAO().getUsers();
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
}
