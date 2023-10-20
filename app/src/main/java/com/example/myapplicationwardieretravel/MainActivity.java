package com.example.myapplicationwardieretravel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button buyButtonLondon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buyButtonLondon = findViewById(R.id.buyButton);



    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.header_menu, menu);

        MenuItem profileItem = menu.findItem(R.id.marca);
        View actionView = profileItem.getActionView();

        if (actionView != null) {
            ImageView profileIcon = actionView.findViewById(R.id.marca);

            TextView profileText = actionView.findViewById(R.id.perfil);
        }

        return true;
    }

    public void buyLondon(View v){
        Toast.makeText(this, "Compraste paquete Londres histórica", Toast.LENGTH_SHORT).show();
    }
}