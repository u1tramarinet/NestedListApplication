package com.example.nestedlistapplication.util;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nestedlistapplication.ui.BookAdapter;
import com.example.nestedlistapplication.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BindingAdapters {

    private BindingAdapters() {
    }

    @BindingAdapter({"setBooks"})
    public static void setBooks(RecyclerView recyclerView, List<Book> books) {
        Objects.requireNonNull(recyclerView);
        if (books == null) {
            books = new ArrayList<>();
        }
        BookAdapter adapter = new BookAdapter();
        adapter.submitList(books);
        recyclerView.setAdapter(adapter);
    }
}
