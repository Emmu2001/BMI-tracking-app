package com.main.mini;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;

public class dasboard extends AppCompatActivity {

    //Variables
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    androidx.appcompat.widget.Toolbar toolbar;
    Menu menu;
    TextView textView;
    private Button btnprofile;
    private Button btndiet;
    private Button btnworkout;
    private Button btntarget;
    private Button btnstats;
    private Button btncalorie;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dasboard);
        btnprofile = (Button) findViewById(R.id.textView9);
        btncalorie = (Button) findViewById(R.id.textView8);
        btntarget = (Button) findViewById(R.id.textView6);
        btndiet = (Button) findViewById(R.id.textView4);
        btnworkout = (Button) findViewById(R.id.textView3);
        btnstats = (Button) findViewById(R.id.textView7);


        //hooks
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        textView = findViewById(R.id.textView);
        toolbar = findViewById(R.id.toolbar);

        //toolbar
        setSupportActionBar(toolbar);

        //navigation drawer menu
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        btnprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(dasboard.this, profile.class);
                startActivity(intent);
            }
        });
        btncalorie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(dasboard.this, calorie.class);
                startActivity(intent);
            }
        });
        btndiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(dasboard.this, diet.class);
                startActivity(intent);
            }
        });
        btnworkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(dasboard.this, workout.class);
                startActivity(intent);
            }
        });
        btntarget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(dasboard.this, target.class);
                startActivity(intent);
            }
        });
        btnstats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(dasboard.this, stats.class);
                startActivity(intent);
            }
        });


    }

    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();

        }


    }
}