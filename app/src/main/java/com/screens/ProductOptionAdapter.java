package com.screens;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;

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
