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
            "Giảm nguy cơ đột quỵ do vitamin B có liên quan đến quá trình tạo máu và sự phát triển của tế bào.\n" +
                    "Ngăn chặn bệnh tê phù beriberi do thiếu vitamin B1 gây nên.\n" +
                    "Giúp tăng cường hệ miễn dịch của cơ thể.\n" +
                    "Tham gia chuyển hóa, cung cấp năng lượng cho các hoạt động của cơ thể.",

            "Phòng và điều trị bệnh do thiếu vitamin này (bệnh scorbut).\n" +
                    "Tăng sức đề kháng của cơ thể để chống lại bệnh nhiễm khuẩn, nhiễm độc, mau lành vết thương.\n" +
                    "Điều trị mệt mỏi do cảm cúm hoặc sau khi ốm.\n" +
                    "Axit hóa nước tiểu để giải độc trong một số trường hợp.",

            "Vitamin D3 thường được sử dụng để điều trị hoặc ngăn ngừa tình trạng do thiếu vitamin D, đặc biệt là tình trạng về da hoặc xương. \n" +
                    "Loại vitamin này tốt các loại vitamin D khác và làm tăng nồng độ vitamin D trong máu cao hơn vitamin D2.",


            "Vitamin E giúp làn da mịn màng, tươi trẻ, hạn chế nếp nhăn. \n" +
                    "Tình trạng da khô sạm, nhăn nheo, thiếu sức sống, tóc khô và dễ gãy rụng thường là do thiếu vitamin E gây nên. \n" +
                    "Do đó, trong hầu hết các sản phẩm chăm sóc da và tóc, nhà sản xuất thường đưa vitamin E vào trong thành phần.",

            "Ngăn ngừa những vấn đề đông máu ở trẻ sơ sinh bị thiếu hụt vitamin K\n" +
                    "Điều trị xuất huyết do các thuốc như salicylate, sulfonamide, quinine, quinidine hoặc kháng sinh\n" +
                    "Điều trị và ngăn ngừa thiếu hụt vitamin K\n" +
                    "Ngăn ngừa và điều trị yếu xương và giảm triệu chứng ngứa trong bệnh xơ gan mật\n" +
                    "Uống vitamin K2 (menaquinone) để trị loãng xương, mất xương do sử dụng steroids cũng như hạ cholesterol máu ở những người lọc máu\n" +
                    "Thoa lên da để loại bỏ tĩnh mạch mạng nhện, vết bầm tím, vết sẹo, vết rạn da và bỏng",

            "Vitamin B12 đóng một vai trò quan trọng trong việc giúp cơ thể sản xuất các tế bào hồng cầu. Thiếu vitamin B12 gây ra giảm sự hình thành tế bào hồng cầu.\n" +
                    "\n" +
                    "Các tế bào hồng cầu khỏe mạnh có hình tròn và nhỏ, khi thiếu vitamin B12 chúng trở nên lớn hơn và thường có hình bầu dục. Do hình dạng lớn hơn và bất thường này, các tế bào hồng cầu không thể di chuyển từ tủy xương vào máu với tốc độ thích hợp, gây ra bệnh thiếu máu nguyên bào khổng lồ (thiếu máu hồng cầu to).",
            "Relieves the symptoms of a bacterial throat infection and soothes the recovery processin\n" +
                    "Provides a warm and conforting feeling during sore throat",

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
            item.put("line5","Giá Tiền: "+packages[i][4]+"/-");
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