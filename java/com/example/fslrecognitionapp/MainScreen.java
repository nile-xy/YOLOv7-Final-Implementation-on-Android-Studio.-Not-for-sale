package com.example.fslrecognitionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.Set;

public class MainScreen extends AppCompatActivity {
    private ImageButton btnSettings;
    private Button btnCamera, btnVocabBank, btnAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main_screen);

        btnSettings = findViewById(R.id.btnSettings);
        btnCamera = findViewById(R.id.btnCamera);
        btnVocabBank = findViewById(R.id.btnVocabBank);
        btnAbout = findViewById(R.id.btnAbout);

        btnSettings.setOnClickListener((v)->{
            Intent intent = new Intent(MainScreen.this, Settings.class);
            startActivity(intent);

        });

        btnVocabBank.setOnClickListener((v)->{
            Intent intent = new Intent(MainScreen.this, VocabBank.class);
            startActivity(intent);
        });

        btnAbout.setOnClickListener((v)->{
            Intent intent = new Intent(MainScreen.this, About.class);
            startActivity(intent);
        });

        btnCamera.setOnClickListener((v)->{
            Intent intent = new Intent(MainScreen.this, CameraActivity.class);
            startActivity(intent);
        });


    }
}