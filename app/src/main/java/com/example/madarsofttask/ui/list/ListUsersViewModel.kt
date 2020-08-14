package com.example.madarsofttask.ui.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.madarsofttask.data.models.User
import com.example.madarsofttask.data.repositories.UserRepository.Companion.instance

class ListUsersViewModel : ViewModel() {
    val allUsers: MutableLiveData<List<User?>?>?

    init {
        val myUserRepo = instance
        allUsers = myUserRepo?.users
    }
}