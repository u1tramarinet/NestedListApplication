package com.example.nestedlistapplication;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.example.nestedlistapplication.databinding.ItemBookBinding;
import com.example.nestedlistapplication.model.Book;
import com.example.nestedlistapplication.util.BindingViewHolder;

import java.util.Objects;

public class BookAdapter extends ListAdapter<Book, BindingViewHolder> {

    public BookAdapter() {
        this(new DiffUtil.ItemCallback<Book>() {
            @Override
            public boolean areItemsTheSame(@NonNull Book oldItem, @NonNull Book newItem) {
                return oldItem == newItem;
            }

            @Override
            public boolean areContentsTheSame(@NonNull Book oldItem, @NonNull Book newItem) {
                return Objects.equals(oldItem.id, newItem.id);
            }
        });
    }

    protected BookAdapter(@NonNull DiffUtil.ItemCallback<Book> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public BindingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemBookBinding binding = ItemBookBinding.inflate(inflater, parent, false);
        return new BindingViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BindingViewHolder holder, int position) {
        Book currentBook = getItem(position);
        ItemBookBinding itemBinding = (ItemBookBinding) holder.binding;
        itemBinding.setBook(currentBook);
        itemBinding.executePendingBindings();
    }
}
