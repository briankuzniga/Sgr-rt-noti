package com.example.sgrapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

@SuppressLint("CustomSplashScreen")
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Initialize the logo ImageView
        ImageView logo = findViewById(R.id.logo);

        // Load the fade-in animation
        Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);

        // Start the animation
        logo.startAnimation(fadeIn);

        // Delay for 3 seconds before transitioning
        new Handler().postDelayed(() -> {
            // Navigate to the Get Started screen
            Intent intent = new Intent(SplashActivity.this, GetStartedActivity.class);
            startActivity(intent);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out); // Smooth transition
            finish(); // Remove SplashActivity from the back stack
        }, 800); // 3000ms = 3 seconds
    }
}
