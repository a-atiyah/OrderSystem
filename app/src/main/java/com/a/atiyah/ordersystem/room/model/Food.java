package com.a.atiyah.ordersystem.room.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity (tableName = "food")
public class Food {
    @PrimaryKey (autoGenerate = true)
    int mId;
    @ColumnInfo
    String mTitle;
    @ColumnInfo
    String mCategory;
    @ColumnInfo
    String mDescription;
    @ColumnInfo
    String mImgName;
    @ColumnInfo
    String mPrise;

    @Ignore
    public Food(String mTitle, String mCategory, String mDescription, String mImgName, String mPrise) {
        this.mTitle = mTitle;
        this.mCategory = mCategory;
        this.mDescription = mDescription;
        this.mImgName = mImgName;
        this.mPrise = mPrise;
    }

    public Food(int mId, String mCategory, String mTitle, String mDescription, String mImgName, String mPrise) {
        this.mId = mId;
        this.mTitle = mTitle;
        this.mCategory = mCategory;
        this.mDescription = mDescription;
        this.mImgName = mImgName;
        this.mPrise = mPrise;
    }

    public int getId() {
        return mId;
    }

    public void setId(int mId) {
        this.mId = mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getCategory(){
        return mCategory;
    }

    public void setCategory(String category){
        this.mCategory = category;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public String getImgName() {
        return mImgName;
    }

    public void setImgName(String mImgName) {
        this.mImgName = mImgName;
    }

    public String getPrise() {
        return mPrise;
    }

    public void setPrise(String mPrise) {
        this.mPrise = mPrise;
    }
}
