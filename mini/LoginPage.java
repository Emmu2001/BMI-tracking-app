package com.main.mini;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginPage extends AppCompatActivity {

    private TextView register;
    private Button btnSignIn;
    private ImageButton btnfacebook;
    private ImageButton btngmail;
    private ImageButton btnmail;
    private EditText etEmail,etPassword;
    private FirebaseAuth fAuth=FirebaseAuth.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        register = (TextView) findViewById(R.id.register);
        btnSignIn=(Button)findViewById(R.id.signin);
        btngmail= (ImageButton) findViewById(R.id.gmail);
        btnmail= (ImageButton) findViewById(R.id.mail);
        btnfacebook= (ImageButton) findViewById(R.id.facebook);
        etEmail=findViewById(R.id.email);
        etPassword=findViewById(R.id.password);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                        Intent intent = new Intent(LoginPage.this, Register.class);
                        startActivity(intent);
                }
        });
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etEmail.getText().toString().isEmpty())
                {
                    etEmail.setError("Enter Email");
                    return;
                }
                if(etPassword.getText().toString().isEmpty())
                {
                    etPassword.setError("Enter Password");
                    return;
                }
                fAuth.signInWithEmailAndPassword(etEmail.getText().toString().trim(),etPassword.getText().toString().trim()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        Intent intent1 = new Intent(getApplicationContext(),dasboard.class);
                        startActivity(intent1);
                        finish();

                    }

                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(LoginPage.this,e.getMessage(),Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });
        btnfacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginPage.this, BMI.class);
                startActivity(intent);
            }
        });
        btngmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginPage.this, Register.class);
                startActivity(intent);
            }
        });
        btnmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginPage.this, Register.class);
                startActivity(intent);
            }
        });

    }
}