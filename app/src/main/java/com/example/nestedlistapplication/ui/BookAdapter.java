package com.example.nestedlistapplication.ui;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;

import com.example.nestedlistapplication.databinding.ItemBookBinding;
import com.example.nestedlistapplication.model.Book;

public class BookAdapter extends ShelfAdapter<Book> {

    public BookAdapter() {
        super();
    }

    @Override
    ViewDataBinding onCreateViewHolder(@NonNull ViewGroup parent, @NonNull LayoutInflater inflater) {
        return ItemBookBinding.inflate(inflater, parent, false);
    }

    @Override
    protected void onBindViewHolder(@NonNull Book currentItem, @NonNull ViewDataBinding itemBinding) {
        ItemBookBinding bookBinding = (ItemBookBinding)itemBinding;
        bookBinding.setBook(currentItem);
        bookBinding.executePendingBindings();
    }
}
