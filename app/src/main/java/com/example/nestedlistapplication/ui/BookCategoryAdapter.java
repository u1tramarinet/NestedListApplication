package com.example.nestedlistapplication.ui;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nestedlistapplication.databinding.ItemBookCategoryBinding;
import com.example.nestedlistapplication.model.BookCategory;

public class BookCategoryAdapter extends ShelfAdapter<BookCategory> {

    private final RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();

    public BookCategoryAdapter() {
        super();
    }

    @Override
    ViewDataBinding onCreateViewHolder(@NonNull ViewGroup parent, @NonNull LayoutInflater inflater) {
        return ItemBookCategoryBinding.inflate(inflater, parent, false);
    }

    @Override
    protected void onBindViewHolder(@NonNull BookCategory currentItem, @NonNull ViewDataBinding itemBinding) {
        ItemBookCategoryBinding bookCategoryBinding = (ItemBookCategoryBinding) itemBinding;
        bookCategoryBinding.setBookCategory(currentItem);
        bookCategoryBinding.nestedRecyclerView.setRecycledViewPool(viewPool);
        bookCategoryBinding.executePendingBindings();
    }
}
