package com.example.nestedlistapplication.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;

import com.example.nestedlistapplication.R;

public class Book implements Parcelable, Identifiable {
    public final String id;
    public final String title;
    public final @DrawableRes int imageRes;
    private static final @DrawableRes int DEFAULT_IMAGE_RES = R.drawable.bunbougu_art_sketchbook;

    public Book(@NonNull String id) {
        this(id, "Book Title " + id, DEFAULT_IMAGE_RES);
    }

    public Book(@NonNull String id, @NonNull String title, @DrawableRes int imageRes) {
        this.id = id;
        this.title = title;
        this.imageRes = imageRes;
    }

    protected Book(Parcel in) {
        id = in.readString();
        title = in.readString();
        imageRes = in.readInt();
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(title);
        parcel.writeInt(imageRes);
    }

    @Override
    public String getId() {
        return id;
    }
}
