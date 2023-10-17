package com.example.myapplicationwardieretravel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button buyButtonLondon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buyButtonLondon = findViewById(R.id.buyButton);

    }

    public void buyLondon(View v){
        Toast.makeText(this, "Compraste paquete Londres histórica", Toast.LENGTH_SHORT).show();
    }
}