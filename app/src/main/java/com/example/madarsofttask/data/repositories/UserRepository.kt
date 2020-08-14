package com.example.madarsofttask.data.repositories

import androidx.lifecycle.LiveData
import com.example.madarsofttask.application.BaseApplication
import com.example.madarsofttask.data.models.User

class UserRepository {
    val users: LiveData<List<User?>?>?
        get() {
            return BaseApplication.userDatabase?.myDAO()?.retrieveUsers()
        }

    fun saveUser(user: User?) {
        BaseApplication.userDatabase?.myDAO()?.addUser(user)
    }

    companion object {
        @JvmStatic
        var instance: UserRepository? = null
            get() {
                if (field == null) {
                    field = UserRepository()
                }
                return field
            }
            private set
    }
}