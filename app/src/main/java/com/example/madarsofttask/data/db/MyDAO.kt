package com.example.madarsofttask.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.madarsofttask.data.models.User

@Dao
interface MyDAO {
    @Insert
    fun addUser(user: User?)

    @Query("select * from users")
    fun retrieveUsers(): LiveData<List<User?>?>
}