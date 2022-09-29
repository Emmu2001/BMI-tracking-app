package com.main.mini;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class BMI extends AppCompatActivity {


    EditText weight,height;
    String calculation;
    Button bCalculateBMI,btn;
    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        height = (EditText) findViewById(R.id.Height);
        weight = (EditText) findViewById(R.id.Weight);
        bCalculateBMI=(Button) findViewById(R.id.Calculatebutton);
        result=(TextView)findViewById(R.id.result);
        btn=(Button)findViewById(R.id.btn) ;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
            private void calculateBMI(){
                String heightStr= height.getText().toString();
                String weightStr= weight.getText().toString();

                if(heightStr!=null && !"".equals(heightStr) && weightStr!=null&&!"".equals(weightStr)) {
                    float heightValue=Float.parseFloat(heightStr) / 100;
                    float weightValue=Float.parseFloat(weightStr);
                    float bmi= weightValue/(heightValue * heightValue);
                    displayBMI(bmi);
                }
            }
            private void displayBMI (float bmi) {
                String bmiLabel;

                if(Float.compare (bmi, 15f) <= 0) {
                    bmiLabel = "Very Severely Underweight!";
                }
                else if (Float.compare (bmi, 15f)> 0 && Float.compare(bmi, 16f) < 0) {
                    bmiLabel = "Severely Underweight!";
                }
                else if (Float.compare (bmi, 16f)> 0 && Float.compare(bmi, 18.5f) < 0) {
                    bmiLabel = " Underweight!";
                }
                else if (Float.compare (bmi, 18.5f)> 0 && Float.compare(bmi, 25f) < 0) {
                    bmiLabel = "Normal!";
                }
                else if (Float.compare (bmi, 25f)> 0 && Float.compare(bmi, 30f) < 0) {
                    bmiLabel = "Overweight!";
                }
                else if (Float.compare (bmi, 30f)> 0 && Float.compare(bmi, 35f) < 0) {
                    bmiLabel = "Obese Class 1!";
                }
                else if (Float.compare (bmi, 35f)> 0 && Float.compare(bmi, 40f) < 0) {
                    bmiLabel = "Obese Class 2!";
                }
                else  {
                    bmiLabel = "Obese Class 3!";
                }
                bmiLabel=bmi+ "\n"+ bmiLabel;
                result.setText (bmiLabel);
            }
        });

        bCalculateBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(BMI.this,MedicalC.class);
                startActivity(intent);
            }
        });


    }
    public void CalculateBMI(View view) {
        String heightStr = height.getText().toString();
        String weightStr = weight.getText().toString();

        if(weightStr.isEmpty()) {
            weight.setError("Weight is required!");
            weight.requestFocus();
            return;
        }
        if(weightStr.length()<4) {
            weight.setError("Invalid input");
            weight.requestFocus();
            return;
        }
        if(heightStr.isEmpty()) {
            height.setError("Height is required!");
            height.requestFocus();
            return;
        }
        if(weightStr.length()<4) {
            weight.setError("Invalid input");
            weight.requestFocus();
            return;
        }


    }
}