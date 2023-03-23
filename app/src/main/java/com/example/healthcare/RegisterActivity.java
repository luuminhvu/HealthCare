package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText edUsername, edPassword, edEmail, edConfirmPassword;
    Button btnRegister;
    TextView tvLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        edUsername = findViewById(R.id.editTextRegUserName);
        edPassword = findViewById(R.id.editTextRegPassword);
        edEmail = findViewById(R.id.editTextRegEmail);
        edConfirmPassword = findViewById(R.id.editTextRegConfirmPassword);
        btnRegister = findViewById(R.id.buttonRegister);
        tvLogin = findViewById(R.id.textViewExistingUser);
        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edUsername.getText().toString();
                String password = edPassword.getText().toString();
                String email = edEmail.getText().toString();
                String confirmPassword = edConfirmPassword.getText().toString();
                Database db = new Database(getApplicationContext(),"HealthCare",null,1);
                if (username.length() == 0 || password.length() == 0 || email.length() == 0 || confirmPassword.length() == 0) {
                    Toast.makeText(RegisterActivity.this, "Vui lòng nhập tất cả các thông tin", Toast.LENGTH_SHORT).show();
                } else {
                    if (password.compareTo(confirmPassword) == 0) {
                        if (InValid(password)) {
                            db.Register(username,email,password);
                            Toast.makeText(RegisterActivity.this, "Đăng Kí Thành Công", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                        } else {
                            Toast.makeText(RegisterActivity.this, "Mật khẩu phải chứa ít nhất 1 chữ cái, 1 chữ số và 1 ký tự đặc biệt", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(RegisterActivity.this, "\n" +
                                "Mật khẩu và Xác nhận mật khẩu không khớp", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }

    public static boolean InValid(String PasswordHere) {
        int f1 = 0, f2 = 0, f3 = 0;
        if (PasswordHere.length() <= 8) {
            return false;
        } else {
            for (int i = 0; i < PasswordHere.length(); i++) {
                if (Character.isLetter(PasswordHere.charAt(i))) {
                    f1 = 1;
                }
            }
            for (int i = 0; i < PasswordHere.length(); i++) {
                if (Character.isDigit(PasswordHere.charAt(i))) {
                    f2 = 1;
                }
            }
            for (int i = 0; i < PasswordHere.length(); i++) {
                char c = PasswordHere.charAt(i);
                if (c >= 33 && c <= 46 || c == 64) {
                    f3 = 1;
                }
            }
            if (f1 == 1 && f2 == 1 && f3 == 1)
                return true;
            return false;

            }
        }
    }