package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText edUsername, edPassword;
    Button btnLogin;
    TextView tvRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edUsername = findViewById(R.id.editTextRegUsername);
        edPassword = findViewById(R.id.editTextRegPassword);
        btnLogin = findViewById(R.id.buttonReg);
        tvRegister = findViewById(R.id.textViewExistingUser);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edUsername.getText().toString();
                String password = edPassword.getText().toString();
                Database db = new Database(getApplicationContext(),"HealthCare",null,1);
               if(username.length()==0 || password.length()==0){
                   Toast.makeText(getApplicationContext(), "Please enter username and password", Toast.LENGTH_SHORT).show();
               }
               else{
                   if(db.Login(username,password)==1){
                       Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_SHORT).show();
                       SharedPreferences sp = getSharedPreferences("share_prefs", Context.MODE_PRIVATE);
                       SharedPreferences.Editor editor = sp.edit();
                       editor.putString("username",username);
                       editor.apply();
                       startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                   }
                   else {
                       Toast.makeText(getApplicationContext(), "Login Failed", Toast.LENGTH_SHORT).show();
                   }
               }
            }
        });
        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             startActivity(new Intent(LoginActivity.this, RegisterActivity.class));

            }
        });
    }
}