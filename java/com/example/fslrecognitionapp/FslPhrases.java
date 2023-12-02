package com.example.fslrecognitionapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import java.util.ArrayList;

public class FslPhrases extends AppCompatActivity  implements RecyclerViewInterface, SearchView.OnQueryTextListener{
    private AppCompatButton btnBackSentences;
    RecyclerView recyclerView;
    ArrayList<FslPhrasesModel> fslPhrasesModelArrayList = new ArrayList<>();

    private FSLPhrases_RecyclerViewAdapter adapter;
    private ArrayList<FslPhrasesModel> originalPhraseList = new ArrayList<>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_fsl_sentences);

        btnBackSentences = findViewById(R.id.btnBackSentences);
        recyclerView = findViewById(R.id.phraseRecyclerView);

        setUpFslPhrasesModelArrayList();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        btnBackSentences.setOnClickListener((v)->{
            Intent intent = new Intent(FslPhrases.this, VocabBank.class);
            startActivity(intent);
        });

        originalPhraseList.addAll(fslPhrasesModelArrayList);
        adapter = new FSLPhrases_RecyclerViewAdapter(this, fslPhrasesModelArrayList, this);
        recyclerView.setAdapter(adapter);
        SearchView searchView = findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(this);

    }

    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    public boolean onQueryTextChange(String newText) {
        // Filter the original list based on user input
        fslPhrasesModelArrayList.clear();
        for (FslPhrasesModel model : originalPhraseList) {
            if (model.getFslPhrase().toLowerCase().startsWith(newText.toLowerCase())) {
                fslPhrasesModelArrayList.add(model);
            }
        }
        adapter.notifyDataSetChanged();
        return true;
    }

    private void setUpFslPhrasesModelArrayList() {
        String[] fslPhrases = getResources().getStringArray(R.array.fsl_phrases);
        String[] fslPhraseTagalog = getResources().getStringArray(R.array.fsl_phrase_tagalog);
        String[] fslCategory = getResources().getStringArray(R.array.fsl_phrase_category);
        int[] videoResources = {
                R.raw.are_you_student_video, R.raw.again_please_video, R.raw.absolutely_i_will_teach_you_video,
                R.raw.come_to_eat_together_video, R.raw.come_learn_fsl_video, R.raw.come_lets_eat_video,
                R.raw.class_please_listen_video, R.raw.could_you_please_teach_me_video, R.raw.calm_down_video,
                R.raw.did_you_answer_your_assignment_video,  R.raw.do_we_have_a_class_video, R.raw.do_we_have_an_exam_today_video,
                R.raw.excuse_me_video, R.raw.magandang_gabi_video, R.raw.magandang_hapon_video, R.raw.magandang_umaga_video,
                R.raw.good_job_video, R.raw.hold_on_im_just_tired_video, R.raw.happy_birthday_video, R.raw.happy_fathers_day_video,
                R.raw.happy_mothers_day_video, R.raw.happy_teacher_s_day_video, R.raw.he_she_is_my_classmate_video,
                R.raw.he_she_is_my_schoolmate_video, R.raw.he_she_is_my_sweetheart_video, R.raw.how_old_are_you_video,
                R.raw.nakagawa_ka_na_ba_ng_assignment_video, R.raw.i_know_he_she_is_my_friend_video, R.raw.may_exam_ba_ngayon_video,
                R.raw.may_klase_ba_video, R.raw.i_don_t_understand_video, R.raw.i_apologize_i_am_still_learning_sign_language_video,
                R.raw.i_don_t_know_video, R.raw.i_forgot_video, R.raw.i_knew_your_face_video, R.raw.i_know_video,
                R.raw.i_remind_video, R.raw.i_understand_video, R.raw.i_want_to_practice_my_sign_languge_video,
                R.raw.i_like_you_video, R.raw.i_miss_you_video, R.raw.just_a_little_video, R.raw.keep_working_video,
                R.raw.may_i_go_to_comfort_room_video, R.raw.no_i_am_not_student_video, R.raw.no_teacher_video,
                R.raw.never_give_up_video, R.raw.oh_i_m_just_tired_video, R.raw.please_come_here_video,
                R.raw.please_sign_slow_i_don_t_understand_video, R.raw.such_a_beautiful_day_video,
                R.raw.see_you_again_video, R.raw.see_you_later, R.raw.see_you_soon_video, R.raw.that_s_very_good_video,
                R.raw.take_care_video, R.raw.try_again_video, R.raw.very_good_video, R.raw.what_are_you_studying_video,
                R.raw.what_work_do_you_do_video, R.raw.where_do_you_live_video, R.raw.which_univ_are_you_at_video,
                R.raw.anong_oras_ang_klase_video, R.raw.what_s_wrong_video, R.raw.what_time_is_it_video,
                R.raw.what_time_will_our_clas_starts_video, R.raw.when_is_your_birthday_video,
                R.raw.when_is_your_breaktime_video, R.raw.where_do_you_study_video, R.raw.who_is_your_teacher_video,
                R.raw.why_are_you_shy_video, R.raw.wait_a_minute_video, R.raw.were_the_same_video, R.raw.what_s_up_video,
                R.raw.yes_i_am_student_video, R.raw.yes_teacher_video, R.raw.mahalaga_ka_video,

                // Add more image resource IDs for each phrase
        };


        for (int i = 0; i < fslPhrases.length; i++) {
            // Check if the current index is within the bounds of the other arrays
            if (i < fslPhraseTagalog.length && i < fslCategory.length) {
                fslPhrasesModelArrayList.add(new FslPhrasesModel(fslPhrases[i], videoResources[i], fslPhraseTagalog[i], fslCategory[i]));
            } else {
                // Handle cases where there may not be a corresponding Tagalog translation or description
                fslPhrasesModelArrayList.add(new FslPhrasesModel(fslPhrases[i], videoResources[i], "", ""));
            }
        }
    }

    @Override
    public void onItemClick(int position) {
        FslPhrasesModel selectedPhraseModel = fslPhrasesModelArrayList.get(position);
        Intent intent = new Intent(FslPhrases.this, FslPhraseDetails.class);
        intent.putExtra("selected_phrase", selectedPhraseModel.getFslPhrase());
        intent.putExtra("selected_video_resource", selectedPhraseModel.getVideoResource());
        intent.putExtra("selected_tagalog_phrase", selectedPhraseModel.getFslTagalogPhrase());
        intent.putExtra("selected_category", selectedPhraseModel.getCategory());
        startActivity(intent);
    }
}