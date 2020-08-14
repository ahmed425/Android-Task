package com.example.madarsofttask.data.repositories

import androidx.lifecycle.MutableLiveData
import com.example.madarsofttask.application.BaseApplication
import com.example.madarsofttask.data.models.User

class UserRepository {
    val users: MutableLiveData<List<User?>?>
        get() {
            val users = BaseApplication.userDatabase?.myDAO()?.retrieveUsers()
            val usersData = MutableLiveData<List<User?>?>()
            usersData.value = users
            return usersData
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