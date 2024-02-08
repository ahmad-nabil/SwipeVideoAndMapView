package com.ahmad.advancedcoded.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ahmad.advancedcoded.CustomClassData.menuitems;
import com.ahmad.advancedcoded.Map;
import com.ahmad.advancedcoded.MultiVideos;
import com.ahmad.advancedcoded.SwipeAbleVideo;
import com.ahmad.advancedcoded.databinding.MainmenupagerBinding;

import java.util.ArrayList;

public class MainMenuPagerAdapter extends RecyclerView.Adapter<MainMenuPagerAdapter.MainMenuHolder>{

  ArrayList<menuitems> menu_items;
  Context context;

    public MainMenuPagerAdapter(ArrayList<menuitems> menu_items, Context context) {
        this.menu_items = menu_items;
        this.context = context;
    }

    @NonNull
    @Override
    public MainMenuHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       MainmenupagerBinding binding= MainmenupagerBinding
               .inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new MainMenuHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MainMenuHolder holder, int position) {

       holder.Binding.titleBtn.setText(menu_items.get(position).namelayout);

holder.Binding.btnlayouts.setImageDrawable(menu_items.get(position).ImgsrcBtn);
holder.itemView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        handleClick(menu_items.get(position).namelayout);
    }
});

    holder.Binding.btnlayouts.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            handleClick(menu_items.get(position).namelayout);

        }
    });

        holder.Binding.titleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleClick(menu_items.get(position).namelayout);

            }
        });
    }
    private void handleClick(String Namelayout){

        if (Namelayout.equals("MultiVideos")){
         Intent MultiVideos=new Intent(context, MultiVideos.class);
         MultiVideos.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(MultiVideos);
        } else if (Namelayout.equals("swipe videos")) {
            Intent swipe=new Intent(context, SwipeAbleVideo.class);
            swipe.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(swipe);
        } else if (Namelayout.equals("Map")) {
            Intent MAP=new Intent(context, Map.class);
            MAP.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(MAP);
        }
    }


    @Override
    public int getItemCount() {
        return menu_items.size();
    }

    public class MainMenuHolder extends RecyclerView.ViewHolder{
    MainmenupagerBinding Binding;
        public MainMenuHolder(@NonNull MainmenupagerBinding binding) {
            super(binding.getRoot());
            this.Binding=binding;
        }
    }
}
