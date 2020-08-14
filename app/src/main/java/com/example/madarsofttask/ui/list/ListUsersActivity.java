package com.example.madarsofttask.ui.list;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import com.example.madarsofttask.R;

public class ListUsersActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ListUsersViewModel listUsersViewModel;
    UserAdapter UserAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_user_data);
        initUI();
        initViewModel();
        getUsers();
    }

    private void getUsers() {
        listUsersViewModel.getAllUsers().observe(this, UserAdapter::setUsers);
    }

    private void initViewModel() {
        listUsersViewModel = new ViewModelProvider(this).get(ListUsersViewModel.class);
    }

    private void initUI() {
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        UserAdapter = new UserAdapter();
        recyclerView.setAdapter(UserAdapter);
    }
}
