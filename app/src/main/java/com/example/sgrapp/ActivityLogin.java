package com.example.sgrapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityLogin extends AppCompatActivity {

    private EditText emailInput, passwordInput;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize views
        emailInput = findViewById(R.id.emailInput);
        passwordInput = findViewById(R.id.passwordInput);
        Button loginButton = findViewById(R.id.loginButton);
        Button guestButton = findViewById(R.id.guestButton);
        TextView signUpLink = findViewById(R.id.signUpLink);
        TextView forgotPassword = findViewById(R.id.forgotPassword);

        // Login button click
        loginButton.setOnClickListener(v -> {
            if (validateFields()) {
                // TODO: Add your authentication logic here
                // On successful login, navigate to HomeActivity
                Intent intent = new Intent(ActivityLogin.this, ActivityHome.class);
                startActivity(intent);
                // Apply slide animations for the transition
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                finish();
            }
        });

        // Continue as guest button click
        guestButton.setOnClickListener(v -> {
            Intent intent = new Intent(ActivityLogin.this, ActivityHome.class);
            startActivity(intent);
            overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
            finish();
        });

        // Navigate to Sign Up screen
        signUpLink.setOnClickListener(v -> {
            Intent intent = new Intent(ActivityLogin.this, ActivitySignUp.class);
            startActivity(intent);
            // Use fade animation for this transition
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        });

        // Forgot password click (implement your logic here)
        forgotPassword.setOnClickListener(v -> {
            // For example, navigate to a ForgotPasswordActivity or display a dialog.
        });
    }

    // Simple field validation logic
    private boolean validateFields() {
        String email = emailInput.getText().toString().trim();
        String password = passwordInput.getText().toString().trim();

        if (email.isEmpty()) {
            emailInput.setError("Email is required");
            return false;
        }
        if (password.isEmpty()) {
            passwordInput.setError("Password is required");
            return false;
        }
        // Additional validation (such as email format checking) can be added here.
        return true;
    }
}
