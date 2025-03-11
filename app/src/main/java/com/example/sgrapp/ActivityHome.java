package com.example.sgrapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapsInitializer;

public class ActivityHome extends AppCompatActivity {

    private MapView mapView;
    private GoogleMap googleMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Initialize Floating Action Buttons
        FloatingActionButton findTrainButton = findViewById(R.id.findTrainButton);
        FloatingActionButton notificationsButton = findViewById(R.id.notificationsButton);
        FloatingActionButton helpButton = findViewById(R.id.helpButton);
        mapView = findViewById(R.id.mapView);

        // Initialize Google Maps
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(map -> {
            googleMap = map;
            MapsInitializer.initialize(getApplicationContext());
        });

        // Set click listeners for FABs
        findTrainButton.setOnClickListener(v -> startActivity(new Intent(ActivityHome.this, FindTrainActivity.class)));
        notificationsButton.setOnClickListener(v -> startActivity(new Intent(ActivityHome.this, NotificationsActivity.class)));
        helpButton.setOnClickListener(v -> startActivity(new Intent(ActivityHome.this, HelpActivity.class)));
    }

    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }
}
