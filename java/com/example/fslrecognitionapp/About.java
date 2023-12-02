package com.example.fslrecognitionapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class About extends AppCompatActivity {

    private AppCompatButton btnBackAbout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_about_app);

        btnBackAbout = findViewById(R.id.btnBackAbout);

        btnBackAbout.setOnClickListener((v)->{
            Intent intent = new Intent(About.this, MainScreen.class);
            startActivity(intent);
        });

        TextView aboutText = findViewById(R.id.aboutText);

        StringBuilder aboutTextBuilder = new StringBuilder();
        aboutTextBuilder.append("Welcome to the application for recognizing Filipino sign language! By offering a potent tool for precisely identifying and interpreting specific Filipino Sign Language (FSL) motions, our mission is to close the communication gap between the hearing community and the deaf population.\n\n");
        aboutTextBuilder.append("Our application makes use of cutting-edge technology and deep learning algorithms to enable real-time sign language detection. It was created with users and accessibility in mind. The program effectively facilitates communication between the deaf and hearing by translating FSL motions into written or spoken language using the device's built-in camera.\n\n");
        aboutTextBuilder.append("Key features:\n\n");
        aboutTextBuilder.append("1. Accurate Sign Language Recognition: To achieve a high degree of accuracy in identifying diverse signs and gestures, our software has been trained on a sizable dataset of FSL gestures. It can accurately interpret both individual signs and entire phrases.\n\n");
        aboutTextBuilder.append("2. Real-time Translation: The software offers real-time translation of FSL motions into written text or spoken language, facilitating communication in sign language for hearing people.\n\n");
        aboutTextBuilder.append("3. User-Friendly Interface: Our program is made to be user-friendly for both hearing and deaf users, and it has a straightforward, intuitive interface. All users are guaranteed a flawless experience thanks to the clear layout and simple controls.\n\n");
        aboutTextBuilder.append("4. Comprehensive Vocabulary Bank: The program comes with a comprehensive Vocabulary bank of FSL signs that are frequently used. Users can more easily and rapidly search for particular signs and gestures with this tool, which improves their comprehension and communication skills.\n\n");
        aboutTextBuilder.append("5. Options for Customization: Users are free to make changes to the program to suit their tastes. They are freely to select what text size and font color of their choice.\n\n");
        aboutTextBuilder.append("6. Offline Mode: The software is offline mode that enables users to use the fundamental features even when there is no internet connection. This guarantees accessibility in a variety of situations, including isolated locales or regions with poor connectivity.\n\n");
        aboutTextBuilder.append("Our application seeks to make communication inclusive, efficient, and available to everyone, whether you're a part of the deaf community or someone interested in knowing Filipino Sign Language. Through our Filipino Sign Language Recognition app, we are dedicated to fostering inclusivity and understanding since we think that technology has the ability to dissolve barriers.\n\n");
        aboutTextBuilder.append("Thank you for helping us in empowering communication between the deaf and hearing populations by downloading the application. Let's create a society where sign language is accepted and understood by all!");

        aboutText.setText(aboutTextBuilder.toString());
    }
}
