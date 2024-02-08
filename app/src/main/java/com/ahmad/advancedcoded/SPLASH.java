package com.ahmad.advancedcoded;


import static com.tomer.fadingtextview.FadingTextView.SECONDS;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.ahmad.advancedcoded.databinding.ActivitySplashBinding;
import com.bumptech.glide.Glide;

public class SPLASH extends AppCompatActivity {
ActivitySplashBinding Binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Binding=ActivitySplashBinding.inflate(getLayoutInflater());
        View splash=Binding.getRoot();
        setContentView(splash);
        //background
        Glide.with(splash).load("https://user-images.githubusercontent.com/74038190/212748830-4c709398-a386-4761-84d7-9e10b98fbe6e.gif")
                        .into(Binding.imageView);
        //for fading textview must use array
        String[] TextTitle= {"Task 12 ", " Advanced Coded "};
        Binding.splashtitle.setTexts(TextTitle);
      //timeout for fading text view
        Binding.splashtitle.setTimeout(2,SECONDS);
        //splash timeout
new Thread(new Runnable() {
    @Override
    public void run() {
        for (int progress = 0; progress <=Binding.progressBar.getMax(); progress++) {
            Binding.progressBar.setProgress(progress);
            try {
                Thread.sleep(200);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        startActivity(new Intent(SPLASH.this, MainMenu.class));

    }
}).start();

    }
}