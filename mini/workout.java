package com.main.mini;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class workout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);
        TextView textView=(TextView)findViewById(R.id.link);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }
}