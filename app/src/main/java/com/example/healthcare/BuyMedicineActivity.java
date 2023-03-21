package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class BuyMedicineActivity extends AppCompatActivity {
    private String[][] packages={
            {"Vitamin B Complex Capsules","","","","500"},
            {"Vitamin C Tablets","","","","283"},
            {"Vitamin D3 Tablets","","","","190"},
            {"Vitamin E Capsules","","","","250"},
            {"Vitamin K Tablets","","","","300"},
            {"Vitamin B12 Tablets","","","","350"},
    };
    private String[] package_details = {
            "Building and keeping the bones & teeth strong\n" + "Reducing Fatigue/stress and muscular pains\n" +

                    "Boosting immunity and increasing resistance against infection",

            "Chromium is an essential trace mineral that plays an important role in helping insulin regular",
            "Provides relief from vitamin B deficiencies\n" +
                    "Helps in formation of red blood cellsin\n" +
                    "Maintains healthy nervous systen\n",
            "It promotes health as well as skin benefits\n" +
                    "It helps reduce skin blemish and pigmentation.\n" + "It act as safeguard the skin from the harsh UVA and UVB sun rays",
            "Pole 650 Tablet helps relieve pain and fever by blocking the release of certain chemical messengers in the brain\n" +
                    "Helps relieve fever and bring down a high temperature\n" +
                    "Suitable for people with a heart condition or high blood pressure",
            "Relieves the symptoms of a bacterial throat infection and soothes the recovery processin\n" +
                    "Provides a warm and conforting feeling during sore throat",
            "Reduces the risk of calcium deficiency, Rickets, and Osteoporosis\n" +
                    "Pronates mobility and flexibility of joints",
            "Helps to reduce the iron deficiency due to chronic blood loss or low intake of iren",
    };
    HashMap<String, String> item;
    ArrayList list;
    SimpleAdapter adapter;
    ListView lv;
    Button btnGoToCart, btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine);
        lv = findViewById(R.id.idlstBuyMedicine);
        btnGoToCart = findViewById(R.id.buttonBMCGoToCart);
        btnBack = findViewById(R.id.buttonBMDBack);
        btnGoToCart.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), CartBuyMedicineActivity.class);
            startActivity(intent);
        });
        btnBack.setOnClickListener(v -> {
            Intent intent = new Intent(BuyMedicineActivity.this, HomeActivity.class);
            startActivity(intent);
        });
        list = new ArrayList();
        for(int i=0;i<packages.length;i++){
            item = new HashMap<String,String>();
            item.put("line1",packages[i][0]);
            item.put("line2",packages[i][1]);
            item.put("line3",packages[i][2]);
            item.put("line4",packages[i][3]);
            item.put("line5","Total Price: "+packages[i][4]+"/-");
            list.add(item);
        }
        adapter = new SimpleAdapter(this,list,R.layout.multi_lines,new String[]{"line1","line2","line3","line4","line5"},new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Intent intent = new Intent(BuyMedicineActivity.this, BuyMedicineDetailsActivity.class);
                intent.putExtra("text1",packages[i][0]);
                intent.putExtra("text2",package_details[i]);
                intent.putExtra("text3",packages[i][4]);
                startActivity(intent);
            }
        });
    }
}