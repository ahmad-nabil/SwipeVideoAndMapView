package com.ahmad.advancedcoded.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ahmad.advancedcoded.CustomClassData.MultiVideoItems;
import com.ahmad.advancedcoded.databinding.MultiVideoRvBinding;
import com.bumptech.glide.Glide;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;

import java.util.ArrayList;

public class MultiVideoAdapter extends RecyclerView.Adapter<MultiVideoAdapter.MultivideoHolder> {
   ArrayList <MultiVideoItems> multiVideos;
   Context context;

    public MultiVideoAdapter(ArrayList<MultiVideoItems> multiVideos, Context context) {
        this.multiVideos = multiVideos;
        this.context = context;
    }

    @NonNull
    @Override
    public MultivideoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MultivideoHolder(MultiVideoRvBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MultivideoHolder holder, int position) {
        holder.setvideo(multiVideos.get(position));
holder.binding.thumbnails.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        holder.binding.thumbnails.setVisibility(View.GONE);
        holder.binding.videplayer.setVisibility(View.VISIBLE);
        holder.player.setPlayWhenReady(true);

    }
});
    }


    @Override
    public int getItemCount() {
        return multiVideos.size();
    }

    public class MultivideoHolder extends RecyclerView.ViewHolder{
        MultiVideoRvBinding binding;
        ExoPlayer player;

        MultivideoHolder(@NonNull MultiVideoRvBinding binding){
            super(binding.getRoot());
            this.binding=binding;

        }
       public void setvideo(MultiVideoItems multiVideoItems){
           Glide.with(context).load(multiVideoItems.UrlThumbnail).into(binding.thumbnails);
           binding.videplayer.setVisibility(View.INVISIBLE);
           binding.titlevideo.setText(multiVideoItems.name);
           MediaItem mediaItem=MediaItem.fromUri(multiVideoItems.UrlVideo);
           player=new ExoPlayer.Builder(binding.getRoot().getContext()).build();
           binding.videplayer.setPlayer(player);
           player.setMediaItem(mediaItem);
           player.prepare();

        }
    }
}
