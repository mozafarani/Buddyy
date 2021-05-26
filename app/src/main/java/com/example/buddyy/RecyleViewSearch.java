package com.example.buddyy;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyleViewSearch extends RecyclerView.Adapter<RecyleViewSearch.ViewHolder> {


    private List<String> mData;
    private LayoutInflater mInflater;
    private List<Integer> pictures;
    private ItemClickListener mClickListener;

    // data is passed into the constructor
    RecyleViewSearch(Context context, List<String> data,List<Integer> pictures) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
        this.pictures = pictures;
    }

    // inflates the row layout from xml when needed
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recyclerview_row, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String name = mData.get(position);
        holder.myTextView.setText(name);
        holder.pic.setImageResource(pictures.get(position));
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mData.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView myTextView;
        CircleImageView pic;

        ViewHolder(View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.tvAnimalName);
            pic = itemView.findViewById(R.id.profile_image);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    String getItem(int id) {
        return mData.get(id);
    }

    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}