package com.example.fslrecognitionapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class Settings extends AppCompatActivity {
    private AppCompatButton btnSettingsBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_settings);

        btnSettingsBack = findViewById(R.id.btnSettingsBack);

        btnSettingsBack.setOnClickListener((v)->{
            Intent intent = new Intent(Settings.this, MainScreen.class);
            startActivity(intent);

        });
    }
}