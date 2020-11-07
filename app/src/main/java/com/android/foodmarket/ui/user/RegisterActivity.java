package com.android.foodmarket.ui.user;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.foodmarket.R;
import com.android.foodmarket.models.User;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etUserName, etUserLastName, etUserEmail, etUserPassword, etRepeatUserPassword;
    Button btCreateAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        getSupportActionBar().setTitle("Crear cuenta.");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        etUserName = (EditText) findViewById(R.id.etUserName);
        etUserLastName = (EditText) findViewById(R.id.etUserLastName);
        etUserEmail = (EditText) findViewById(R.id.etUserEmail);
        etUserPassword = (EditText) findViewById(R.id.etUserPassword);
        etRepeatUserPassword = (EditText) findViewById(R.id.etRepeatUserPassword);

        btCreateAccount = (Button) findViewById(R.id.btCreateAccount);
        btCreateAccount.setOnClickListener(this);
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

    public void clearInputs(){
        etUserName.setText("");
        etUserLastName.setText("");
        etUserEmail.setText("");
        etUserPassword.setText("");
        etRepeatUserPassword.setText("");
    }

    @Override
    public void onClick(View view) {
        String userName = etUserName.getText().toString();

        if(userName.length() <= 0){
            etUserName.setError("Campo requerido");
            etUserName.requestFocus();
            return;
        }

        String lastName = etUserLastName.getText().toString();

        if(lastName.length() <= 0){
            etUserLastName.setError("Campo requerido");
            etUserLastName.requestFocus();
            return;
        }

        String userEmail = etUserEmail.getText().toString();

        if(userEmail.length() <= 0|| !Patterns.EMAIL_ADDRESS.matcher(userEmail).matches()){
            etUserEmail.setError("Email ingresado es inválido.");
            etUserEmail.requestFocus();
            return;
        }

        String password = etUserPassword.getText().toString();

        if(password.length() < 6){
            etUserPassword.setError("La clave debe contener al menos 6 caracteres.");
            etUserPassword.requestFocus();
            return;
        }

        String repeatPassword = etRepeatUserPassword.getText().toString();

        if(!password.equals(repeatPassword)){
            etRepeatUserPassword.setError("La contraseña ingresada no coincide.");
            etRepeatUserPassword.requestFocus();
            return;
        }

        if(!User.exist(userEmail)){
            User.USERS.add(new User(userEmail, password));

            Snackbar.make(view, "Usuario creado con éxito.", BaseTransientBottomBar.LENGTH_LONG)
                    .setAction("IR A LOGIN", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }).show();
        }
        else{
            etUserEmail.setError("El correo ya se encuentra registrado.");
            etUserEmail.requestFocus();
        }
    }
}