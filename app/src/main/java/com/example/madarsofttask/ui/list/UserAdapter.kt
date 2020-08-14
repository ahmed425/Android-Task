package com.example.madarsofttask.ui.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.madarsofttask.R
import com.example.madarsofttask.data.models.User
import com.example.madarsofttask.ui.list.UserAdapter.UserHolder
import java.util.*
import kotlinx.android.synthetic.main.item_layout.view.*

class UserAdapter : RecyclerView.Adapter<UserHolder>() {
    private var users: List<User> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_layout, parent, false)
        return UserHolder(itemView)
    }

    override fun onBindViewHolder(holder: UserHolder, position: Int) {
        val currentUser = users[position]
        holder.bind(currentUser)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    fun setUsers(users: List<User>) {
        this.users = users
        notifyDataSetChanged()
    }

    class UserHolder(itemView: View) : ViewHolder(itemView) {
        fun bind(user: User) {
            itemView.title_textView.text = user.jobTitle
    itemView.name_textView.text = user.name
            itemView.age_textView.text = user.age.toString()
    itemView.gender_textView.text=user.gender
        }

    }
}