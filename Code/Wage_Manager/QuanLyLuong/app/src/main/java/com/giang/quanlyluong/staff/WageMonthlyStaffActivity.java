package com.giang.quanlyluong.staff;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.giang.quanlyluong.R;

import java.util.ArrayList;

public class WageMonthlyStaffActivity extends AppCompatActivity {

    ArrayList<MonthStaff> monthStaffs;
    RecyclerView recyclerMonth;
    MonthListAdapterStaff MonthAdapter ;
    ImageView imgBack ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wage_monthly_staff);

        //set list months
        recyclerMonth = findViewById(R.id.recMonthStaff);
        monthStaffs = new ArrayList<>();

        monthStaffs.add(new MonthStaff(1, 26, 1000, 0, 0, 1000));
        monthStaffs.add(new MonthStaff(2, 25, 1000, 0, 0, 1000));
        monthStaffs.add(new MonthStaff(3, 27, 1000, 0, 0, 1000));
        monthStaffs.add(new MonthStaff(4, 0, 0,0,0,0));
        monthStaffs.add(new MonthStaff(5, 0, 0,0,0,0));
        monthStaffs.add(new MonthStaff(6, 0, 0,0,0,0));
        monthStaffs.add(new MonthStaff(7, 0, 0,0,0,0));
        monthStaffs.add(new MonthStaff(8, 0, 0,0,0,0));
        monthStaffs.add(new MonthStaff(9, 0, 0,0,0,0));
        monthStaffs.add(new MonthStaff(10, 0, 0,0,0,0));
        monthStaffs.add(new MonthStaff(11, 0, 0,0,0,0));
        monthStaffs.add(new MonthStaff(12, 0, 0,0,0,0));

        MonthAdapter = new MonthListAdapterStaff(this, monthStaffs);
        recyclerMonth.setAdapter(MonthAdapter);
        recyclerMonth.setLayoutManager(new LinearLayoutManager(this));

        imgBack = findViewById(R.id.imgBackWageStaff);

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
