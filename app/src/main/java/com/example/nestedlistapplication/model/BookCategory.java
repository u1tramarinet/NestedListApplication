package com.example.nestedlistapplication.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.List;

public class BookCategory implements Parcelable, Identifiable {
    public final String id;
    public final String title;
    public final List<Book> books;

    public BookCategory(@NonNull String id, @NonNull List<Book> books) {
        this(id, "Category Title " + id, books);
    }

    public BookCategory(@NonNull String id, @NonNull String title, @NonNull List<Book> books) {
        this.id = id;
        this.title = title;
        this.books = books;
    }

    protected BookCategory(Parcel in) {
        id = in.readString();
        title = in.readString();
        books = in.createTypedArrayList(Book.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(title);
        dest.writeTypedList(books);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<BookCategory> CREATOR = new Creator<BookCategory>() {
        @Override
        public BookCategory createFromParcel(Parcel in) {
            return new BookCategory(in);
        }

        @Override
        public BookCategory[] newArray(int size) {
            return new BookCategory[size];
        }
    };

    @Override
    public String getId() {
        return id;
    }
}
