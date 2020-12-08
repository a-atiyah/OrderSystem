package com.a.atiyah.ordersystem.room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.a.atiyah.ordersystem.room.model.User;

@Dao
public interface UserDao {
    @Insert (onConflict = OnConflictStrategy.IGNORE)
    void registerUser(User user);
    @Query("DELETE FROM users")
    void deleteAll();

    @Query("SELECT * FROM users WHERE mUsername = :username and mPassword= :password")
    User login(String username, String password);
}
