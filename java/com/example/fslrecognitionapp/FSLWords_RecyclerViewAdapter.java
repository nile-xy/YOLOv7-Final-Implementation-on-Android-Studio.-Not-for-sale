package com.example.fslrecognitionapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FSLWords_RecyclerViewAdapter extends RecyclerView.Adapter<FSLWords_RecyclerViewAdapter.MyViewHolder> {
    private final RecyclerViewInterface recyclerViewInterface;
    Context context;
    ArrayList<FSLWordsModel> fslWordsModelArrayList;

    public FSLWords_RecyclerViewAdapter(Context context, ArrayList<FSLWordsModel> fslWordsModelArrayList, RecyclerViewInterface recyclerViewInterface){
        this.context = context;
        this.fslWordsModelArrayList = fslWordsModelArrayList;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @NonNull
    @Override
    public FSLWords_RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_row, parent, false);
        return new FSLWords_RecyclerViewAdapter.MyViewHolder(view, recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull FSLWords_RecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.txtFslWord.setText(fslWordsModelArrayList.get(position).getFslWord());
    }

    @Override
    public int getItemCount() {
        return fslWordsModelArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView txtFslWord;

        public MyViewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);
            txtFslWord = itemView.findViewById(R.id.txtFslWord);

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
