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

public class LabTestDetailsActivity extends AppCompatActivity {
    TextView tvPackageName,tvTotalCost;
    EditText edDetails;
    Button btnBack,btnGoToCart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test_details);
        tvPackageName = findViewById(R.id.textViewLTPackageName);
        tvTotalCost = findViewById(R.id.textViewTotalCost);
        edDetails = findViewById(R.id.editTextMultiLineLD);
        btnBack = findViewById(R.id.buttonLTBackDT);
        btnGoToCart = findViewById(R.id.buttonLTAddToCart);
        edDetails.setKeyListener(null);
        Intent intent = getIntent();
        tvPackageName.setText(intent.getStringExtra("text1"));
        edDetails.setText(intent.getStringExtra("text2"));
        tvTotalCost.setText("Total Cost: " + intent.getStringExtra("text3")+"/-");
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LabTestDetailsActivity.this, LabTestActivity.class));
            }
        });
        btnGoToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sp = getSharedPreferences("share_prefs", Context.MODE_PRIVATE);
                String username = sp.getString("username","").toString();
                String product = tvPackageName.getText().toString();
                float price = Float.parseFloat(intent.getStringExtra("text3").toString());
                Database db = new Database(getApplicationContext(),"HealthCare",null,1);
                if(db.checkCart(username,product)==1){
                    Toast.makeText(getApplicationContext(), "Đã có trong giỏ hàng", Toast.LENGTH_SHORT).show();
                }
                else{
                    db.addCart(username,product,price,"Lab");
                    Toast.makeText(getApplicationContext(), "Đã thêm vào Giỏ hàng", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LabTestDetailsActivity.this, LabTestActivity.class));
                }

            }
        });


    }
}