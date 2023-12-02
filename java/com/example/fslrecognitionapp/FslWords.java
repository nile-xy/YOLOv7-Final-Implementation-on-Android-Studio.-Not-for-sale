package com.example.fslrecognitionapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import java.util.ArrayList;

public class FslWords extends AppCompatActivity  implements RecyclerViewInterface, SearchView.OnQueryTextListener{
    private AppCompatButton btnBackWords;
    RecyclerView recyclerView;
    ArrayList<FSLWordsModel> fslWordsModelArrayList = new ArrayList<>();

    private FSLWords_RecyclerViewAdapter adapter;
    private ArrayList<FSLWordsModel> originalWordsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_fsl_words);

        btnBackWords = findViewById(R.id.btnBackWords);
        recyclerView = findViewById(R.id.wordsRecyclerView);

        setUpFslWordsModelArrayList();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



        btnBackWords.setOnClickListener((v)->{
            Intent intent = new Intent(FslWords.this, VocabBank.class);
            startActivity(intent);
        });

        originalWordsList.addAll(fslWordsModelArrayList);
        adapter = new FSLWords_RecyclerViewAdapter(this, fslWordsModelArrayList, this);
        recyclerView.setAdapter(adapter);
        SearchView searchView = findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(this);

    }

    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    public boolean onQueryTextChange(String newText) {
        // Filter the original list based on user input
        fslWordsModelArrayList.clear();
        for (FSLWordsModel model : originalWordsList) {
            if (model.getFslWord().toLowerCase().startsWith(newText.toLowerCase())) {
                fslWordsModelArrayList.add(model);
            }
        }
        adapter.notifyDataSetChanged();
        return true;
    }

    private void setUpFslWordsModelArrayList() {
        String[] fslWords = getResources().getStringArray(R.array.fsl_words);
        String[] fslTagalog = getResources().getStringArray(R.array.fsl_word_tagalog);
        String[] fslDescription = getResources().getStringArray(R.array.fsl_word_descriptions);
        String[] fslExample = getResources().getStringArray(R.array.fsl_word_example);
        int[] videoResources = {
                R.raw.afraid_video, R.raw.april_video, R.raw.august_video, R.raw.allow_video, R.raw.tita_video, R.raw.ampon_video,
                R.raw.architect_video, R.raw.angry_video,
                R.raw.big_video, R.raw.boastful_video, R.raw.black_video, R.raw.blue_video, R.raw.brown_video,
                R.raw.bad_video, R.raw.beautiful_video, R.raw.bitter_video, R.raw.bring_video,
                R.raw.buy_video, R.raw.bored_video, R.raw.bath_video, R.raw.bring_video, R.raw.sanggol_video,
                R.raw.complain_video, R.raw.cheap_video, R.raw.clean_video, R.raw.correct_video,
                R.raw.cold_video, R.raw.confused_video, R.raw.condolence_video, R.raw.congrats_video,
                R.raw.chef_video, R.raw.children_video, R.raw.pinsan_video,
                R.raw.dumb_video, R.raw.december_video, R.raw.dark_video, R.raw.delicious_video, R.raw.different_video, R.raw.difficult_video,
                R.raw.dirty_video, R.raw.dry_video, R.raw.deaf_clap_video,
                R.raw.daughter_video, R.raw.dancer_video, R.raw.doctor_video,
                R.raw.emotions_video, R.raw.enjoy_video, R.raw.easy_video, R.raw.expensive_video, R.raw.embarassed_video,
                R.raw.excited_video, R.raw.kinupkop_video,
                R.raw.frustrated_video, R.raw.friday_video, R.raw.february_video, R.raw.false_video, R.raw.far_video, R.raw.fast_video, R.raw.few_video, R.raw.full_video,
                R.raw.foolish_video, R.raw.papa_video, R.raw.family_video,
                R.raw.green_video, R.raw.gold_video, R.raw.gray_video, R.raw.good_video, R.raw.glad_video, R.raw.paalam_video,
                R.raw.good_luck_video, R.raw.lola_video, R.raw.lolo_video, R.raw.apo_video, R.raw.ninang_video,
                R.raw.ninong,
                R.raw.hate_video, R.raw.hurt_video, R.raw.hard_video, R.raw.humble_video, R.raw.handsome_video, R.raw.heavy_video, R.raw.high_video,
                R.raw.honest_video, R.raw.hot_video, R.raw.hungry_video,
                R.raw.happy_video, R.raw.husband_video, R.raw.important_video,
                R.raw.january_video, R.raw.july_video, R.raw.june_video, R.raw.jealous_video,
                R.raw.bata_video,
                R.raw.liar_video, R.raw.light_video, R.raw.low_video, R.raw.love_video, R.raw.let_video,
                R.raw.monday_video, R.raw.march_video, R.raw.may_video, R.raw.month_video, R.raw.many_video,
                R.raw.mama_video, R.raw.kasal_video,
                R.raw.november_video, R.raw.near_video, R.raw.new_video, R.raw.noisy_video,
                R.raw.nervous_video, R.raw.nephew_video, R.raw.niece_video,
                R.raw.orange_video, R.raw.october_video, R.raw.old_video, R.raw.ate_video, R.raw.kuya_video, R.raw.opo_video,
                R.raw.pink_video, R.raw.purple_video, R.raw.proud_video, R.raw.permit_video, R.raw.buntis_video, R.raw.magulang_video,
                R.raw.photographer_video, R.raw.professor_video,
                R.raw.quiet_video,
                R.raw.rainbow_video, R.raw.red_video,
                R.raw.scared_video, R.raw.small_video, R.raw.smart_video, R.raw.soft_video, R.raw.silver_video, R.raw.saturday_video,
                R.raw.sunday_video, R.raw.september_video, R.raw.salty_video,
                R.raw.same_video, R.raw.slow_video, R.raw.sour_video, R.raw.spicy_video,
                R.raw.strong_video, R.raw.sweet_video, R.raw.sad_video, R.raw.shy_video, R.raw.sick_video,
                R.raw.sleepy_video, R.raw.surprised_video, R.raw.student_video, R.raw.son_video,
                R.raw.stepbrother_video, R.raw.stepsister_video,
                R.raw.tan_video, R.raw.thursday_video, R.raw.tuesday_video, R.raw.true_video, R.raw.tired_video,
                R.raw.teacher_video, R.raw.teenager_video, R.raw.tito_video,
                R.raw.ugly_video,
                R.raw.white_video, R.raw.wednesday_video, R.raw.weak_video, R.raw.wet_video, R.raw.wrong_video,
                R.raw.worry_video, R.raw.wife_video, R.raw.work_video,
                R.raw.yellow_video, R.raw.year_video, R.raw.oo_video, R.raw.young_video,

                // Add more video resource IDs for each word
        };


        for (int i = 0; i < fslWords.length; i++) {
            // Check if the current index is within the bounds of the other arrays
            if (i < fslTagalog.length && i < fslDescription.length && i < fslExample.length) {
                fslWordsModelArrayList.add(new FSLWordsModel(fslWords[i], videoResources[i], fslTagalog[i], fslDescription[i], fslExample[i]));
            } else {
                // Handle cases where there may not be a corresponding Tagalog translation or description
                fslWordsModelArrayList.add(new FSLWordsModel(fslWords[i], videoResources[i], "", "", ""));
            }
        }
    }



    @Override
    public void onItemClick(int position) {
        FSLWordsModel selectedWordModel = fslWordsModelArrayList.get(position);
        Intent intent = new Intent(FslWords.this, FslWordsDetails.class);
        intent.putExtra("selected_word", selectedWordModel.getFslWord());
        intent.putExtra("selected_video_resource", selectedWordModel.getVideoResource()); // Pass the video resource ID
        intent.putExtra("selected_tagalog", selectedWordModel.getTagalogWord());
        intent.putExtra("selected_description", selectedWordModel.getDescription());
        intent.putExtra("selected_example", selectedWordModel.getExample());
        startActivity(intent);
    }
}