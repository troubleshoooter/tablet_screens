package com.screens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;

import com.google.android.material.button.MaterialButton;
import com.screens.databinding.ActivityProductOptionBinding;
import com.screens.models.OptionsItem;
import com.screens.models.ProductOptionItem;

import java.util.ArrayList;
import java.util.List;

public class ProductOptionActivity extends AppCompatActivity {

    ActivityProductOptionBinding binding;

    private List<ProductOptionItem> productOptions = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProductOptionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        for (int i = 0; i < 2; i++) {
            List<OptionsItem> optionsItems = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                optionsItems.add(new OptionsItem(j + ".00", "Title " + j));
            }
            productOptions.add(new ProductOptionItem(i, optionsItems, "type", "Choose Option", "true"));
        }
        binding.rvProduct.setAdapter(new ProductAdapter(productOptions));
    }
}