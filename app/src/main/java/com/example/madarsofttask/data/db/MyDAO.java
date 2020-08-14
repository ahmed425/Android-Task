package com.example.madarsofttask.data.db;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import com.example.madarsofttask.data.models.User;
import java.util.List;

@Dao
public interface MyDAO {

    @Insert
    void addUser(User user);

    @Query("select * from users")
    List<User> retrieveUsers();

}
