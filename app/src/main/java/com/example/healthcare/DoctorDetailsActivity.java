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
            {"Tên Bác Sĩ:Dr. Hoàng Gia Du","Địa Chỉ: Đống Đa, Hà Nội","Exp :10 năm","Số Điện Thoại: 0382108926","600"},
            {"Tên Bác Sĩ:Dr. Đào Xuân Thành","Địa Chỉ: Đông Anh, Hà Nôi","Exp :8 năm","Số Điện Thoại: 0967094928","500"},
            {"Tên Bác Sĩ:Dr. Nguyễn Thế Hào","Địa Chỉ: Thanh Xuân, Hà Nội","Exp :9 năm","Số Điện Thoại:  090443003","400"},
            {"Tên Bác Sĩ:Dr. Vũ Thế Xuân","Địa Chỉ: Long Biên, Hà Nội","Exp :12 năm","Số Điện Thoại: 0932781567","700"},
            {"Tên Bác Sĩ:Dr. Chử Xuân Tùng","Địa Chỉ: Gia Lâm, Hà Nội","Exp :6 năm","Số Điện Thoại: 0978729742","450"},
            {"Tên Bác Sĩ:Dr. Phùng Xuân Nhạn","Địa Chỉ: Hoàn Kiếm, Hà Nội  ","Exp :11 năm","Số Điện Thoại: 0967224743","600"}
    };
    private String[][] doctors_details2 ={
            {"Tên Bác Sĩ:Dr. Nguyễn Xuân Hùng","Địa Chỉ: Đông Anh, Hà Nôi","Exp :8 năm","Số Điện Thoại: 0967094928","500"},
            {"Tên Bác Sĩ:Dr. Phạm Hoàng Hà","Địa Chỉ: Gia Lâm, Hà Nội","Exp :6 năm","Số Điện Thoại: 0978729742","450"},
            {"Tên Bác Sĩ:Dr. Đỗ Mai Lâm","Địa Chỉ: Đống Đa, Hà Nội","Exp :6 năm","Số Điện Thoại: 0978729742","450"},
            {"Tên Bác Sĩ:Dr. Tống Quang Hiếu","Địa Chỉ: Thanh Xuân, Hà Nội","Exp :9 năm","Số Điện Thoại:  090443003","400"},
            {"Tên Bác Sĩ:Dr. Vũ Đức Thịnh","Địa Chỉ: Long Biên, Hà Nội","Exp :12 năm","Số Điện Thoại: 0932781567","700"},
            {"Tên Bác Sĩ:Dr. Phạm Hiếu Tâm","Địa Chỉ: Hoàn Kiếm, Hà Nội  ","Exp :11 năm","Số Điện Thoại: 0967224743","600"}
    };
    private String[][] doctors_details3 ={
            {"Tên Bác Sĩ:Dr. Nguyễn Trung Đức","Địa Chỉ: Hà Đông, Hà Nội","Exp :11 năm","Số Điện Thoại: 0333224321","300"},
            {"Tên Bác Sĩ:Dr. Phạm Minh Tuấn","Địa Chỉ: Sơn Tây, Hà Nội","Exp :10 năm","Số Điện Thoại: 012322234","400"},
            {"Tên Bác Sĩ:Dr. Lưu Văn Vũ","Địa Chỉ: Từ Sơn, Bắc Ninh","Exp :7 năm","Số Điện Thoại: 0987678984","500"},
            {"Tên Bác Sĩ:Dr. Lê Phú Minh","Địa Chỉ: Long Biên, Hà Nội","Exp :8 năm","Số Điện Thoại: 0987766455","200"},
            {"Tên Bác Sĩ:Dr. Ngô Văn Anh","Địa Chỉ: Gia Lâm, Hà Nội","Exp :15 năm","Số Điện Thoại: 0123123123","450"},
            {"Tên Bác Sĩ:Dr. Vương Kiến Quốc","Địa Chỉ: Sóc Sơn, Hà Nội","Exp :13 năm","Số Điện Thoại: 0987232123","700"}
    };
    private String[][] doctors_details4 ={
            {"Tên Bác Sĩ:Dr. Nguyễn Xuân Hùng","Địa Chỉ: Đông Anh, Hà Nôi","Exp :8 năm","Số Điện Thoại: 0967094928","500"},
            {"Tên Bác Sĩ:Dr. Phạm Hoàng Hà","Địa Chỉ: Gia Lâm, Hà Nội","Exp :6 năm","Số Điện Thoại: 0978729742","450"},
            {"Tên Bác Sĩ:Dr. Đỗ Mai Lâm","Địa Chỉ: Đống Đa, Hà Nội","Exp :6 năm","Số Điện Thoại: 0978729742","450"},
            {"Tên Bác Sĩ:Dr. Tống Quang Hiếu","Địa Chỉ: Thanh Xuân, Hà Nội","Exp :9 năm","Số Điện Thoại:  090443003","400"},
            {"Tên Bác Sĩ:Dr. Vũ Đức Thịnh","Địa Chỉ: Long Biên, Hà Nội","Exp :12 năm","Số Điện Thoại: 0932781567","700"},
            {"Tên Bác Sĩ:Dr. Phạm Hiếu Tâm","Địa Chỉ: Hoàn Kiếm, Hà Nội  ","Exp :11 năm","Số Điện Thoại: 0967224743","600"}
    };
    private String[][] doctors_details5 ={
            {"Tên Bác Sĩ:Dr. Hoàng Gia Du","Địa Chỉ: Đống Đa, Hà Nội","Exp :10 năm","Số Điện Thoại: 0382108926","600"},
            {"Tên Bác Sĩ:Dr. Đào Xuân Thành","Địa Chỉ: Đông Anh, Hà Nôi","Exp :8 năm","Số Điện Thoại: 0967094928","500"},
            {"Tên Bác Sĩ:Dr. Nguyễn Thế Hào","Địa Chỉ: Thanh Xuân, Hà Nội","Exp :9 năm","Số Điện Thoại:  090443003","400"},
            {"Tên Bác Sĩ:Dr. Vũ Thế Xuân","Địa Chỉ: Long Biên, Hà Nội","Exp :12 năm","Số Điện Thoại: 0932781567","700"},
            {"Tên Bác Sĩ:Dr. Chử Xuân Tùng","Địa Chỉ: Gia Lâm, Hà Nội","Exp :6 năm","Số Điện Thoại: 0978729742","450"},
            {"Tên Bác Sĩ:Dr. Phùng Xuân Nhạn","Địa Chỉ: Hoàn Kiếm, Hà Nội  ","Exp :11 năm","Số Điện Thoại: 0967224743","600"}
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
            item.put("line5", "Giá tiền:"+doctors_details[i][4]+"$");
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