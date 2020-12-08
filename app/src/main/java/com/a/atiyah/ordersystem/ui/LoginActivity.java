package com.a.atiyah.ordersystem.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.a.atiyah.ordersystem.R;
import com.a.atiyah.ordersystem.room.AppDatabase;
import com.a.atiyah.ordersystem.room.model.User;

public class LoginActivity extends AppCompatActivity {

    EditText mETUserName, mETPassword;
    TextView mTVRegister;
    Button mBtnLogin;

    private AppDatabase mDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize database
        mDB = AppDatabase.getInstance(getApplicationContext());
        initUI();

        mTVRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TextUtils.isEmpty(mETUserName.getText().toString().trim())) {
                    Toast.makeText(LoginActivity.this, "Username is required!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(mETPassword.getText().toString().trim())) {
                    Toast.makeText(LoginActivity.this, "password is required!", Toast.LENGTH_SHORT).show();
                    return;
                }

                login();
            }
        });
    }

    private void login() {

        String username = mETUserName.getText().toString().trim();
        String password = mETPassword.getText().toString().trim();

        if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password))
            retrieveData(username, password);
    }

    private void retrieveData(String username, String password) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                final User user = mDB.userDao().login(username, password);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (user != null) {
                            Toast.makeText(LoginActivity.this, "User Login successfully!", Toast.LENGTH_SHORT).show();
                            // Login page
                            startActivity(new Intent(LoginActivity.this, MainActivity.class));
                            finish();
                        } else {
                            Toast.makeText(LoginActivity.this, "Check username and password!", Toast.LENGTH_SHORT).show();
                            setFields();
                        }
                    }
                });
            }
        }).start();
    }

    private void setFields() {
        mETPassword.setText("");
        mETUserName.setText("");
    }

    private void initUI() {
        mETUserName = findViewById(R.id.et_login_activity_username);
        mETPassword = findViewById(R.id.et_login_activity_password);
        mTVRegister = findViewById(R.id.tv_registration);
        mBtnLogin = findViewById(R.id.btn_login);
    }
}