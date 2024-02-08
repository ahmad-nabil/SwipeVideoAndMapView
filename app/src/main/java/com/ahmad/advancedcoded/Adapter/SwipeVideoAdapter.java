package com.ahmad.advancedcoded.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ahmad.advancedcoded.CustomClassData.SwipeVideoitems;
import com.ahmad.advancedcoded.databinding.SwipevideoBinding;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SwipeVideoAdapter extends RecyclerView.Adapter<SwipeVideoAdapter.SwipeVideoHolder> {
   private ArrayList<SwipeVideoitems>swipeVideoitems;
   Context context;
    private ExoPlayer currentPlayer;

    Map<Integer,Long> positionPlayPack=new HashMap<>();
    public SwipeVideoAdapter(ArrayList<SwipeVideoitems> swipeVideoitems, Context context) {
        this.swipeVideoitems = swipeVideoitems;
        this.context = context;
    }

    @NonNull
    @Override
    public SwipeVideoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        SwipevideoBinding swipevideoBinding=SwipevideoBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new SwipeVideoHolder(swipevideoBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull SwipeVideoHolder holder, int position) {
        // Check if the player in the ViewHolder is the same as the current player
holder.setVideoData(swipeVideoitems.get(position));
    }

    @Override
    public void onViewAttachedToWindow(@NonNull SwipeVideoHolder holder) {
        super.onViewAttachedToWindow(holder);
    if (holder.swipevideoBinding.VideoPlayer.getPlayer()!=null){
        holder.swipevideoBinding.VideoPlayer.getPlayer().play();
    }
    }

    @Override
    public void onViewDetachedFromWindow(@NonNull SwipeVideoHolder holder) {
        super.onViewDetachedFromWindow(holder);
        if (holder.swipevideoBinding.VideoPlayer.getPlayer()!=null){
            holder.swipevideoBinding.VideoPlayer.getPlayer().stop();
        }
    }

    @Override
    public int getItemCount() {
        return swipeVideoitems.size();
    }

    static class SwipeVideoHolder extends RecyclerView.ViewHolder{
SwipevideoBinding swipevideoBinding;
        ExoPlayer player;
     public SwipeVideoHolder(@NonNull SwipevideoBinding Binding){
         super(Binding.getRoot());
this.swipevideoBinding=Binding;
     }

        void setVideoData(SwipeVideoitems swipeVideoitems) {
          swipevideoBinding.TextVideoTitle.setText(swipeVideoitems.videoTitle);
            swipevideoBinding.TextVideoDescription.setText(swipeVideoitems.videoDescription);
          player=new ExoPlayer.Builder(itemView.getContext()).build();
            swipevideoBinding. VideoPlayer.setPlayer(player);
          MediaItem mediaItem=MediaItem.fromUri(swipeVideoitems.videoUrl);
          player.setMediaItem(mediaItem);
          player.prepare();

            swipevideoBinding.VideoProgressBar.setVisibility(View.GONE);
      }
 }
}
