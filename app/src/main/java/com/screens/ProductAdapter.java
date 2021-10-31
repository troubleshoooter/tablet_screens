package com.screens;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.screens.databinding.ListItemProductBinding;
import com.screens.models.ProductOptionItem;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    List<ProductOptionItem> prods;

    public ProductAdapter(List<ProductOptionItem> prods) {
        this.prods = prods;
    }

    @NonNull
    @Override
    public ProductAdapter.ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ProductViewHolder(ListItemProductBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        holder.productBinding.ivDropdown.setOnClickListener(v -> {
            holder.productBinding.optionsContainer.setVisibility(holder.productBinding.optionsContainer.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
            holder.productBinding.ivDropdown.setImageResource(holder.productBinding.optionsContainer.getVisibility() == View.VISIBLE ? R.drawable.ic_baseline_keyboard_arrow_down_24 : R.drawable.ic_baseline_keyboard_arrow_up_24);
        });
        holder.productBinding.etOption.setText(prods.get(position).getTitle());
        ProductOptionAdapter adapter = new ProductOptionAdapter(prods.get(position).getOptions());
        holder.productBinding.rvOptions.setAdapter(adapter);
    }


    @Override
    public int getItemCount() {
        return prods.size();
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder {
        public ListItemProductBinding productBinding;

        public ProductViewHolder(@NonNull ListItemProductBinding itemView) {
            super(itemView.getRoot());
            productBinding = itemView;
        }
    }
}
