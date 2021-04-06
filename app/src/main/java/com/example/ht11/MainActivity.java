package com.example.ht11;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    EditText inputText;
    TextView text;
    int size = 10;


   private DrawerLayout drawerLayout;
   private ActionBarDrawerToggle toggle;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        drawerLayout = findViewById(R.id.drawerLayout);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView nav_view = findViewById(R.id.nav_view);

        text = findViewById(R.id.textView);
        text.setTextSize(size);
        inputText = findViewById(R.id.editTextTextPersonName);


        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch(id){
                    case R.id.Button1:
                        System.out.println("Toimii");

                        text.setTextSize(size+5);
                        size = size+5;
                        break;

                    case R.id.Button2:
                        inputText.setEnabled(false);
                        text.setText(inputText.getText().toString());
                        break;
                    case R.id.Button3:
                        inputText.setEnabled(true);
                        break;
                    case R.id.Button4:
                        text.setTextSize(size-5);
                        size=size-5;
                        break;


                }
                return false;
            }
        });








    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(toggle.onOptionsItemSelected(item))
        {
            return true;
        }
        switch (item.getItemId()) {
            case R.id.Button1:
                return true;



        }
        return super.onOptionsItemSelected(item);
    }

    public void save(View v){
        text.setText(inputText.getText().toString());


    }

    public void blockWrite(View v){
        inputText.setEnabled(false);
    }

}