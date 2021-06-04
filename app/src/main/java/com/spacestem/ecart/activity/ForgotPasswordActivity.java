package com.spacestem.ecart.activity;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.spacestem.ecart.R;

import static com.spacestem.ecart.utils.InputValidator.validateEmail;
import static com.spacestem.ecart.utils.Utilities.Toast_Short;
import static com.spacestem.ecart.utils.Utilities.displayToast;

public class ForgotPasswordActivity extends AppCompatActivity {

    Toolbar toolbar;
    MaterialButton btn_submit;
    TextInputLayout emailLayout;
    TextInputEditText edt_email;
    String email = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null)
            getSupportActionBar().setTitle("Forgot Password");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btn_submit = findViewById(R.id.btn_proceedForgotPassword);
        emailLayout = findViewById(R.id.forgotEmailLayout);
        edt_email = findViewById(R.id.edt_forgotEmail);

        btn_submit.setOnClickListener(v -> {
            if (validateEmail(ForgotPasswordActivity.this, email, emailLayout)) {
                displayToast(ForgotPasswordActivity.this, "Password reset link send successfully to :" + email, Toast_Short);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}