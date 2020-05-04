package com.example.nestedlistapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.nestedlistapplication.model.Book;
import com.example.nestedlistapplication.model.BookCategory;
import com.example.nestedlistapplication.ui.BookCategoryAdapter;

import java.util.ArrayList;

/**
 * https://proandroiddev.com/nested-recyclerview-and-databinding-a4943d05dbda
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BookCategoryAdapter adapter = new BookCategoryAdapter();
        adapter.submitList(getData());
        RecyclerView recyclerView = findViewById(R.id.outerRecyclerView);
        recyclerView.setAdapter(adapter);
    }

    private ArrayList<BookCategory> getData() {
        ArrayList<BookCategory> bookCategories = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            ArrayList<Book> books = new ArrayList<>();
            for (int j = 1; j <= 5; j++) {
                int id = i * 10 + j;
                Book book = new Book(String.valueOf(id));
                books.add(book);
            }
            BookCategory bookCategory = new BookCategory(String.valueOf(i), books);
            bookCategories.add(bookCategory);
        }
        return bookCategories;
    }
}
