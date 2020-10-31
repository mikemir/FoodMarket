package com.android.foodmarket;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import android.os.Bundle;
import android.util.Patterns;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.foodmarket.models.User;

public class ForgotPasswActivity extends AppCompatActivity implements View.OnClickListener {

    Button btSendEmailForgotPassword;
    EditText etUserEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_passw);

        getSupportActionBar().setTitle("Olvidé contraseña.");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        etUserEmail = (EditText) findViewById(R.id.etUserEmail);
        btSendEmailForgotPassword = (Button) findViewById(R.id.btSendEmailForgotPassw);
        btSendEmailForgotPassword.setOnClickListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onClick(View view) {
        String email = etUserEmail.getText().toString();

        if(email.length() <= 0 || !Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            etUserEmail.setError("Email ingresado inválido.");
            etUserEmail.requestFocus();
            return;
        }

        if(!User.exist(email)){
            etUserEmail.setError("No hay ningún usuario registrado con el correo: " + email + ".");
            etUserEmail.requestFocus();
            return;
        }

        String message = "Se ha enviado un correo de recuperación a: " + email;
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        etUserEmail.setText("");
    }
}