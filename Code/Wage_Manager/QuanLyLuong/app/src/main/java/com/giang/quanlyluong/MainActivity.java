package com.giang.quanlyluong;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.giang.quanlyluong.manager.WageMonthlyManagerActivity;
import com.giang.quanlyluong.staff.WageMonthlyStaffActivity;

public class MainActivity extends AppCompatActivity {

    Button btnNhanVien;
    Button btnQuanLy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNhanVien = findViewById(R.id.btnNhanVien);
        btnQuanLy = findViewById(R.id.btnQuanLy);

        btnNhanVien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), WageMonthlyStaffActivity.class));
            }
        });

        btnQuanLy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), WageMonthlyManagerActivity.class));
            }
        });
    }
}
