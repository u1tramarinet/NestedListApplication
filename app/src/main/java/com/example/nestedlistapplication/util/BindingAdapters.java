package com.example.nestedlistapplication.util;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nestedlistapplication.BookAdapter;
import com.example.nestedlistapplication.model.Book;

import java.util.List;

public class BindingAdapters {

    @BindingAdapter({"setBooks"})
    public static void setBooks(RecyclerView recyclerView, List<Book> books) {
        if (books == null) {
            return;
        }
        BookAdapter adapter = new BookAdapter();
        adapter.submitList(books);
        recyclerView.setAdapter(adapter);
    }
}
