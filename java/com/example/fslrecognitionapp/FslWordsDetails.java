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

import org.w3c.dom.Text;

public class FslWordsDetails extends AppCompatActivity {

    private AppCompatButton btnBackVbWords;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_fsl_words_details);

        // Get the selected word and video resource ID from the Intent extras
        String selectedWord = getIntent().getStringExtra("selected_word");
        int selectedVideoResource = getIntent().getIntExtra("selected_video_resource", 0); // 0 is the default value
        String selectedTagalog = getIntent().getStringExtra("selected_tagalog");
        String selectedDescription = getIntent().getStringExtra("selected_description");
        String selectedExample = getIntent().getStringExtra("selected_example");

        btnBackVbWords = findViewById(R.id.btnBackVbWords);


        btnBackVbWords.setOnClickListener((v)->{
            Intent intent = new Intent(FslWordsDetails.this, FslWords.class);
            startActivity(intent);

        });

        // Construct the video resource path using the resource ID
        String videoPath = "android.resource://" + getPackageName() + "/" + selectedVideoResource;

        // Set the word to the TextView
        TextView wordTextView = findViewById(R.id.wordTextView);
        wordTextView.setText(selectedWord);

        TextView tagalogTextView = findViewById(R.id.wordTextTagalogView);
        tagalogTextView.setText(selectedTagalog);

        TextView descriptionTextView = findViewById(R.id.wordTextDescriptionView);
        descriptionTextView.setText(selectedDescription);

        TextView exampleTextView = findViewById(R.id.wordTextExampleView);
        exampleTextView.setText(selectedExample);

        // Set the video to the VideoView
        VideoView wordVideoView = findViewById(R.id.wordVideoView);
        wordVideoView.setVideoURI(Uri.parse(videoPath));
        wordVideoView.start();


        tagalogTextView.setText(formatTagalogText(selectedTagalog));


// Play/pause toggle
        wordVideoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (wordVideoView.isPlaying()) {
                    wordVideoView.pause();
                } else {
                    wordVideoView.start();
                }
            }
        });
    }
    private SpannableString formatTagalogText(String tagalogText) {
        SpannableString spannableString = new SpannableString(tagalogText);

        // Define the font size for the part within brackets
        int start = tagalogText.indexOf('[');
        int end = tagalogText.indexOf(']') + 1;
        int fontSize = 35;

        spannableString.setSpan(new AbsoluteSizeSpan(fontSize), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        return spannableString;
    }
}

