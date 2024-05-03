package com.example.myyoutube_player;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Activity activity;
    private Context context;

    private ArrayList playlist;

    public CustomAdapter(Activity activity, Context context, ArrayList playlist){

        this.activity = activity;
        this.context = context;
        this.playlist = playlist;


    }
    @NonNull
    @Override
    public CustomAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_playllist, parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyViewHolder holder, int position) {
            holder.play_list.setText(String.valueOf(playlist.get(position)));
    }

    @Override
    public int getItemCount() {
        return playlist.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView play_list;
        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            play_list = itemView.findViewById(R.id.textView2);
        }
    }
}
