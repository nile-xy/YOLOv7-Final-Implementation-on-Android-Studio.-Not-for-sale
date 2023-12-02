package com.example.fslrecognitionapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class FslPhraseDetails extends AppCompatActivity {

    private AppCompatButton btnBackVbPhrase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_fsl_phrases_details);

        // Get the selected word and image resource ID from the Intent extra
        String selectedPhrase = getIntent().getStringExtra("selected_phrase");
        int selectedVideoResource = getIntent().getIntExtra("selected_video_resource", 0);
        String selectedTagalogPhrase = getIntent().getStringExtra("selected_tagalog_phrase");
        String selectedCategory = getIntent().getStringExtra("selected_category");

        btnBackVbPhrase = findViewById(R.id.btnBackVbPhrase);

        btnBackVbPhrase.setOnClickListener((v)->{
            Intent intent = new Intent(FslPhraseDetails.this, FslPhrases.class);
            startActivity(intent);

        });

        String videoPath = "android.resource://" + getPackageName() + "/" + selectedVideoResource;

        // Set the word to the TextView
        TextView phraseTextView = findViewById(R.id.phraseTextView);
        phraseTextView.setText(selectedPhrase);

        TextView tagalogTextView = findViewById(R.id.phraseTextTagalogView);
        tagalogTextView.setText(selectedTagalogPhrase);

        TextView categoryTextView = findViewById(R.id.phraseTextCategoryView);
        categoryTextView.setText(selectedCategory);

        // Set the image to the ImageView
        VideoView phraseVideoView = findViewById(R.id.phraseVideoView);
        phraseVideoView.setVideoURI(Uri.parse(videoPath));
        phraseVideoView.start();


        // Play/pause toggle
        phraseVideoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (phraseVideoView.isPlaying()) {
                    phraseVideoView.pause();
                } else {
                    phraseVideoView.start();
                }
            }
        });

    }
}

