package com.example.fslrecognitionapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FslAlphabet_RecyclerViewAdapter extends RecyclerView.Adapter<FslAlphabet_RecyclerViewAdapter.MyViewHolder>{

    private final RecyclerViewInterface recyclerViewInterface;
    Context context;
    ArrayList<FslAlphabetModel> fslAlphabetModelArrayList;

    public FslAlphabet_RecyclerViewAdapter(Context context, ArrayList<FslAlphabetModel> fslAlphabetModelArrayList, RecyclerViewInterface recyclerViewInterface){
        this.context = context;
        this.fslAlphabetModelArrayList = fslAlphabetModelArrayList;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @NonNull
    @Override
    public FslAlphabet_RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_row_alphabet, parent, false);
        return new FslAlphabet_RecyclerViewAdapter.MyViewHolder(view, recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull FslAlphabet_RecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.txtFslAlphabet.setText(fslAlphabetModelArrayList.get(position).getFslAlphabet());
    }

    @Override
    public int getItemCount() {
        return fslAlphabetModelArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView txtFslAlphabet;

        public MyViewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);
            txtFslAlphabet = itemView.findViewById(R.id.txtFslAlphabet);

            itemView.setOnClickListener((v) -> {
                if (recyclerViewInterface != null) {
                    int pos = getAdapterPosition();

                    if (pos != RecyclerView.NO_POSITION) {
                        recyclerViewInterface.onItemClick(pos);
                    }
                }
            });
        }
    }
}
