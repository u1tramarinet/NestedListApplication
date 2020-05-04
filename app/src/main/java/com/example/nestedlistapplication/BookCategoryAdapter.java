package com.example.nestedlistapplication;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nestedlistapplication.databinding.ItemBookCategoryBinding;
import com.example.nestedlistapplication.model.BookCategory;
import com.example.nestedlistapplication.util.BindingViewHolder;

import java.util.Objects;

public class BookCategoryAdapter extends ListAdapter<BookCategory, BindingViewHolder> {

    private final RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();

    public BookCategoryAdapter() {
        this(new DiffUtil.ItemCallback<BookCategory>() {
            @Override
            public boolean areItemsTheSame(@NonNull BookCategory oldItem, @NonNull BookCategory newItem) {
                return oldItem == newItem;
            }

            @Override
            public boolean areContentsTheSame(@NonNull BookCategory oldItem, @NonNull BookCategory newItem) {
                return Objects.equals(oldItem.id, newItem.id);
            }
        });
    }

    protected BookCategoryAdapter(@NonNull DiffUtil.ItemCallback<BookCategory> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public BindingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemBookCategoryBinding binding = ItemBookCategoryBinding.inflate(inflater, parent, false);
        return new BindingViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BindingViewHolder holder, int position) {
        BookCategory currentBookCategory = getItem(position);
        ItemBookCategoryBinding itemBinding = (ItemBookCategoryBinding) holder.binding;
        itemBinding.setBookCategory(currentBookCategory);
        itemBinding.nestedRecyclerView.setRecycledViewPool(viewPool);
        itemBinding.executePendingBindings();
    }
}
