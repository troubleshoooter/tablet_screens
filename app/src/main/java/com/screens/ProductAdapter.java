package com.screens;

import android.annotation.SuppressLint;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.screens.databinding.ListItemProductBinding;
import com.screens.models.OptionsItem;
import com.screens.models.ProductOptionItem;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    public List<ProductOptionItem> prods;

    public ProductAdapter(List<ProductOptionItem> prods) {
        this.prods = prods;
    }

    @NonNull
    @Override
    public ProductAdapter.ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ProductViewHolder(ListItemProductBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        holder.productBinding.ivDropdown.setOnClickListener(v -> {
            holder.productBinding.optionsContainer.setVisibility(holder.productBinding.optionsContainer.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
            holder.productBinding.tvOption.setVisibility(holder.productBinding.optionsContainer.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
            holder.productBinding.ilOption.setVisibility(holder.productBinding.optionsContainer.getVisibility() == View.VISIBLE ? View.VISIBLE : View.GONE);
            holder.productBinding.ivDropdown.setImageResource(holder.productBinding.optionsContainer.getVisibility() == View.VISIBLE ? R.drawable.ic_baseline_keyboard_arrow_up_24 : R.drawable.ic_baseline_keyboard_arrow_down_24);
        });
        holder.productBinding.etOption.setText(prods.get(position).getTitle());
        ProductOptionAdapter adapter = new ProductOptionAdapter(prods.get(position).getOptions());
        holder.productBinding.rvOptions.setAdapter(adapter);
        holder.productBinding.btnAddNewRow.setOnClickListener(v -> {
            prods.get(position).getOptions().add(new OptionsItem("0.00", ""));
            notifyDataSetChanged();
        });
        holder.productBinding.etOption.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                prods.get(holder.getAdapterPosition()).setTitle(s.toString());
                holder.productBinding.tvOption.setText(s.toString());
            }
        });
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
