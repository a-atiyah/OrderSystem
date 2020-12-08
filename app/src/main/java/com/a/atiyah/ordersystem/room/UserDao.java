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
}
