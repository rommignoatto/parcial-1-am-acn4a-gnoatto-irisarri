package com.example.myapplicationwardieretravel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Registration extends AppCompatActivity {

    EditText registerName;
    EditText registerPass;
    Button btnRegister;

    Button btnLogin;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        registerName= findViewById(R.id.editTextTextRegisterName);
        registerPass= findViewById(R.id.editTextTextPasswordRegister);
        btnRegister= findViewById(R.id.button3Registrar);
        btnLogin = findViewById(R.id.button4Login);

        mAuth = FirebaseAuth.getInstance();
        btnRegister.setOnClickListener(view->{
            createUser();
        });

        btnLogin.setOnClickListener(view->{
            startActivity(new Intent(Registration.this, LoginActivity.class));
        });
    }

    private void createUser(){
        String email = registerName.getText().toString();
        String password = registerPass.getText().toString();

        if(TextUtils.isEmpty(email)){
            registerName. setError("Email no puede estar vacío");
            registerName.requestFocus();
        }else if(TextUtils.isEmpty(password)){
            registerPass.setError("Password no puede estar vacío");
            registerPass.requestFocus();
        }else{
            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(Registration.this, "Usuario creado exitosamente", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Registration.this, LoginActivity.class));
                    }else{
                        Toast.makeText(Registration.this, "Ocurrió un error "+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}