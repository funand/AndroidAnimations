package com.example.prince.animation;

import android.databinding.BindingAdapter;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.prince.animation.databinding.ImagesBinding;
import com.squareup.picasso.Picasso;

import java.util.List;

public class DataAdapter  extends RecyclerView.Adapter<DataAdapter.ViewHolder> implements View.OnClickListener {

    List<Photo> dataset;
    private View.OnClickListener listener;

    DataAdapter(List<Photo> dataset){
        this.dataset = dataset;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ImagesBinding binding = ImagesBinding.inflate(layoutInflater, parent, false);
        return new ViewHolder(binding);
    }

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView view, String imageUrl) {
        if(!imageUrl.equals("")){
            Picasso.get().load(imageUrl).into(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Photo item = dataset.get(position);
        holder.binding.setPictures(item);
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    @Override
    public void onClick(View v) {
        if(listener!=null){
            listener.onClick(v);
        }
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        private final ImagesBinding binding;

        public ViewHolder(@NonNull ImagesBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
