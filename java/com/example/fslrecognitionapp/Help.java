package com.example.fslrecognitionapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Help extends AppCompatActivity {
    private ImageButton btnBackHelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_help);


        btnBackHelp = findViewById(R.id.btnBackHelp);

        btnBackHelp.setOnClickListener((v)->{
            Intent intent = new Intent(Help.this, CameraActivity.class);
            startActivity(intent);
        });



        TextView helpText = findViewById(R.id.helpText);

        StringBuilder aboutTextBuilder = new StringBuilder();
        aboutTextBuilder.append("1. Camera Setup: Position your device in such a way that the camera is facing the deaf individual whose gestures you want to translate. Make sure there is adequate lighting for better recognition accuracy.\n\n");
        aboutTextBuilder.append("2. Gesture Detection: Aim the camera towards the deaf individual, ensuring their gestures are within the camera's frame. The application will automatically detect and analyze the gestures being made.\n\n");
        aboutTextBuilder.append("3. Translation Display: Once the application detects a gesture, it will display the translated text on the screen. If the deaf individual is signing in Filipino Sign Language, the translation will be in English (or vice versa, based on your language preference).\n\n");
        aboutTextBuilder.append("4. Text-to-Speech: If you prefer to hear the translation instead of reading it, tap the text-to-speech icon on the screen. The application will convert the translated text into audible speech using the device's speakers or connected headphones.\n\n");

        helpText.setText(aboutTextBuilder.toString());



    }
}
