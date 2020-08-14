package com.example.madarsofttask.ui.list;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.example.madarsofttask.R;
import java.util.Objects;

public class ListUsersActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ListUsersViewModel listUsersViewModel;
    UserAdapter userAdapter;
    TextView noUsersFound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_users);
        initUI();
        initViewModel();
        getUsers();
    }

    private void getUsers() {
        listUsersViewModel.getAllUsers().observe(this, users -> {
            if (users != null && users.size() > 0) {
                userAdapter.setUsers(users);
            } else {

                // show no users layout
                noUsersFound.setVisibility(View.VISIBLE);
            }
        });
    }

    private void initViewModel() {
        listUsersViewModel = new ViewModelProvider(this).get(ListUsersViewModel.class);
    }

    private void initUI() {
        Objects.requireNonNull(getSupportActionBar()).setTitle(getString(R.string.saved_users_list));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        noUsersFound = findViewById(R.id.no_users_textView);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        userAdapter = new UserAdapter();
        recyclerView.setAdapter(userAdapter);
    }
}
