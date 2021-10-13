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

        View printerSettings = findViewById(R.id.printer_settings_container);
        printerSettings.setOnClickListener(v -> startActivity(new Intent(this, PrinterSettings.class)));
    }
}