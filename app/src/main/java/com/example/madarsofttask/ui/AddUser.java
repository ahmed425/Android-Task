package com.example.madarsofttask.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.madarsofttask.R;
import com.example.madarsofttask.data.UserDatabase;
import com.example.madarsofttask.viewmodels.UserViewModel;

public class AddUser extends AppCompatActivity {
private EditText userName,userAge,userTitle,userGender;
    public static UserDatabase myAppDatabase;
    private UserViewModel myUserViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
        userName=findViewById(R.id.name_editText);
        userAge=findViewById(R.id.age_editText);
        userTitle=findViewById(R.id.title_editText);
        userGender=findViewById(R.id.gender_editText);
        Button btnSave = findViewById(R.id.save_btn);
        Button btnDisplay = findViewById(R.id.display_button);
        myAppDatabase= Room.databaseBuilder(getApplicationContext(), UserDatabase.class,"userDB").allowMainThreadQueries().build();
        myUserViewModel= ViewModelProviders.of(this).get(UserViewModel.class);
        myUserViewModel.init();
        btnSave.setOnClickListener(view -> {
            double age=Double.parseDouble(userAge.getText().toString());
            String name=userName.getText().toString();
            String title=userTitle.getText().toString();
            String gender=userGender.getText().toString();
            myUserViewModel.addUser(name,title,age,gender);
            Toast.makeText(AddUser.this, "User Added Successfully", Toast.LENGTH_SHORT).show();
userAge.setText("");
userName.setText("");
userGender.setText("");
userTitle.setText("");
        });
        btnDisplay.setOnClickListener(view -> startActivity(new Intent(AddUser.this,ReadUserData.class)));
    }
}
