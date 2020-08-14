package com.example.madarsofttask.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
class User {
    @PrimaryKey(autoGenerate = true)
    var id = 0
    var name: String? = null
    var age = 0.0
    var jobTitle: String? = null
    var gender: String? = null

}