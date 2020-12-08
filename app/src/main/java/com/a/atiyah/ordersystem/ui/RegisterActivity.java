package com.a.atiyah.ordersystem.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.a.atiyah.ordersystem.R;
import com.a.atiyah.ordersystem.room.AppDatabase;
import com.a.atiyah.ordersystem.room.model.User;

public class RegisterActivity extends AppCompatActivity {

    EditText mETUserName, mETEmail, mETPass, mETConfirmPass;
    Button mBtnRegister;

    private AppDatabase mDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Initialize database
        mDB = AppDatabase.getInstance(getApplicationContext());

        initUI();

        mBtnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(mETUserName.getText().toString().trim())) {
                    Toast.makeText(RegisterActivity.this, "Username is required!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(mETEmail.getText().toString().trim())) {
                    Toast.makeText(RegisterActivity.this, "Email is required!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(mETPass.getText().toString().trim())) {
                    Toast.makeText(RegisterActivity.this, "password is required!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(mETConfirmPass.getText().toString().trim())) {
                    Toast.makeText(RegisterActivity.this, "Confirm password is required!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!mETPass.getText().toString().trim().equals(mETConfirmPass.getText().toString().trim())) {
                    Toast.makeText(RegisterActivity.this, "Confirm password is NOT right!", Toast.LENGTH_SHORT).show();
                    return;
                }

                insertToDB();
            }
        });
    }

    private void insertToDB() {
        String username = mETUserName.getText().toString().trim();
        String email = mETEmail.getText().toString().trim();
        String password = mETPass.getText().toString().trim();

        User user = new User(username, email, password);
        insert(user);
    }

    void insert(User user) {
        new Thread(() -> {
            mDB.userDao().registerUser(user);
            // Show a Toast on a ui thread
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(RegisterActivity.this, "User registered successfully!", Toast.LENGTH_SHORT).show();
                    // Login page
                    startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                }
            });
        }).start();
    }

    private void initUI() {
        mETUserName = findViewById(R.id.et_registration_activity_user_name);
        mETEmail = findViewById(R.id.et_registration_activity_user_email);
        mETPass = findViewById(R.id.et_registration_activity_user_password);
        mETConfirmPass = findViewById(R.id.et_registration_activity_confirm_user_password);
        mBtnRegister = findViewById(R.id.btn_registration);
    }
}