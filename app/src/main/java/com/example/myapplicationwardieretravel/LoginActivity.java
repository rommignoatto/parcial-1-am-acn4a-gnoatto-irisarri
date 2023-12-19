package com.example.myapplicationwardieretravel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthActionCodeException;

public class LoginActivity<EmailPasswordActivity> extends AppCompatActivity {

    private FirebaseAuth mAuth;
    public void login (String email, String password){
        String tag;
        Log.i( "firebase",  "email:" + email);
        Log.i("firebase",  "password:" + password);
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);


        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);

                        }else {
                            Toast.makeText(LoginActivity.this, "Fallo el login.",
                                    Toast.LENGTH_SHORT).show();
                        }


                    }
                });
    }

    public void onLogButtonClick (View view){
        EditText emailInput = findViewById(R.id.Email);
        EditText passInput = findViewById(R.id.Password);

        String email = emailInput.getText().toString();
        String password = passInput.getText().toString();
        this.login(email, password);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();

        Button buttonRegistrarse = findViewById(R.id.buttonRegister);

        buttonRegistrarse.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(LoginActivity.this, Registration.class);
                startActivity(intent);

            }
        });
    }


}