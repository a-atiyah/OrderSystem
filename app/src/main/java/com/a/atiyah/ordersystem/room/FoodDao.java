package com.a.atiyah.ordersystem.room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.a.atiyah.ordersystem.room.model.Food;
import com.a.atiyah.ordersystem.room.model.User;

import java.util.List;

@Dao
public interface FoodDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertFood(Food food);

    @Query("DELETE FROM food")
    void deleteAll();

    @Query("SELECT * FROM food WHERE mCategory = :category")
    List<Food> retrieveFood(String category);
}
