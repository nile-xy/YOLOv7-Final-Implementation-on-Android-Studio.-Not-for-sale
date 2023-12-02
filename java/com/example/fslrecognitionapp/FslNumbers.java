package com.example.fslrecognitionapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FslNumbers extends AppCompatActivity implements RecyclerViewInterface, SearchView.OnQueryTextListener{
    private AppCompatButton btnBackNumbers;
    RecyclerView recyclerView;
    ArrayList<FslNumberModel> fslNumberModelArrayList = new ArrayList<>();

    private FslNumbers_RecyclerViewAdapter adapter;
    private ArrayList<FslNumberModel> originalNumberList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_fsl_numbers);

        btnBackNumbers = findViewById(R.id.btnBackNumbers);
        recyclerView = findViewById(R.id.numberRecyclerView);

        setUpFslNumberModelArrayList();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        btnBackNumbers.setOnClickListener((v)->{
            Intent intent = new Intent(FslNumbers.this, VocabBank.class);
            startActivity(intent);
        });

        originalNumberList.addAll(fslNumberModelArrayList);
        adapter = new FslNumbers_RecyclerViewAdapter(this, fslNumberModelArrayList, this);
        recyclerView.setAdapter(adapter);
        SearchView searchView = findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(this);

    }

    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    public boolean onQueryTextChange(String newText) {
        // Filter the original list based on user input
        fslNumberModelArrayList.clear();
        for (FslNumberModel model : originalNumberList) {
            if (model.getFslNumber().toLowerCase().contains(newText.toLowerCase())) {
                fslNumberModelArrayList.add(model);
            }
        }
        adapter.notifyDataSetChanged();
        return true;
    }

    private void setUpFslNumberModelArrayList() {
        String[] fslNumber = getResources().getStringArray(R.array.fsl_number);
        String[] fslTagalogNumber = getResources().getStringArray(R.array.fsl_number_tagalog);
        String[] fsldefinition = getResources().getStringArray(R.array.fsl_number_description);
        int[] imageResources = {
                R.drawable.one, R.drawable.two, R.drawable.three, R.drawable.four, R.drawable.five,
                R.drawable.six, R.drawable.seven, R.drawable.eight, R.drawable.nine, R.drawable.ten,
                /* Add more image resource IDs for each word */
        };

        for (int i = 0; i < fslNumber.length; i++) {

            if(i < fslTagalogNumber.length && i < fsldefinition.length){
                fslNumberModelArrayList.add(new FslNumberModel(fslNumber[i], imageResources[i], fslTagalogNumber[i], fsldefinition[i]));
            }else{
                fslNumberModelArrayList.add(new FslNumberModel(fslNumber[i], imageResources[i], "", ""));
            }
        }
    }


    @Override
    public void onItemClick(int position) {
        FslNumberModel selectedNumberModel = fslNumberModelArrayList.get(position);
        Intent intent = new Intent(FslNumbers.this, FslNumberDetails.class);
        intent.putExtra("selected_word", selectedNumberModel.getFslNumber());
        intent.putExtra("selected_image_resource", selectedNumberModel.getImageResource());
        intent.putExtra("selected_tagalog_number", selectedNumberModel.getTagalogNumber());
        intent.putExtra("selected_definition", selectedNumberModel.getDefinitionNumber());
        startActivity(intent);
    }
}
