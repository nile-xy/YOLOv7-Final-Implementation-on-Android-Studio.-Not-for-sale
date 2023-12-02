package com.example.fslrecognitionapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import com.example.fslrecognitionapp.FSLPhrases_RecyclerViewAdapter;

public class FSLPhrases_RecyclerViewAdapter extends RecyclerView.Adapter<FSLPhrases_RecyclerViewAdapter.MyViewHolder> {
    private final RecyclerViewInterface recyclerViewInterface;
    Context context;
    ArrayList<FslPhrasesModel> fslPhrasesModelArrayList;

    public FSLPhrases_RecyclerViewAdapter(Context context, ArrayList<FslPhrasesModel> fslPhrasesModelArrayList, RecyclerViewInterface recyclerViewInterface){
        this.context = context;
        this.fslPhrasesModelArrayList = fslPhrasesModelArrayList;
        this.recyclerViewInterface = recyclerViewInterface;
    }


    @NonNull
    @Override
    public FSLPhrases_RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_row_phrase, parent, false);
        return new FSLPhrases_RecyclerViewAdapter.MyViewHolder(view, recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull FSLPhrases_RecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.txtFslPhrases.setText(fslPhrasesModelArrayList.get(position).getFslPhrase());
    }

    @Override
    public int getItemCount() {
        return fslPhrasesModelArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView txtFslPhrases;

        public MyViewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);
            txtFslPhrases = itemView.findViewById(R.id.txtFslPhrase);

            itemView.setOnClickListener((v)->{
                if(recyclerViewInterface != null){
                    int pos = getAdapterPosition();

                    if(pos != RecyclerView.NO_POSITION){
                        recyclerViewInterface.onItemClick(pos);
                    }
                }
            });

        }
    }
}
