package com.main.mini;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class MedicalC extends AppCompatActivity {

    CheckBox cbDiabetes, cbCholesterol, cbHypertension, cbInsomnia,cbObesity,cbDepression,cbAngerIssues,cbNone;
    Button bSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical_c);
        cbDiabetes=(CheckBox)findViewById(R.id.cbDiabetes);
        cbCholesterol=(CheckBox)findViewById(R.id.cbCholesterol);
        cbHypertension=(CheckBox)findViewById(R.id.cbHypertension);
        cbInsomnia=(CheckBox)findViewById(R.id.cbInsomnia);
        cbObesity=(CheckBox)findViewById(R.id.cbObesity);
        cbDepression=(CheckBox)findViewById(R.id.cbDepression);
        cbAngerIssues=(CheckBox)findViewById(R.id.cbAngerIssues);
        cbNone=(CheckBox)findViewById(R.id.cbNone);
        bSubmit=(Button)findViewById(R.id.btnSubmit);
        bSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MedicalC.this,dasboard.class);
                startActivity(intent);
            }
        });



    }
}