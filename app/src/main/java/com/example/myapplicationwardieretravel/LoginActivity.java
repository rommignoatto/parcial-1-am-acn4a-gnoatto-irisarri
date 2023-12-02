package com.example.myapplicationwardieretravel;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class LoginActivity extends AppCompatActivity {
    public void login (String email, String password){
        String tag;
        Log.i( "firebase",  "email:" + email);
        Log.i("firebase",  "password:" + password);
    }

    public void onLogButtonClick (View view){
        this.login("hola@romina.io", "prueba123");

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
    }
}