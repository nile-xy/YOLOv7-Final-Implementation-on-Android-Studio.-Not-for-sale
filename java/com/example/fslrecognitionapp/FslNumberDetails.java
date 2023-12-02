package com.example.fslrecognitionapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class FslNumberDetails extends AppCompatActivity {

    private AppCompatButton btnBackVbNumber;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_fsl_numbers_details);

        // Get the selected word and image resource ID from the Intent extra
        String selectedNumber = getIntent().getStringExtra("selected_word");
        int selectedImageResource = getIntent().getIntExtra("selected_image_resource", 0);
        String selectedTagalogNumber = getIntent().getStringExtra("selected_tagalog_number");
        String selectedDefinition = getIntent().getStringExtra("selected_definition");

        btnBackVbNumber = findViewById(R.id.btnBackVbNumber);

        btnBackVbNumber.setOnClickListener((v)->{
            Intent intent = new Intent(FslNumberDetails.this, FslNumbers.class);
            startActivity(intent);

        });


        // Set the word to the TextView
        TextView numberTextView = findViewById(R.id.numberTextView);
        numberTextView.setText(selectedNumber);

        // Set the image to the ImageView
        ImageView numbersImageView = findViewById(R.id.numbersImageView);
        numbersImageView.setImageResource(selectedImageResource);

        TextView tagalogTextView = findViewById(R.id.numberTagalogView);
        tagalogTextView.setText(selectedTagalogNumber);

        TextView definitionNumber = findViewById(R.id.numbersTextDescriptionView);
        definitionNumber.setText(selectedDefinition);
    }
}
