package com.main.mini;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {

    private Spinner dropdown;
    Button next;
    private FirebaseAuth mAuth=FirebaseAuth.getInstance();
    private EditText editTextEnterName,editTextEnterEmail,editTextEnterphonenumber,editTextEnterpassword,editTextEnterAge,editTextEnterCity;
    private Object EditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();

        dropdown = findViewById(R.id.spinner);
        next=findViewById(R.id.btnNext);
        String[] items = new String[]{"Male", "Female"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,items);
        dropdown.setAdapter(adapter);

        editTextEnterName=(EditText) findViewById(R.id.edtname);
        editTextEnterEmail=(EditText) findViewById(R.id.edtemail);
        editTextEnterphonenumber=(EditText) findViewById(R.id.edtphone);
        editTextEnterpassword=(EditText) findViewById(R.id.edtpassword);
        editTextEnterAge=(EditText) findViewById(R.id.edtage);
        editTextEnterCity=(EditText) findViewById(R.id.edtcity);

        dropdown =(Spinner)findViewById(R.id.spinner);

        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                RegisterUser();
                Intent intent = new Intent(Register.this, BMI.class);
                startActivity(intent);
            }
        });


    }
    private void RegisterUser() {
        String edtname = editTextEnterName.getText().toString().trim();
        String edtemail = editTextEnterEmail.getText().toString().trim();
        String edtphone = editTextEnterphonenumber.getText().toString().trim();
        String edtpassword = editTextEnterpassword.getText().toString().trim();
        String edtage = editTextEnterAge.getText().toString().trim();
        String edtcity = editTextEnterCity.getText().toString().trim();

        if(edtname.isEmpty()) {
            editTextEnterName.setError("Full name is required!");
            editTextEnterName.requestFocus();
            return;
        }

        if(edtemail.isEmpty()){
                editTextEnterEmail.setError("Email is required!");
        editTextEnterEmail.requestFocus();
        return;
    }

        if(!Patterns.EMAIL_ADDRESS.matcher (edtemail).matches()) {

            editTextEnterEmail.setError("Please provide valid email!");
            editTextEnterEmail.requestFocus();
            return;
    }

        if(edtphone.isEmpty()) {
            editTextEnterphonenumber.setError("Phone number is required!");
            editTextEnterphonenumber.requestFocus();
            return;
        }

        if(edtpassword.isEmpty()) {
            editTextEnterpassword.setError("Password is required!");
            editTextEnterpassword.requestFocus();
            return;
        }

        if(edtage.isEmpty()) {
            editTextEnterAge.setError("Age is required!");
            editTextEnterAge.requestFocus();
            return;
        }
        if(edtage.length()<4) {
            editTextEnterAge.setError("Enter valid Age");
            editTextEnterAge.requestFocus();
            return;
        }

        if(edtcity.isEmpty()) {
            editTextEnterCity.setError("City is required!");
            editTextEnterCity.requestFocus();
            return;
        }

        mAuth.createUserWithEmailAndPassword(edtemail,edtpassword).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(getApplication(),"User Created Successfully",Toast.LENGTH_SHORT).show();

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });








    }

}