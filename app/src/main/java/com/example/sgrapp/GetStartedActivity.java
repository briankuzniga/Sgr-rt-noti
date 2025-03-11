package com.example.sgrapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class GetStartedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_started);

        // Initialize the Get Started button
        Button getStartedButton = findViewById(R.id.getStartedButton);

        // Set listener for the button
        getStartedButton.setOnClickListener(v -> {
            // Navigate to the login screen
            Intent intent = new Intent(GetStartedActivity.this, ActivityLogin.class);
            startActivity(intent);
            finish(); // Close GetStartedActivity to prevent going back
        });
    }
}
