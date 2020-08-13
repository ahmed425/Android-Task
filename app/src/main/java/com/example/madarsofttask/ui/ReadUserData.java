package com.example.madarsofttask.ui;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.madarsofttask.UserAdapter;
import com.example.madarsofttask.R;
import com.example.madarsofttask.models.User;
import com.example.madarsofttask.viewmodels.UserViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class ReadUserData extends AppCompatActivity {
private RecyclerView recyclerView;
    private TextView txtInfo;
   private UserAdapter UserAdapter;
private UserViewModel myUserViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_user_data);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        final UserAdapter UserAdapter = new UserAdapter();
        recyclerView.setAdapter(UserAdapter);
        myUserViewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        myUserViewModel.getAllUsers().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(@Nullable List<User> users) {
                UserAdapter.setUsers(users);
            }
        });
    }


        //recyclerView=findViewById(R.id.recycler_view);
//
////List<User> myUsersList=new ArrayList<>();
////        txtInfo=findViewById(R.id.txt_display_user_info);
//
//        myUserViewModel= ViewModelProviders.of(this).get(UserViewModel.class);
//myUserViewModel.init();
//UserAdapter=new UserAdapter(myUserViewModel.getUsers().getValue());
//        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
//        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setAdapter(UserAdapter);
//        myUserViewModel.getUsers().observe(this, new Observer<List<User>>() {
//
//    @Override
//    public void onChanged(@Nullable List<User> users) {
////        initRecyclerView();
//
//        //        String info="";
//
////        for(User user:users){
////            double age=user.getAge();
////            String name=user.getName();
////            String title=user.getJobTitle();
////            String gender=user.getGender();
////info=info+"\n\n"+"  Name : "+name+"\n  Age :"+age+"\n"+"  Job Title :"+title+"\n"+"  Gender :"+gender;
////        }
////        txtInfo.setText(info);
//        System.out.println("HI"+users.toArray());
//
//        UserAdapter.notifyDataSetChanged();
//    }
//});
//        List<User> users=AddUser.myAppDatabase.myDAO().getUsers();
//
//        txtInfo.setText(info);


//    private void initRecyclerView(){

//    }
}
