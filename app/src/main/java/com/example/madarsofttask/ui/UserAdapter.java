package com.example.madarsofttask.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.madarsofttask.R;
import com.example.madarsofttask.models.User;

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
        holder.textViewTitle.setText(currentUser.getJobTitle());
        holder.textViewName.setText(currentUser.getName());
        holder.textViewAge.setText(String.valueOf(currentUser.getAge()));
        holder.textViewGender.setText(currentUser.getGender());
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
    }
}



//package com.example.madarsofttask;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//import androidx.recyclerview.widget.RecyclerView.ViewHolder;
//
//import com.example.madarsofttask.models.User;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class Adapter extends RecyclerView.Adapter<Adapter.Viewholder> {
//    private List<User> usersList=new ArrayList<>();
//
//    public Adapter(List<User> usersList) {
//        this.usersList = usersList;
//    }
//
//    @NonNull
//    @Override
//    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
//        return new Viewholder(view);
//
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
////String name=usersList.get(position).getName();
////double age=usersList.get(position).getAge();
////    String title =usersList.get(position).getJobTitle();
////    String gender=usersList.get(position).getGender();
////    System.out.println("HIIIII"+name);
////    holder.setData(name,age,title,gender);
//        User currentUser=usersList.get(position);
//        holder.nameTxt.setText(currentUser.getName());
//        holder.ageTxt.setText(String.valueOf(currentUser.getAge()));
//        holder.genderTxt.setText(currentUser.getGender());
//        holder.titleTxt.setText(currentUser.getJobTitle());
//    }
//
//    @Override
//    public int getItemCount() {
//        return usersList.size();
//    }
//    public void setUsersList(List<User> users){
//        this.usersList=users;
//        notifyDataSetChanged();
//    }
//    class Viewholder extends ViewHolder{
//        private TextView nameTxt;
//        private TextView ageTxt;
//        private TextView titleTxt;
//        private TextView genderTxt;
//        public Viewholder(@NonNull View itemView){
//            super(itemView);
//            nameTxt=itemView.findViewById(R.id.name_textView);
//            titleTxt=itemView.findViewById(R.id.title_textView);
//            ageTxt=itemView.findViewById(R.id.age_textView);
//            genderTxt=itemView.findViewById(R.id.gender_textView);
//        }
//        private void setData(String name,Double age,String title,String gender){
//            nameTxt.setText(name);
//            ageTxt.setText(age.toString());
//            titleTxt.setText(title);
//            genderTxt.setText(gender);
//        }
//    }
//}



//package com.example.madarsofttask;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//import androidx.recyclerview.widget.RecyclerView.ViewHolder;
//
//import com.example.madarsofttask.models.User;
//
//import java.util.List;
//
//public class Adapter extends RecyclerView.Adapter<Adapter.Viewholder> {
////    @Override
//    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
//return new Viewholder(view);
//
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
////String name=usersList.get(position).getName();
////double age=usersList.get(position).getAge();
////    String title =usersList.get(position).getJobTitle();
////    String gender=usersList.get(position).getGender();
////    System.out.println("HIIIII"+name);
////    holder.setData(name,age,title,gender);
//    User currentUser=usersList.get(position);
//    holder.nameTxt.setText(currentUser.getName());
//    holder.ageTxt.setText(String.valueOf(currentUser.getAge()));
//    holder.genderTxt.setText(currentUser.getGender());
//    holder.titleTxt.setText(currentUser.hashCode());
//    }
//
//    @Override
//    public int getItemCount() {
//        return usersList.size();
//    }
//public void setUsersList(List<User> users){
//        this.
//}
//    class Viewholder extends ViewHolder{
//    private TextView nameTxt;
//    private TextView ageTxt;
//    private TextView titleTxt;
//    private TextView genderTxt;
//    public Viewholder(@NonNull View itemView){
//        super(itemView);
//        nameTxt=itemView.findViewById(R.id.name_textView);
//        titleTxt=itemView.findViewById(R.id.title_textView);
//        ageTxt=itemView.findViewById(R.id.age_textView);
//        genderTxt=itemView.findViewById(R.id.gender_textView);
//    }
//    private void setData(String name,Double age,String title,String gender){
//        nameTxt.setText(name);
//        ageTxt.setText(age.toString());
//        titleTxt.setText(title);
//        genderTxt.setText(gender);
//    }
//}
//}
