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

import static com.spacestem.ecart.utils.InputValidator.validateConfirmPassword;
import static com.spacestem.ecart.utils.InputValidator.validateEmail;
import static com.spacestem.ecart.utils.InputValidator.validateName;
import static com.spacestem.ecart.utils.InputValidator.validatePasswordForRegistration;
import static com.spacestem.ecart.utils.InputValidator.validatePhone;

public class RegisterActivity extends AppCompatActivity {

    TextInputLayout nameLayout, emailLayout, phoneLayout, passwordLayout, cnfPasswordLayout;
    TextInputEditText edt_name, edt_email, edt_phone, edt_password, edt_cnfPassword;
    MaterialButton btn_register;
    TextView tv_backToLogin;
    String password, cnfPassword, phone, email, name;
    PreferenceManager preferenceManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();

        btn_register.setOnClickListener(v -> {
            getCredentials();
            if (!(!validateName(RegisterActivity.this, name, nameLayout)
                    | !validateEmail(RegisterActivity.this, email, emailLayout)
                    | !validatePhone(RegisterActivity.this, phone, phoneLayout)
                    | !validatePasswordForRegistration(RegisterActivity.this, password, passwordLayout)
                    | !validateConfirmPassword(RegisterActivity.this, cnfPassword, password, cnfPasswordLayout))) {
                preferenceManager.saveUserDetails(name, email, phone);
                startActivity(new Intent(RegisterActivity.this, HomeActivity.class));
                finish();
            }
        });

        tv_backToLogin.setOnClickListener(v -> finish());
    }

    private void getCredentials() {
        name = edt_name.getEditableText().toString();
        phone = edt_phone.getEditableText().toString();
        email = edt_email.getEditableText().toString();
        password = edt_password.getEditableText().toString();
        cnfPassword = edt_cnfPassword.getEditableText().toString();
    }

    private void initView() {
        nameLayout = findViewById(R.id.registerNameLayout);
        emailLayout = findViewById(R.id.registerEmailLayout);
        phoneLayout = findViewById(R.id.registerPhoneLayout);
        passwordLayout = findViewById(R.id.registerPasswordLayout);
        cnfPasswordLayout = findViewById(R.id.registerCnfPasswordLayout);

        edt_name = findViewById(R.id.edt_registerName);
        edt_email = findViewById(R.id.edt_registerEmail);
        edt_phone = findViewById(R.id.edt_registerPhone);
        edt_password = findViewById(R.id.edt_registerPassword);
        edt_cnfPassword = findViewById(R.id.edt_register_cnfPassword);
        btn_register = findViewById(R.id.btn_register);
        tv_backToLogin = findViewById(R.id.tv_backToLogin);

        preferenceManager = new PreferenceManager(this);
    }
}