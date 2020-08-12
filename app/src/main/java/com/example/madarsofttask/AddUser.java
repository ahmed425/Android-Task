package com.example.madarsofttask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddUser extends AppCompatActivity {
private EditText userName,userAge,userTitle,userGender;
private Button btnSave;
private Button btnDisplay;
    public static MyAppDatabase myAppDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
        userName=findViewById(R.id.name_editText);
        userAge=findViewById(R.id.age_editText);
        userTitle=findViewById(R.id.title_editText);
        userGender=findViewById(R.id.gender_editText);
        btnSave=findViewById(R.id.save_btn);
        btnDisplay=findViewById(R.id.display_button);
        myAppDatabase= Room.databaseBuilder(getApplicationContext(),MyAppDatabase.class,"userDB").allowMainThreadQueries().build();

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double age=Double.parseDouble(userAge.getText().toString());
                String name=userName.getText().toString();
                String title=userTitle.getText().toString();
                String gender=userGender.getText().toString();
           User user =new User();
           user.setName(name);
           user.setJobTitle(title);
           user.setAge(age);
           user.setGender(gender);
           myAppDatabase.myDAO().addUser(user);
           Toast.makeText(AddUser.this, "User Added Successfully", Toast.LENGTH_SHORT).show();
userAge.setText("");
userName.setText("");
userGender.setText("");
userTitle.setText("");
            }
        });
        btnDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AddUser.this,ReadUserData.class));
            }
        });
    }
}
