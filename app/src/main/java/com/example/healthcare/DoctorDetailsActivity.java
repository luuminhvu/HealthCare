package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    private String[][] doctors_details1 ={
            {"Doctor Name:Dr. John With","Hospital Address: 1234 Main Street, New York","Exp :10 years","Mobile Number: 1234567890","600"},
            {"Doctor Name:Dr. Jane Doe","Hospital Address: 1234 Main Street, New York","Exp :10 years","Mobile Number: 1234567890","600"},
            {"Doctor Name:Dr. John Doe","Hospital Address: 1234 Main Street, New York","Exp :10 years","Mobile Number: 1234567890","600"},
            {"Doctor Name:Dr. Jane Doe","Hospital Address: 1234 Main Street, New York","Exp :10 years","Mobile Number: 1234567890","600"},
            {"Doctor Name:Dr. John Doe","Hospital Address: 1234 Main Street, New York","Exp :10 years","Mobile Number: 1234567890","600"},
            {"Doctor Name:Dr. Jane Doe","Hospital Address: 1234 Main Street, New York","Exp :10 years","Mobile Number: 1234567890","600"}
            };
    private String[][] doctors_details2 ={
            {"Doctor Name:Dr. John Doe","Hospital Address: 1234 Main Street, New York","Exp :10 years","Mobile Number: 1234567890","600"},
            {"Doctor Name:Dr. Jane Doe","Hospital Address: 1234 Main Street, New York","Exp :10 years","Mobile Number: 1234567890","600"},
            {"Doctor Name:Dr. John Doe","Hospital Address: 1234 Main Street, New York","Exp :10 years","Mobile Number: 1234567890","600"},
            {"Doctor Name:Dr. Jane Doe","Hospital Address: 1234 Main Street, New York","Exp :10 years","Mobile Number: 1234567890","600"},
            {"Doctor Name:Dr. John Doe","Hospital Address: 1234 Main Street, New York","Exp :10 years","Mobile Number: 1234567890","600"},
            {"Doctor Name:Dr. Jane Doe","Hospital Address: 1234 Main Street, New York","Exp :10 years","Mobile Number: 1234567890","600"}
    };
    private String[][] doctors_details3 ={
            {"Doctor Name:Dr. John Doe","Hospital Address: 1234 Main Street, New York","Exp :10 years","Mobile Number: 1234567890","600"},
            {"Doctor Name:Dr. Jane Doe","Hospital Address: 1234 Main Street, New York","Exp :10 years","Mobile Number: 1234567890","600"},
            {"Doctor Name:Dr. John Doe","Hospital Address: 1234 Main Street, New York","Exp :10 years","Mobile Number: 1234567890","600"},
            {"Doctor Name:Dr. Jane Doe","Hospital Address: 1234 Main Street, New York","Exp :10 years","Mobile Number: 1234567890","600"},
            {"Doctor Name:Dr. John Doe","Hospital Address: 1234 Main Street, New York","Exp :10 years","Mobile Number: 1234567890","600"},
            {"Doctor Name:Dr. Jane Doe","Hospital Address: 1234 Main Street, New York","Exp :10 years","Mobile Number: 1234567890","600"}
    };
    private String[][] doctors_details4 ={
            {"Doctor Name:Dr. John Doe","Hospital Address: 1234 Main Street, New York","Exp :10 years","Mobile Number: 1234567890","600"},
            {"Doctor Name:Dr. Jane Doe","Hospital Address: 1234 Main Street, New York","Exp :10 years","Mobile Number: 1234567890","600"},
            {"Doctor Name:Dr. John Doe","Hospital Address: 1234 Main Street, New York","Exp :10 years","Mobile Number: 1234567890","600"},
            {"Doctor Name:Dr. Jane Doe","Hospital Address: 1234 Main Street, New York","Exp :10 years","Mobile Number: 1234567890","600"},
            {"Doctor Name:Dr. John Doe","Hospital Address: 1234 Main Street, New York","Exp :10 years","Mobile Number: 1234567890","600"},
            {"Doctor Name:Dr. Jane Doe","Hospital Address: 1234 Main Street, New York","Exp :10 years","Mobile Number: 1234567890","600"}
    };
    private String[][] doctors_details5 ={
            {"Doctor Name:Dr. John Doe","Hospital Address: 1234 Main Street, New York","Exp :10 years","Mobile Number: 1234567890","600"},
            {"Doctor Name:Dr. Jane Doe","Hospital Address: 1234 Main Street, New York","Exp :10 years","Mobile Number: 1234567890","600"},
            {"Doctor Name:Dr. John Doe","Hospital Address: 1234 Main Street, New York","Exp :10 years","Mobile Number: 1234567890","600"},
            {"Doctor Name:Dr. Jane Doe","Hospital Address: 1234 Main Street, New York","Exp :10 years","Mobile Number: 1234567890","600"},
            {"Doctor Name:Dr. John Doe","Hospital Address: 1234 Main Street, New York","Exp :10 years","Mobile Number: 1234567890","600"},
            {"Doctor Name:Dr. Jane Doe","Hospital Address: 1234 Main Street, New York","Exp :10 years","Mobile Number: 1234567890","600"}
    };
    TextView txtTitle;
    Button btnBack;
    String[][] doctors_details ={};
    ArrayList list;
    HashMap<String,String> item;
    SimpleAdapter sa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);
        txtTitle = findViewById(R.id.DDTitle);
        btnBack = findViewById(R.id.btnBack);
        Intent it = getIntent();
        String title = it.getStringExtra("title");
        txtTitle.setText(title);
        if(title.compareTo("Family Physician")==0)
            doctors_details = doctors_details1;
        else if(title.compareTo("Dietician")==0)
            doctors_details = doctors_details2;
        else if(title.compareTo("Dentist")==0)
            doctors_details = doctors_details3;
        else if(title.compareTo("Surgeon")==0)
            doctors_details = doctors_details4;
        else
            doctors_details = doctors_details5;
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this, FindDoctorActivity.class));
            }
        });
        list = new ArrayList();
        for(int i=0;i<doctors_details.length;i++) {
            item = new HashMap<String, String>();
            item.put("line1", doctors_details[i][0]);
            item.put("line2", doctors_details[i][1]);
            item.put("line3", doctors_details[i][2]);
            item.put("line4", doctors_details[i][3]);
            item.put("line5", "Cons Fee:"+doctors_details[i][4]+"/-");
            list.add(item);
        }
        sa=new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
        );
        ListView lst = findViewById(R.id.lstViewDocDetails);
        lst.setAdapter(sa);
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(DoctorDetailsActivity.this, BookingAppointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctors_details[i][0]);
                it.putExtra("text3",doctors_details[i][1]);
                it.putExtra("text4",doctors_details[i][3]);
                it.putExtra("text5",doctors_details[i][4]);
                startActivity(it);
            }
        });
    }
}