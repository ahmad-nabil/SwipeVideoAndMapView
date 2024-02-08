package com.ahmad.advancedcoded;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.ahmad.advancedcoded.databinding.ActivityMainMenuBinding;
import com.ahmad.advancedcoded.helper.menuBtnhelper;

public class MainMenu extends AppCompatActivity {
ActivityMainMenuBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainMenuBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);
        //initialize class for btn and view pager
        menuBtnhelper menuBtnhelper=new menuBtnhelper(binding);
  //get component viewpager from class
        menuBtnhelper.initializeViewPager();
    }
}