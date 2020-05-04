package com.example.nestedlistapplication.util;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public class BindingViewHolder extends RecyclerView.ViewHolder {
    public final ViewDataBinding binding;

    public BindingViewHolder(@NonNull ViewDataBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
}
