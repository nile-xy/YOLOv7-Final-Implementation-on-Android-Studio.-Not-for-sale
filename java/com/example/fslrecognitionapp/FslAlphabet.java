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

public class FslAlphabet extends AppCompatActivity implements RecyclerViewInterface, SearchView.OnQueryTextListener {

    private AppCompatButton btnBackAlphabet;
    RecyclerView recyclerView;
    ArrayList<FslAlphabetModel> fslAlphabetModelArrayList = new ArrayList<>();

    private FslAlphabet_RecyclerViewAdapter adapter;
    private ArrayList<FslAlphabetModel> originalAlphabetList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_fsl_alphabets);

        btnBackAlphabet = findViewById(R.id.btnBackAlphabets);
        recyclerView = findViewById(R.id.alphabetRecyclerView);

        setUpFslAlphabetModelArrayList();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        btnBackAlphabet.setOnClickListener((v)->{
            Intent intent = new Intent(FslAlphabet.this, VocabBank.class);
            startActivity(intent);
        });

        originalAlphabetList.addAll(fslAlphabetModelArrayList);
        adapter = new FslAlphabet_RecyclerViewAdapter(this, fslAlphabetModelArrayList, this);
        recyclerView.setAdapter(adapter);
        SearchView searchView = findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(this);

    }

    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    public boolean onQueryTextChange(String newText) {
        // Filter the original list based on user input
        fslAlphabetModelArrayList.clear();
        for (FslAlphabetModel model : originalAlphabetList) {
            if (model.getFslAlphabet().toLowerCase().startsWith(newText.toLowerCase())) {
                fslAlphabetModelArrayList.add(model);
            }
        }
        adapter.notifyDataSetChanged();
        return true;
    }


    private void setUpFslAlphabetModelArrayList() {
        String[] fslAlphabet = getResources().getStringArray(R.array.fsl_alphabet);
        int[] imageResources = {
                R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e,
                R.drawable.f, R.drawable.g, R.drawable.h, R.drawable.i, R.drawable.j,
                R.drawable.k, R.drawable.l, R.drawable.m, R.drawable.n, R.drawable.o,
                R.drawable.p, R.drawable.q, R.drawable.r, R.drawable.s, R.drawable.t,
                R.drawable.u, R.drawable.v, R.drawable.w, R.drawable.x, R.drawable.y,
                R.drawable.z,
                /* Add more image resource IDs for each word */
        };

        for (int i = 0; i < fslAlphabet.length; i++) {
            fslAlphabetModelArrayList.add(new FslAlphabetModel(fslAlphabet[i], imageResources[i]));
        }
    }

    @Override
    public void onItemClick(int position) {
        FslAlphabetModel selectedAlphabetModel = fslAlphabetModelArrayList.get(position);
        Intent intent = new Intent(FslAlphabet.this, FslAlphabetDetails.class);
        intent.putExtra("selected_word", selectedAlphabetModel.getFslAlphabet());
        intent.putExtra("selected_image_resource", selectedAlphabetModel.getImageResource());
        startActivity(intent);
    }
}
