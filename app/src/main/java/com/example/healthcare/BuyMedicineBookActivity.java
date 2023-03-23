package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BuyMedicineBookActivity extends AppCompatActivity {
    EditText edFullName,edAddress,edPincode,edContact;
    Button btnBook;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine_book);
        edFullName = findViewById(R.id.editTextMDBFullName);
        edAddress = findViewById(R.id.editTextMDBAddress);
        edPincode = findViewById(R.id.editTextMDBPinCode);
        edContact = findViewById(R.id.editTextMDBContact);
        btnBook= findViewById(R.id.buttonMDBBook);
        Intent intent = getIntent();
        String[] price = intent.getStringExtra("price").toString().split(java.util.regex.Pattern.quote(":"));
        String date = intent.getStringExtra("date");

        btnBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp = getSharedPreferences("share_prefs", Context.MODE_PRIVATE);
                String username = sp.getString("username", "").toString();
                Database db = new Database(getApplicationContext(), "HealthCare", null, 1);
               //Kiem soat du lieu
                if(edFullName.getText().toString().equals("") || edAddress.getText().toString().equals("") || edPincode.getText().toString().equals("") || edContact.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }
                else{
                    db.addOrder(username, edFullName.getText().toString(), edAddress.getText().toString(), edContact.getText().toString(), Integer.parseInt(edPincode.getText().toString()), date.toString(), "", Float.parseFloat(price[1].toString()), "medicine");
                    db.removeCart(username, "medicine");
                    Toast.makeText(getApplicationContext(), "\n" +
                            "Đặt thuốc thành công", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(BuyMedicineBookActivity.this, HomeActivity.class));
                }
            }
        });

    }
}