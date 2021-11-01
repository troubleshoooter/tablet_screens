package com.screens;

import android.annotation.SuppressLint;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.screens.databinding.ListItemProductBinding;
import com.screens.databinding.ListItemProductOptionBinding;
import com.screens.models.OptionsItem;
import com.screens.models.ProductOptionItem;

import java.util.List;

public class ProductOptionAdapter extends RecyclerView.Adapter<ProductOptionAdapter.OptionViewHolder> {

    List<OptionsItem> options;

    public ProductOptionAdapter(List<OptionsItem> options) {
        this.options = options;
    }

    @NonNull
    @Override
    public OptionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new OptionViewHolder(ListItemProductOptionBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onBindViewHolder(@NonNull OptionViewHolder holder, int position) {
        holder.optionBinding.etPrice.setText(options.get(position).getPrice());
        holder.optionBinding.etTitle.setText(options.get(position).getLabel());
        holder.optionBinding.ivClose.setOnClickListener(v -> {
            options.remove(position);
            notifyDataSetChanged();
        });
        holder.optionBinding.etTitle.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                options.get(position).setLabel(holder.optionBinding.etTitle.getText().toString());
            }
        });
        holder.optionBinding.etPrice.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                options.get(position).setPrice(holder.optionBinding.etPrice.getText().toString());
            }
        });
    }


    @Override
    public int getItemCount() {
        return options.size();
    }

    public static class OptionViewHolder extends RecyclerView.ViewHolder {
        public ListItemProductOptionBinding optionBinding;

        public OptionViewHolder(@NonNull ListItemProductOptionBinding itemView) {
            super(itemView.getRoot());
            optionBinding = itemView;
        }

    }
}
