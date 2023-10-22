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
    Button buyButtonBarcelona;
    Button buyButtonParis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buyButtonLondon = findViewById(R.id.buyButton);
        buyButtonBarcelona = findViewById(R.id.buyButtonBarcelona);
        buyButtonParis = findViewById(R.id.buyButtonParis);


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
        buyButtonLondon.setText("Comprado");
        buyButtonLondon.setEnabled(false);
        buyButtonLondon.setBackgroundColor(getResources().getColor(R.color.comprado));
        Toast.makeText(this, "Compraste paquete Londres histórica", Toast.LENGTH_SHORT).show();
    }
    public void buyBarcelona(View v){
        buyButtonLondon.setText("Comprado");
        buyButtonLondon.setEnabled(false);
        buyButtonLondon.setBackgroundColor(getResources().getColor(R.color.comprado));
        Toast.makeText(this, "Compraste paquete Barcelona Gaudi", Toast.LENGTH_SHORT).show();
    }
    public void buyParis(View v){
        buyButtonLondon.setText("Comprado");
        buyButtonLondon.setEnabled(false);
        buyButtonLondon.setBackgroundColor(getResources().getColor(R.color.comprado));
        Toast.makeText(this, "Compraste paquete Paris soñada", Toast.LENGTH_SHORT).show();
    }

}
