package com.ahmad.advancedcoded;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.ahmad.advancedcoded.Adapter.MultiVideoAdapter;
import com.ahmad.advancedcoded.CustomClassData.MultiVideoItems;
import com.ahmad.advancedcoded.databinding.ActivityMultiVideosBinding;
import com.ahmad.advancedcoded.helper.videosList;

import java.util.ArrayList;

public class MultiVideos extends AppCompatActivity {
private ActivityMultiVideosBinding binding;
    ArrayList <MultiVideoItems> VideoItems=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //initialize binding view and other components
        binding=ActivityMultiVideosBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);
        //video class to get list video
     videosList videosList=new videosList();
     videosList.VideoListMultiVideo(VideoItems);
        initializeComponentsUI();

    }

    private void initializeComponentsUI() {
        MultiVideoAdapter adapter=new MultiVideoAdapter(VideoItems,this);
        binding.multiVideo.setAdapter(adapter);
        binding.multiVideo.setLayoutManager(new LinearLayoutManager(MultiVideos.this));
    }

}