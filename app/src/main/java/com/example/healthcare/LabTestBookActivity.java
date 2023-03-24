package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LabTestBookActivity extends AppCompatActivity {
    EditText edFullName, edAddress, edPinCode, edContact;
    Button btnBook,btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test_book);
        edFullName = findViewById(R.id.editTextLTBFullName);
        edAddress = findViewById(R.id.editTextLTBAddress);
        edPinCode = findViewById(R.id.editTextLTBPinCode);
        edContact = findViewById(R.id.editTextLTBContact);
        Intent intent = getIntent();
        String[] price = intent.getStringExtra("price").toString().split(java.util.regex.Pattern.quote(":"));
        String date = intent.getStringExtra("date");
        String time = intent.getStringExtra("time");
        btnBook = findViewById(R.id.buttonLTBBook);
        btnBack = findViewById(R.id.buttonLTBBack);
        btnBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp = getSharedPreferences("share_prefs", MODE_PRIVATE);
                String username = sp.getString("username", "").toString();
                Database db = new Database(getApplicationContext(),"HealthCare",null,1);
                if(edFullName.getText().toString().equals("") || edAddress.getText().toString().equals("") || edPinCode.getText().toString().equals("") || edContact.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }
                else{
                    db.addOrder(username,edFullName.getText().toString(),edAddress.getText().toString(),edContact.getText().toString(),Integer.parseInt(edPinCode.getText().toString()),date.toString(),time.toString(),Float.parseFloat(price[1].toString()),"Lab");
                    db.removeCart(username,"Lab");
                    Toast.makeText(getApplicationContext(), "\n" +
                            "Đặt chỗ thành công", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LabTestBookActivity.this, HomeActivity.class));
                }
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LabTestBookActivity.this, LabTestActivity.class));
            }
        });

    }
}