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
        getUsers()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun getUsers() {
        listUsersViewModel?.allUsers?.observe(this, Observer { users: List<User?>? -> userAdapter?.setUsers(users as List<User>) })
    }

    private fun initViewModel() {
        listUsersViewModel = ViewModelProvider(this).get(ListUsersViewModel::class.java)
    }

    private fun initUI() {
        val actionbar = supportActionBar
        //set actionbar title
        actionbar?.title = getString(R.string.saved_users_list)
        //set back button
        actionbar?.setDisplayHomeAsUpEnabled(true)
        actionbar?.setDisplayHomeAsUpEnabled(true)
        recyclerView = recycler_view
        recyclerView?.layoutManager = LinearLayoutManager(this)
        recyclerView?.setHasFixedSize(true)
        userAdapter = UserAdapter()
        recyclerView?.adapter = userAdapter
    }
}