package com.example.madarsofttask.ui.list

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.madarsofttask.R
import com.example.madarsofttask.data.models.User
import kotlinx.android.synthetic.main.activity_read_user_data.*

@Suppress("UNCHECKED_CAST")
class ListUsersActivity : AppCompatActivity() {
    private var recyclerView: RecyclerView? = null
    private var listUsersViewModel: ListUsersViewModel? = null
    private var userAdapter: UserAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_read_user_data)
        initUI()
        initViewModel()
        users
    }

    private val users: Unit
        get() {
            listUsersViewModel!!.allUsers.observe(this, Observer { users: List<User?>? -> userAdapter!!.setUsers(users as List<User>) })
        }

    private fun initViewModel() {
        listUsersViewModel = ViewModelProvider(this).get(ListUsersViewModel::class.java)
    }

    private fun initUI() {
        recyclerView = recycler_view
        recyclerView?.layoutManager = LinearLayoutManager(this)
        recyclerView?.setHasFixedSize(true)
        userAdapter = UserAdapter()
        recyclerView?.adapter = userAdapter
    }
}