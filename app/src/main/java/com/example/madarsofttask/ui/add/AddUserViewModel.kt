package com.example.madarsofttask.ui.add

import androidx.lifecycle.ViewModel
import com.example.madarsofttask.data.models.User
import com.example.madarsofttask.data.repositories.UserRepository
import com.example.madarsofttask.data.repositories.UserRepository.Companion.instance

class AddUserViewModel : ViewModel() {
    private val userRepo: UserRepository? = instance
    fun addUser(name: String?, title: String?, age: Double, gender: String?) {
        val user = User()
        user.name = name
        user.jobTitle = title
        user.age = age
        user.gender = gender
        userRepo!!.saveUser(user)
    }

}