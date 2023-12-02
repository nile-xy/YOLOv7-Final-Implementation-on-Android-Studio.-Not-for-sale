package com.example.fslrecognitionapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FslNumbers_RecyclerViewAdapter extends RecyclerView.Adapter<FslNumbers_RecyclerViewAdapter.MyViewHolder>{

    private final RecyclerViewInterface recyclerViewInterface;
    Context context;
    ArrayList<FslNumberModel> fslNumberModelArrayList;

    public FslNumbers_RecyclerViewAdapter(Context context, ArrayList<FslNumberModel> fslNumberModelArrayList, RecyclerViewInterface recyclerViewInterface){
        this.context = context;
        this.fslNumberModelArrayList = fslNumberModelArrayList;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @NonNull
    @Override
    public FslNumbers_RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_row_number, parent, false);
        return new FslNumbers_RecyclerViewAdapter.MyViewHolder(view, recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull FslNumbers_RecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.txtFslNumber.setText(fslNumberModelArrayList.get(position).getFslNumber());
    }

    @Override
    public int getItemCount() {
        return fslNumberModelArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView txtFslNumber;

        public MyViewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);
            txtFslNumber = itemView.findViewById(R.id.txtFslNumbers);

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
