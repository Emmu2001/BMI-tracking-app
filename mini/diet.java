package com.main.mini;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.main.mini.R;

public class diet extends AppCompatActivity {
    private Button btnveg;
    private Button btnnveg;
    private Button btnpoints;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet);
        btnveg=(Button) findViewById(R.id.button);
        btnnveg=(Button) findViewById(R.id.button2 );
        btnpoints=(Button) findViewById(R.id.button3);


        btnveg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(diet.this, veg.class);
                startActivity(intent);
            }
        });
        btnnveg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(diet.this, nonveg.class);
                startActivity(intent);
            }
        });
        btnpoints.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(diet.this, points.class);
                startActivity(intent);
            }
        });

    }
}