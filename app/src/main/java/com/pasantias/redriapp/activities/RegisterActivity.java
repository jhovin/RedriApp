package com.pasantias.redriapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.pasantias.redriapp.R;
import com.pasantias.redriapp.models.User;
import com.pasantias.redriapp.repositories.UserRepository;

public class RegisterActivity extends AppCompatActivity {

    private EditText fullnameInput;

    private EditText emailInput;

    private EditText passwordInput;

    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        fullnameInput = findViewById(R.id.fullname_input);
        emailInput = findViewById(R.id.email_input);
        passwordInput = findViewById(R.id.password_input);
        saveButton = findViewById(R.id.save_button);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
            }
        });
    }

    private void save() {
        String fullname = fullnameInput.getText().toString();
        String email = emailInput.getText().toString();
        String password = passwordInput.getText().toString();

        User user = new User();
        user.setFullname(fullname);
        user.setEmail(email);
        user.setPassword(password);

        if (fullname.isEmpty()||email.isEmpty()||password.isEmpty()){
            Toast.makeText(this, "Ingrese todos los campos!", Toast.LENGTH_SHORT).show();
            return;
        } else {
            UserRepository.save(user);
            Toast.makeText(this, "Usuario registrado con exito!", Toast.LENGTH_SHORT).show();
        }
        Intent intent=new Intent(this,OrdenActivity.class);
        startActivity(intent);
        setResult(RESULT_OK);
    }


}



