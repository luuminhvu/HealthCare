package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class InformationAppActivity extends AppCompatActivity {
    Button btnBack;
    ImageView img;
    TextView tv;
    EditText tvInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_app);
        btnBack = findViewById(R.id.buttonInfoAppBack);
        img = findViewById(R.id.imgViewContact);
        tv = findViewById(R.id.tvEmailContact);
        tvInfo = findViewById(R.id.edTextInfoApp);
        tvInfo.setKeyListener(null);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(InformationAppActivity.this, LoginActivity.class));
            }
        });
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"devteam13@gmail.com"}); // recipients
                intent.putExtra(Intent.EXTRA_SUBJECT, "Feedback");
                intent.putExtra(Intent.EXTRA_TEXT, "Phản Hồi");
                startActivity(Intent.createChooser(intent, "Send Email"));
                finish();
            }
        });
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"devteam13@gmail.com"}); // recipients
                intent.putExtra(Intent.EXTRA_SUBJECT, "Feedback");
                intent.putExtra(Intent.EXTRA_TEXT, "Phản Hồi");
                startActivity(Intent.createChooser(intent, "Send Email"));
            }
        });
    }
}