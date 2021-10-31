package com.screens;

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

    @Override
    public void onBindViewHolder(@NonNull OptionViewHolder holder, int position) {
        holder.bind(options.get(position));
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

        public void bind(OptionsItem optionsItem) {
            optionBinding.etPrice.setText(optionsItem.getPrice());
            optionBinding.etTitle.setText(optionsItem.getLabel());
        }
    }
}
