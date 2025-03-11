package com.example.sgrapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ActivitySignUp extends AppCompatActivity {

    private EditText firstNameInput, lastNameInput, emailInput, nidaInput, phoneNumberInput, passwordInput;
    private Spinner genderSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        // Initialize UI components
        firstNameInput = findViewById(R.id.firstNameInput);
        lastNameInput = findViewById(R.id.lastNameInput);
        emailInput = findViewById(R.id.emailInput);
        nidaInput = findViewById(R.id.nidaNumberInput);
        phoneNumberInput = findViewById(R.id.phoneNumberInput);
        passwordInput = findViewById(R.id.passwordInput);
        genderSpinner = findViewById(R.id.genderSpinner);
        Button signUpButton = findViewById(R.id.signUpButton);
        TextView signInLink = findViewById(R.id.signInLink);

        // Sign Up button listener
        signUpButton.setOnClickListener(v -> {
            String firstName = firstNameInput.getText().toString().trim();
            String lastName = lastNameInput.getText().toString().trim();
            String email = emailInput.getText().toString().trim();
            String nida = nidaInput.getText().toString().trim();
            String phoneNumber = phoneNumberInput.getText().toString().trim();
            String password = passwordInput.getText().toString().trim();
            String gender = genderSpinner.getSelectedItem().toString();

            if (validateInputs(firstName, lastName, email, nida, phoneNumber, password)) {
                // Handle sign-up logic here (e.g., save to database or send to API)
                Toast.makeText(ActivitySignUp.this, "Sign-up successful!", Toast.LENGTH_SHORT).show();

                // Navigate to login screen
                Intent intent = new Intent(ActivitySignUp.this, ActivityLogin.class);
                startActivity(intent);
            }
        });

        // Navigate to login screen when "Sign In" link is clicked
        signInLink.setOnClickListener(v -> {
            Intent intent = new Intent(ActivitySignUp.this, ActivityLogin.class);
            startActivity(intent);
        });
    }

    private boolean validateInputs(String firstName, String lastName, String email, String nida, String phoneNumber, String password) {
        if (TextUtils.isEmpty(firstName)) {
            firstNameInput.setError("First name is required");
            return false;
        }
        if (TextUtils.isEmpty(lastName)) {
            lastNameInput.setError("Last name is required");
            return false;
        }
        if (TextUtils.isEmpty(email)) {
            emailInput.setError("Email is required");
            return false;
        }
        if (TextUtils.isEmpty(nida)) {
            nidaInput.setError("NIDA number is required");
            return false;
        }
        if (TextUtils.isEmpty(phoneNumber)) {
            phoneNumberInput.setError("Phone number is required");
            return false;
        }
        if (password.length() < 8) {
            passwordInput.setError("Password must be at least 8 characters");
            return false;
        }
        return true;
    }
}
