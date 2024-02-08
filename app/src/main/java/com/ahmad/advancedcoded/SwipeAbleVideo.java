package com.ahmad.advancedcoded;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.ahmad.advancedcoded.Adapter.SwipeVideoAdapter;
import com.ahmad.advancedcoded.CustomClassData.SwipeVideoitems;
import com.ahmad.advancedcoded.databinding.ActivitySwipeableVideoBinding;
import com.ahmad.advancedcoded.helper.videosList;

import java.util.ArrayList;


public class SwipeAbleVideo extends AppCompatActivity {
private ActivitySwipeableVideoBinding binding;
    ArrayList < SwipeVideoitems> VideoItems=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //initialize binding components for swipe video
binding =ActivitySwipeableVideoBinding.inflate(getLayoutInflater());
View view=binding.getRoot();
setContentView(view);
       //class to get video of them to add url for videos
      videosList VideoList=new videosList();
      VideoList.VideoListSwipableVideo(VideoItems);
        //view pager adapter
        SwipeVideoAdapter adapterViewPager=new SwipeVideoAdapter(VideoItems,SwipeAbleVideo.this);
     binding.viewPagerSwipeVideo.setAdapter(adapterViewPager);
    }


}