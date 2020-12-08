package com.a.atiyah.ordersystem.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.a.atiyah.ordersystem.R;
import com.a.atiyah.ordersystem.adapter.FoodAdapter;
import com.a.atiyah.ordersystem.room.AppDatabase;
import com.a.atiyah.ordersystem.room.model.Food;
import com.a.atiyah.ordersystem.room.model.User;

import java.util.List;

public class FoodListActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    FoodAdapter mAdapter;
    private List<Food> mFoodList;
    private String mCategory;

    private AppDatabase mDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);

        Intent intent = getIntent();

        if (intent != null) {
            if (intent.hasExtra(MainActivity.EXTRA_CATEGORY_KEY)) {
                mCategory = intent.getStringExtra(MainActivity.EXTRA_CATEGORY_KEY);
            }
        }

        mDB = AppDatabase.getInstance(getApplicationContext());

        initUI();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(layoutManager);

        retrieveData(mCategory);

    }

    private void retrieveData(String category) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                mFoodList = mDB.foodDao().retrieveFood(category);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (mFoodList != null) {
                            if (mFoodList.size() > 0){
                                Toast.makeText(FoodListActivity.this, "Loaded!", Toast.LENGTH_SHORT).show();

                                mAdapter = new FoodAdapter(FoodListActivity.this, mFoodList);
                                mAdapter.notifyDataSetChanged();
                                mRecyclerView.setAdapter(mAdapter);
                            }
                        } else {
                            Toast.makeText(FoodListActivity.this, "Nothing!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        }).start();
    }

    private void initUI() {
        mRecyclerView = findViewById(R.id.rv_food_list);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(mRecyclerView.getContext(),
                DividerItemDecoration.VERTICAL));
    }
}