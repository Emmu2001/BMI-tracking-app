package com.main.mini;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class editprofile extends AppCompatActivity {

    private Button btnprofile1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editprofile);
        btnprofile1= (Button) findViewById(R.id.btnNext1);


        btnprofile1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(editprofile.this, dasboard.class);
                startActivity(intent);
            }
        });
    }
}