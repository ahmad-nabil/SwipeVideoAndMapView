package com.ahmad.advancedcoded;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.ahmad.advancedcoded.databinding.ActivityMapBinding;
import com.ahmad.advancedcoded.helper.locationViewHelper;


public class Map extends AppCompatActivity {
ActivityMapBinding binding;
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMapBinding.inflate(getLayoutInflater());
        View mapView=binding.getRoot();
        setContentView(mapView);
//check permission and ask user to grant permission for location
        checkPermission();
        locationViewHelper locationViewHelper=new locationViewHelper(binding,Map.this);
locationViewHelper.getlocation();
    }
//check permission to ask user
    private void checkPermission() {

        if (ActivityCompat.checkSelfPermission(this, ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{ACCESS_FINE_LOCATION},1);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode==1){
            if (ActivityCompat.checkSelfPermission(this, ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(this,new String[]{ACCESS_FINE_LOCATION},1);
            }
        }
    }

}