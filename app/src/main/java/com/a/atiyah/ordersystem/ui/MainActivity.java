package com.a.atiyah.ordersystem.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.a.atiyah.ordersystem.R;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_CATEGORY_KEY = "category";
    CardView mCrdFastFood, mCrdSweets, mCrdSalads, mCrdDrinks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();

        mCrdFastFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FoodListActivity.class);
                intent.putExtra(EXTRA_CATEGORY_KEY, "fast_food");
                startActivity(intent);
            }
        });

        mCrdSweets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FoodListActivity.class);
                intent.putExtra(EXTRA_CATEGORY_KEY, "sweets");
                startActivity(intent);
            }
        });

        mCrdSalads.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FoodListActivity.class);
                intent.putExtra(EXTRA_CATEGORY_KEY, "salads");
                startActivity(intent);
            }
        });

        mCrdDrinks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FoodListActivity.class);
                intent.putExtra(EXTRA_CATEGORY_KEY, "drinks");
                startActivity(intent);
            }
        });
    }

    private void initUI() {
        mCrdFastFood = findViewById(R.id.crd_fast_food);
        mCrdSweets = findViewById(R.id.crd_sweets);
        mCrdSalads = findViewById(R.id.crd_salads);
        mCrdDrinks = findViewById(R.id.crd_drinks);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_logout: {
                logout();
            }
            break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void logout() {
        startActivity(new Intent(MainActivity.this, LoginActivity.class));
        finish();
    }
}