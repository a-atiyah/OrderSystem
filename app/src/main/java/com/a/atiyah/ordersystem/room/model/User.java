package com.a.atiyah.ordersystem.room.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "users")
public class User {

    @PrimaryKey(autoGenerate = true)
    int mId;
    @ColumnInfo
    String mUsername;
    @ColumnInfo
    String mEmail;
    @ColumnInfo
    String mPassword;

    @Ignore
    public User(String mUsername, String mEmail, String mPassword) {
        this.mUsername = mUsername;
        this.mEmail = mEmail;
        this.mPassword = mPassword;
    }

    public User(int mId, String mUsername, String mEmail, String mPassword) {
        this.mId = mId;
        this.mUsername = mUsername;
        this.mEmail = mEmail;
        this.mPassword = mPassword;
    }

    public int getId() {
        return mId;
    }

    public String getUsername() {
        return mUsername;
    }

    public void setUsername(String username) {
        this.mUsername = username;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        this.mEmail = email;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        this.mPassword = password;
    }
}
