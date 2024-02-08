package com.ahmad.advancedcoded.helper;

import static com.ahmad.advancedcoded.R.drawable.baseline_location_on_24;
import static com.mapbox.maps.plugin.gestures.GesturesUtils.getGestures;
import static com.mapbox.maps.plugin.locationcomponent.LocationComponentUtils.getLocationComponent;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;

import com.ahmad.advancedcoded.databinding.ActivityMapBinding;
import com.mapbox.android.gestures.MoveGestureDetector;
import com.mapbox.geojson.Point;
import com.mapbox.maps.CameraOptions;
import com.mapbox.maps.ImageHolder;
import com.mapbox.maps.Style;
import com.mapbox.maps.plugin.LocationPuck2D;
import com.mapbox.maps.plugin.gestures.OnMoveListener;
import com.mapbox.maps.plugin.locationcomponent.LocationComponentPlugin;
import com.mapbox.maps.plugin.locationcomponent.OnIndicatorBearingChangedListener;
import com.mapbox.maps.plugin.locationcomponent.OnIndicatorPositionChangedListener;
import com.mapbox.maps.plugin.locationcomponent.generated.LocationComponentSettings;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class locationViewHelper {
ActivityMapBinding binding;
Context context;


    public locationViewHelper(ActivityMapBinding binding, Context context) {
        this.binding = binding;
        this.context = context;
    }
    public  void getlocation(){
        //hide button get location "assume u will get your location automatically"  if not automatically  will show second tim
        binding.getlocationBtn.hide();
        //initialize mapbox and component mapbox
        binding.mapView.getMapboxMap().loadStyle("mapbox://styles/ahmadnabils/clqh4yy3300g101r5fskb6k8c", new Style.OnStyleLoaded() {
            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void onStyleLoaded(@NonNull Style style) {
                //setting camera position of the Mapbox
                binding.mapView.getMapboxMap().setCamera(new CameraOptions.Builder().build());
//This component is responsible for showing the user  location
                LocationComponentPlugin location=getLocationComponent(binding.mapView);
                location.setEnabled(true);
                //customize the appearance of the user's location marker on the map . we choose 2d better for preformance and same google map
                LocationPuck2D locationPuck2D=new LocationPuck2D();
                //icon to show location user
                locationPuck2D.setBearingImage(ImageHolder.from(baseline_location_on_24));
                location.setLocationPuck(locationPuck2D);
//add listener to show location for user accurate
                location.addOnIndicatorBearingChangedListener(onIndicatorBearingChangedlistener);
                location.addOnIndicatorPositionChangedListener(onIndicatorPositionChangedListener);
                getGestures(binding.mapView).addOnMoveListener(onMovelistener);
                binding.getlocationBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        location.addOnIndicatorBearingChangedListener(onIndicatorBearingChangedlistener);
                        location.addOnIndicatorPositionChangedListener(onIndicatorPositionChangedListener);
                        getGestures(binding.mapView).addOnMoveListener(onMovelistener);
                        //hide button get location  after got your location
                        binding.getlocationBtn.hide();
                    }
                });
            location.updateSettings(new Function1<LocationComponentSettings.Builder, Unit>() {
                @Override
                public Unit invoke(LocationComponentSettings.Builder builder) {
                    location.setPulsingEnabled(true);
                    return null;
                }
            });
            }});

    }




    //this listener get bearing OF device and when device change will update the map
         final OnIndicatorBearingChangedListener onIndicatorBearingChangedlistener=new OnIndicatorBearingChangedListener() {
            @Override
            public void onIndicatorBearingChanged(double v) {
                binding.mapView.getMapboxMap().setCamera(new CameraOptions.Builder().bearing(v).build());
            }
        };
//listener to get change of position device like previous listener
         final OnIndicatorPositionChangedListener onIndicatorPositionChangedListener=new OnIndicatorPositionChangedListener() {
            @Override
            public void onIndicatorPositionChanged(@NonNull Point point) {
                binding.mapView.getMapboxMap().setCamera(new CameraOptions.Builder().center(point).build());
                getGestures(binding.mapView).setFocalPoint(binding.mapView.getMapboxMap().pixelForCoordinate(point));

            }
        };
        //listener to detect when position change
         final OnMoveListener onMovelistener=new OnMoveListener() {
            @Override
            public void onMoveBegin(@NonNull MoveGestureDetector moveGestureDetector) {
                //remove  onIndicatorPositionChangedListener and onIndicatorBearingChangedListener  because we need to stop focusing to get accurate location when user moving
                getLocationComponent(binding.mapView).removeOnIndicatorPositionChangedListener(onIndicatorPositionChangedListener);
                getLocationComponent(binding.mapView).removeOnIndicatorBearingChangedListener(onIndicatorBearingChangedlistener);
                getGestures(binding.mapView).removeOnMoveListener(onMovelistener);
               //show Btn when start moving
                binding.getlocationBtn.show();

            }

            @Override
            public boolean onMove(@NonNull MoveGestureDetector moveGestureDetector) {
                return false;
            }

            @Override
            public void onMoveEnd(@NonNull MoveGestureDetector moveGestureDetector) {

            }
        };

    }


