package com.example.testapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class GalleryPhotoAdapter extends RecyclerView.Adapter<GalleryPhotoAdapter.ViewHolder>{
    private Context context;
    private List<String> galleryImageList;

    public GalleryPhotoAdapter(Context context, List<String> galleryImageList) {
        this.context = context;
        this.galleryImageList = galleryImageList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater.from(context).inflate(R.layout.gallery_item, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final String image = galleryImageList.get(position);
        Glide.with(context).load(image).into(holder.galleryImage);
    }

    @Override
    public int getItemCount() {
        return galleryImageList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView galleryImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            galleryImage = itemView.findViewById(R.id.galleryImage);
        }
    }
}
