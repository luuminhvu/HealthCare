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

public class BuyMedicineDetailsActivity extends AppCompatActivity {
    TextView tvPackageName,tvTotal;
    EditText edDetails;
    Button btnAddToCart,btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine_details);
        tvPackageName = findViewById(R.id.textViewBMDPackageName);
        tvTotal = findViewById(R.id.textViewTotalCostBMD);
        edDetails = findViewById(R.id.editTextMultiLineBMD);
        btnAddToCart = findViewById(R.id.buttonBMDAddToCart);
        btnBack = findViewById(R.id.buttonBMDBackDT);
        edDetails.setKeyListener(null);
        Intent intent = getIntent();
        tvPackageName.setText(intent.getStringExtra("text1"));
        edDetails.setText(intent.getStringExtra("text2"));
        tvTotal.setText("Tổng tiền: " + intent.getStringExtra("text3"));
        btnBack.setOnClickListener(v -> {
            Intent intent1 = new Intent(BuyMedicineDetailsActivity.this, BuyMedicineActivity.class);
            startActivity(intent1);
        });
        btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sp = getSharedPreferences("share_prefs", Context.MODE_PRIVATE);
                String username = sp.getString("username", "").toString();
                String product = tvPackageName.getText().toString();
                Float price = Float.parseFloat(intent.getStringExtra("text3").toString());
                Database db = new Database(getApplicationContext(), "HealthCare", null, 1);
                if (db.checkCart(username, product) == 1) {
                    Toast.makeText(getApplicationContext(), "Đã có trong giỏ hàng", Toast.LENGTH_SHORT).show();
                } else {
                    db.addCart(username, product, price,"medicine");
                    Toast.makeText(getApplicationContext(), "Đã thêm vào giỏ hàng", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(BuyMedicineDetailsActivity.this, BuyMedicineActivity.class));
                }
            }
        });
    }
}