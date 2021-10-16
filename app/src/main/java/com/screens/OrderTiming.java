package com.screens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class OrderTiming extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_timing);
        RecyclerView rvOrderTiming = findViewById(R.id.rv_order_timing);
        rvOrderTiming.setAdapter(new OrderTimingAdapter());
    }
}