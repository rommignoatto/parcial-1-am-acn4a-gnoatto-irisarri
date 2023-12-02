package com.example.myapplicationwardieretravel;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    public void login (String email, String password){
        String tag;
        Log.i( "firebase",  "email:" + email);
        Log.i("firebase",  "password:" + password);
    }

    public void onLogButtonClick (View view){
        EditText emailInput = findViewById(R.id.email);
        EditText passInput = findViewById(R.id.password);

        String email = emailInput.getText().toString();
        String password = passInput.getText().toString();
        this.login("hola@romina.io", "prueba123");

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
}