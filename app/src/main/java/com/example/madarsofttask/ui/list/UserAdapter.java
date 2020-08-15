package com.example.madarsofttask.ui.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.madarsofttask.R;
import com.example.madarsofttask.data.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserHolder> {
    private List<User> users = new ArrayList<>();

    @NonNull
    @Override
    public UserHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout, parent, false);
        return new UserHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull UserHolder holder, int position) {
        User currentUser = users.get(position);
        holder.bind(currentUser);
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    void setUsers(List<User> users) {
        this.users = users;
        notifyDataSetChanged();
    }

    static class UserHolder extends RecyclerView.ViewHolder {
        private TextView textViewTitle;
        private TextView textViewName;
        private TextView textViewAge;
        private TextView textViewGender;

        UserHolder(View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.title_textView);
            textViewName = itemView.findViewById(R.id.name_textView);
            textViewAge = itemView.findViewById(R.id.age_textView);
            textViewGender = itemView.findViewById(R.id.gender_textView);
        }

        void bind(User user) {
            textViewTitle.setText(user.getJobTitle());
            textViewName.setText(user.getName());
            textViewAge.setText(String.valueOf(user.getAge()));
            textViewGender.setText(user.getGender());
        }
    }
}