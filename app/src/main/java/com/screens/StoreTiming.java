package com.screens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class StoreTiming extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_timing);
        RecyclerView rvOrderTiming = findViewById(R.id.rv_order_timing);
        StoreTimingAdapter adapter = new StoreTimingAdapter();
        rvOrderTiming.setAdapter(adapter);
    }
}