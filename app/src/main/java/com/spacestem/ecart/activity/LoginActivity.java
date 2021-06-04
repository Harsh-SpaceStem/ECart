package com.spacestem.ecart.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.spacestem.ecart.R;
import com.spacestem.ecart.utils.PreferenceManager;

import static com.spacestem.ecart.utils.InputValidator.validateEmail;
import static com.spacestem.ecart.utils.InputValidator.validatePassword;

public class LoginActivity extends AppCompatActivity {

    TextView tv_register, tv_forgotPassword;
    MaterialButton btn_login;
    TextInputLayout login_emailLayout, login_passwordLayout;
    TextInputEditText edt_loginEmail, edt_loginPassword;
    String email, password;
    PreferenceManager preferenceManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();


        tv_register.setOnClickListener(v -> LoginActivity.this.startActivity(new Intent(LoginActivity.this, RegisterActivity.class)));
        btn_login.setOnClickListener(v -> {
            getCredentials();
           /* LoginActivity.this.startActivity(new Intent(LoginActivity.this, HomeActivity.class));
            LoginActivity.this.finish();*/
            if (!(!validateEmail(LoginActivity.this, email, login_emailLayout) | !validatePassword(LoginActivity.this, password, login_passwordLayout))) {
                preferenceManager.saveLogin(email);
                startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                finish();
            }
        });
        tv_forgotPassword.setOnClickListener(v -> startActivity(new Intent(LoginActivity.this, ForgotPasswordActivity.class)));
    }

    private void getCredentials() {
        email = edt_loginEmail.getEditableText().toString();
        password = edt_loginPassword.getEditableText().toString();
    }

    private void initView() {
        tv_forgotPassword = findViewById(R.id.tv_forgotPassword);
        tv_register = findViewById(R.id.tv_register);
        btn_login = findViewById(R.id.btn_login);
        login_emailLayout = findViewById(R.id.login_emailLayout);
        login_passwordLayout = findViewById(R.id.login_passwordLayout);
        edt_loginEmail = findViewById(R.id.edt_loginEmail);
        edt_loginPassword = findViewById(R.id.edt_loginPassword);
        preferenceManager = new PreferenceManager(this);
    }
}