package com.example.healthcare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class OrderDetailsActivity extends AppCompatActivity {
    private String[][] order_details = {};
    HashMap<String, String> item;
    ArrayList list;
    SimpleAdapter sa;
    ListView listView;
    Button btnBack;
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.menucontext, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.mnuDel:
                //xoa du lieu theo ten
                AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
                int pos = info.position;
                String name = order_details[pos][0];
                Database db = new Database(getApplicationContext(), "HealthCare", null, 1);
                db.deleteOrder(name);
                startActivity(new Intent(OrderDetailsActivity.this, OrderDetailsActivity.class));
                break;
            default:
                break;

        }
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);
        btnBack = findViewById(R.id.btnODBack);
        listView = findViewById(R.id.lstViewOD);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OrderDetailsActivity.this, HomeActivity.class));
            }
        });
        Database db = new Database(getApplicationContext(), "HealthCare", null, 1);
        SharedPreferences sp = getSharedPreferences("share_prefs", Context.MODE_PRIVATE);
        String username = sp.getString("username", "").toString();
        ArrayList dbData = db.getOrderData(username);
        order_details = new String[dbData.size()][];
        for (int i = 0; i < order_details.length; i++) {
            order_details[i] = new String[5];
            String arrData = dbData.get(i).toString();
            String[] strData = arrData.split(java.util.regex.Pattern.quote("$"));
            order_details[i][0] = strData[0];
            order_details[i][1] = strData[1];
            if (strData[7].compareTo("medicine") == 0) {
                order_details[i][3] = "Del: " + strData[4];
            } else {
                order_details[i][3] = "Del: " + strData[4] + " " + strData[5];
            }
            order_details[i][2] = "Rs." + strData[6];
            order_details[i][4] = strData[7];
        }
        list = new ArrayList();
        for (int i = 0; i < order_details.length; i++) {
            item = new HashMap<String, String>();
            item.put("line1", order_details[i][0]);
            item.put("line2", order_details[i][1]);
            item.put("line3", order_details[i][2]);
            item.put("line4", order_details[i][3]);
            item.put("line5", order_details[i][4]);
            list.add(item);
        }
        sa = new SimpleAdapter(this, list, R.layout.multi_lines, new String[]{"line1", "line2", "line3", "line4", "line5"}, new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e});
        listView.setAdapter(sa);
        registerForContextMenu(listView);
    }
}