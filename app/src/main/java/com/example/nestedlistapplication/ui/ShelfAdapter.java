package com.example.nestedlistapplication.ui;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.example.nestedlistapplication.model.Identifiable;
import com.example.nestedlistapplication.util.BindingViewHolder;

import java.util.Objects;

public abstract class ShelfAdapter<T extends Identifiable> extends ListAdapter<T, BindingViewHolder> {

    public ShelfAdapter() {
        this(new DiffUtil.ItemCallback<T>() {
            @Override
            public boolean areItemsTheSame(@NonNull T oldItem, @NonNull T newItem) {
                return oldItem == newItem;
            }

            @Override
            public boolean areContentsTheSame(@NonNull T oldItem, @NonNull T newItem) {
                return Objects.equals(oldItem.getId(), newItem.getId());
            }
        });
    }

    protected ShelfAdapter(@NonNull DiffUtil.ItemCallback<T> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public BindingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = onCreateViewHolder(parent, inflater);
        return new BindingViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BindingViewHolder holder, int position) {
        T currentItem = getItem(position);
        ViewDataBinding itemBinding = holder.binding;
        onBindViewHolder(currentItem, itemBinding);
    }

    abstract ViewDataBinding onCreateViewHolder(@NonNull ViewGroup parent, @NonNull LayoutInflater inflater);

    abstract void onBindViewHolder(@NonNull T currentItem, @NonNull ViewDataBinding itemBinding);
}
