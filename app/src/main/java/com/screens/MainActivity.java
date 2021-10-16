package com.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View generalSettings = findViewById(R.id.general_settings_container);
        View printerSettings = findViewById(R.id.printer_settings_container);
        View storeTiming = findViewById(R.id.store_timing_container);
        View orderTiming = findViewById(R.id.order_timing_container);
        View receiptSettings = findViewById(R.id.receipt_settings_container);
        generalSettings.setOnClickListener(v -> startActivity(new Intent(this, GeneralSettings.class)));
        printerSettings.setOnClickListener(v -> startActivity(new Intent(this, PrinterSettings.class)));
        storeTiming.setOnClickListener(v -> startActivity(new Intent(this, StoreTiming.class)));
        orderTiming.setOnClickListener(v -> startActivity(new Intent(this, OrderTiming.class)));
        receiptSettings.setOnClickListener(v -> startActivity(new Intent(this, ReceiptSettings.class)));
    }
}