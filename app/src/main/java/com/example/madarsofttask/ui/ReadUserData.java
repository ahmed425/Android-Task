package com.example.madarsofttask.ui;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import com.example.madarsofttask.R;
import com.example.madarsofttask.viewmodels.UserViewModel;

public class ReadUserData extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_user_data);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        final UserAdapter UserAdapter = new UserAdapter();
        recyclerView.setAdapter(UserAdapter);
       UserViewModel myUserViewModel = new UserViewModel(getApplication());
        myUserViewModel.getAllUsers().observe(this, UserAdapter::setUsers);
    }
}
