package com.ahmad.advancedcoded.helper;

import androidx.appcompat.content.res.AppCompatResources;

import com.ahmad.advancedcoded.Adapter.MainMenuPagerAdapter;
import com.ahmad.advancedcoded.CustomClassData.menuitems;
import com.ahmad.advancedcoded.R;
import com.ahmad.advancedcoded.databinding.ActivityMainMenuBinding;
import com.codeboy.pager2_transformers.Pager2_RotateUpTransformer;

import java.util.ArrayList;

public class menuBtnhelper {
    ActivityMainMenuBinding binding;

    public menuBtnhelper(ActivityMainMenuBinding binding) {
        this.binding = binding;
    }
    public void initializeViewPager(){
        ArrayList<menuitems> items=new ArrayList<>();
        itemsmenu(items);
        MainMenuPagerAdapter menuPagerAdapter=new MainMenuPagerAdapter(items,binding.getRoot().getContext().getApplicationContext());
        binding.btnpager.setAdapter(menuPagerAdapter);
binding.btnpager.setPageTransformer(new Pager2_RotateUpTransformer());
    }

    private void itemsmenu(ArrayList<menuitems> items) {
        menuitems multivideo=new menuitems();
        multivideo.namelayout="MultiVideos";
        multivideo.ImgsrcBtn= AppCompatResources.getDrawable(binding.getRoot().getContext(), R.drawable.mnultivideo);
       items.add(multivideo);
        menuitems swipe=new menuitems();
        swipe.namelayout="swipe videos";
        swipe.ImgsrcBtn= AppCompatResources.getDrawable(binding.getRoot().getContext(), R.drawable.reels);
        items.add(swipe);
        menuitems map=new menuitems();
        map.namelayout="Map";
        map.ImgsrcBtn= AppCompatResources.getDrawable(binding.getRoot().getContext(), R.drawable.map);
        items.add(map);

    }

}
