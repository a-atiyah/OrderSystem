package com.a.atiyah.ordersystem.ui;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.a.atiyah.ordersystem.R;

public class SplashScreenActivity extends AppCompatActivity {

    ActionBar mActionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        mActionBar = getSupportActionBar();
        mActionBar.setElevation(0);
        Thread background = new Thread() {
            public void run() {
                try {
                    sleep(2000);

                    Intent i=new Intent(getBaseContext(),MainActivity.class);
                    startActivity(i);

                    finish();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        // start thread
        background.start();
    }
}