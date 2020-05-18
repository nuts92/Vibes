package com.example.android.vibes.data_models;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/**
 * This class is a Data Model Class that stores the Music Category Data including the category title, the category description,
 * the category image, the category songs List in addition to the title that will be displayed in the action bar.
 */
public class Category implements Parcelable {

    private String actionBarTitle;

    private String categoryTitle;

    private String categoryDescription;

    private int categoryImage;

    private ArrayList<Song> songsList;

    public Category(String actionBarTitle, String categoryTitle, String categoryDescription, int categoryImage, ArrayList<Song> songsList) {
        this.actionBarTitle = actionBarTitle;
        this.categoryTitle = categoryTitle;
        this.categoryDescription = categoryDescription;
        this.categoryImage = categoryImage;
        this.songsList = songsList;
    }

    protected Category(Parcel in) {
        actionBarTitle = in.readString();
        categoryTitle = in.readString();
        categoryDescription = in.readString();
        categoryImage = in.readInt();
        songsList = in.createTypedArrayList(Song.CREATOR);
    }

    public static final Creator<Category> CREATOR = new Creator<Category>() {
        @Override
        public Category createFromParcel(Parcel in) {
            return new Category(in);
        }

        @Override
        public Category[] newArray(int size) {
            return new Category[size];
        }
    };

    public String getActionBarTitle() {
        return actionBarTitle;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public int getCategoryImage() {
        return categoryImage;
    }

    public ArrayList<Song> getSongsList() {
        return songsList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(actionBarTitle);
        dest.writeString(categoryTitle);
        dest.writeString(categoryDescription);
        dest.writeInt(categoryImage);
        dest.writeTypedList(songsList);
    }
}