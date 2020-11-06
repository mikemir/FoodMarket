package com.android.foodmarket.ui.user;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.foodmarket.MainActivity;
import com.android.foodmarket.R;
import com.android.foodmarket.models.User;

public class LoginActivity extends AppCompatActivity {

    Button btLogin;
    TextView tvRegistrarme, tvOlvidoContrasenia;
    EditText etEmail, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail = (EditText) findViewById(R.id.etUserEmail);
        etPassword = (EditText) findViewById(R.id.etUserPassword);

        tvRegistrarme = findViewById(R.id.tvRegistrase);
        tvOlvidoContrasenia = findViewById(R.id.tvOlvidoContrasenia);
        btLogin = findViewById(R.id.btLogin);

        tvRegistrarme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        tvOlvidoContrasenia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, ForgotPasswActivity.class);
                startActivity(intent);
            }
        });

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();

                if(User.isValidUser(email, password)){
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.putExtra("emailUser", email);
                    startActivity(intent);
                    finish();
                }
                else{
                    String message = "Usuario o contraseña inválido.";
                    Toast.makeText(LoginActivity.this, message, Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}