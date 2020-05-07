package com.giang.quanlyluong.manager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.giang.quanlyluong.R;

import java.util.ArrayList;

public class WageMonthlyManagerActivity extends AppCompatActivity {

    ArrayList<MonthManager> monthManagers;
    RecyclerView recyclerMonth;
    MonthListAdapterManager monthListAdapterManager;

    ArrayList<Staff> staffs;
    RecyclerView recyclerStaff;
    RecyclerView recyclerViewQuanLyNhanVienLuong;
    RecyclerView recyclerViewQuanLyNhanVienPhat;
    RecyclerView recyclerViewQuanLyNhanVienThuong;
    StaffListAdapter staffListAdapter;
    StaffListAdapterSetSalary staffListAdapterSetSalary;
    StaffListAdapterSetFine staffListAdapterSetFine;
    StaffListAdapterSetBonus staffListAdapterSetBonus;

    TextView txtHangThang, txtThietLapLuong;
    LinearLayout linearHangThang;
    LinearLayout linearListStaff;
    FrameLayout frameThietlapLuong;

    LinearLayout linearQuanLyNhanVienLuong;
    LinearLayout linearQuanLyNhanVienPhat;
    LinearLayout linearQuanLyNhanVienThuong;

    TextView txtThuong, txtPhat, txtLuong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wage_monthly_manager);

        //getting the toolbar
        Toolbar toolbar =  findViewById(R.id.toolBar);
        //setting the title
        toolbar.setTitle(" ");
        //placing toolbar in place of actionbar
        setSupportActionBar(toolbar);
        getSupportActionBar().setIcon(R.drawable.ic_menu_black_24dp);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        txtHangThang = findViewById(R.id.txtHangThang);
        txtThietLapLuong = findViewById(R.id.txtThietLapLuong);
        linearHangThang = findViewById(R.id.linearHangThang);
        linearListStaff = findViewById(R.id.linearListStaff);

        recyclerMonth = findViewById(R.id.recMonthManager);
        recyclerStaff = findViewById(R.id.recyclerViewStaff);
        recyclerViewQuanLyNhanVienLuong = findViewById(R.id.recyclerViewQuanLyNhanVienLuong);
        recyclerViewQuanLyNhanVienPhat = findViewById(R.id.recyclerViewQuanLyNhanVienPhat);
        recyclerViewQuanLyNhanVienThuong = findViewById(R.id.recyclerViewQuanLyNhanVienThuong);
        linearHangThang = findViewById(R.id.linearHangThang);
        frameThietlapLuong = findViewById(R.id.frameThietlapLuong);

        txtThuong = findViewById(R.id.txtThuong);
        txtPhat = findViewById(R.id.txtPhat);
        txtLuong = findViewById(R.id.txtLuong);

        linearQuanLyNhanVienThuong = findViewById(R.id.linearQuanLyNhanVienThuong);
        linearQuanLyNhanVienPhat = findViewById(R.id.linearQuanLyNhanVienPhat);
        linearQuanLyNhanVienLuong = findViewById(R.id.linearQuanLyNhanVienLuong);

        // set list staff
        staffs = new ArrayList<>();

        // int id, String hoTen, String viTri, int soBuoiLam, int luongTheoThang, int tienThuong, int tienPhat, int luongThucTra
        staffs.add(new Staff(1, "Huyen Nguyen", "Quan ly", 26,1000,0, 0, 1000));
        staffs.add(new Staff(2, "Pham Thuy Tien", "Thu Quy", 25,1000,0, 100, 900));
        staffs.add(new Staff(3, "Nguyen Truong Giang", "Ban Hang", 27,1000,100, 0, 1100));
        staffs.add(new Staff(4, "Do Tri Kien", "Giu Xe", 26,1000,100, 100, 1000));
        staffs.add(new Staff(5, "Nguyen Van Duc", "Giu Xe", 26,1000,300, 100, 1200));

        staffListAdapter = new StaffListAdapter(this, staffs);
        recyclerStaff.setAdapter(staffListAdapter);
        recyclerStaff.setLayoutManager(new LinearLayoutManager(this));

        staffListAdapterSetBonus = new StaffListAdapterSetBonus(this, staffs);
        recyclerViewQuanLyNhanVienThuong.setAdapter(staffListAdapterSetBonus);
        recyclerViewQuanLyNhanVienThuong.setLayoutManager(new LinearLayoutManager(this));

        staffListAdapterSetFine = new StaffListAdapterSetFine(this, staffs);
        recyclerViewQuanLyNhanVienPhat.setAdapter(staffListAdapterSetFine);
        recyclerViewQuanLyNhanVienPhat.setLayoutManager(new LinearLayoutManager(this));

        staffListAdapterSetSalary = new StaffListAdapterSetSalary(this, staffs);
        recyclerViewQuanLyNhanVienLuong.setAdapter(staffListAdapterSetSalary);
        recyclerViewQuanLyNhanVienLuong.setLayoutManager(new LinearLayoutManager(this));



        //set list months
        recyclerMonth = findViewById(R.id.recMonthManager);
        monthManagers = new ArrayList<>();

        int tongLuong = 0;
        for(Staff s : staffs){
            tongLuong += s.getLuongThucTra();
        }

        monthManagers.add(new MonthManager(1, tongLuong));
        monthManagers.add(new MonthManager(2, tongLuong));
        monthManagers.add(new MonthManager(3, tongLuong));
        monthManagers.add(new MonthManager(4, 0));
        monthManagers.add(new MonthManager(5, 0));
        monthManagers.add(new MonthManager(6, 0));
        monthManagers.add(new MonthManager(7, 0));
        monthManagers.add(new MonthManager(8, 0));
        monthManagers.add(new MonthManager(9, 0));
        monthManagers.add(new MonthManager(10, 0));
        monthManagers.add(new MonthManager(11, 0));
        monthManagers.add(new MonthManager(12, 0));

        monthListAdapterManager = new MonthListAdapterManager(this, monthManagers);
        recyclerMonth.setAdapter(monthListAdapterManager);
        recyclerMonth.setLayoutManager(new LinearLayoutManager(this));
        monthListAdapterManager.setID(linearListStaff, recyclerMonth);

        recyclerMonth.setVisibility(View.VISIBLE);
        linearHangThang.setVisibility(View.VISIBLE);
        linearListStaff.setVisibility(View.GONE);
        frameThietlapLuong.setVisibility(View.GONE);

        txtHangThang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerMonth.setVisibility(View.VISIBLE);
                linearHangThang.setVisibility(View.VISIBLE);
                linearListStaff.setVisibility(View.GONE);
                frameThietlapLuong.setVisibility(View.GONE);

                txtHangThang.setBackgroundColor(getResources().getColor(R.color.lightGreen));
                txtHangThang.setTextColor(getResources().getColor(R.color.white));

                txtThietLapLuong.setBackgroundColor(getResources().getColor(R.color.silver));
                txtThietLapLuong.setTextColor(getResources().getColor(R.color.black));

                monthListAdapterManager.clearAllRecyclerView();

                int tongLuong = 0;
                for(Staff s : staffs){
                    tongLuong += s.getLuongThucTra();
                }

                monthManagers.add(new MonthManager(1, tongLuong));
                monthManagers.add(new MonthManager(2, tongLuong));
                monthManagers.add(new MonthManager(3, tongLuong));
                monthManagers.add(new MonthManager(4, 0));
                monthManagers.add(new MonthManager(5, 0));
                monthManagers.add(new MonthManager(6, 0));
                monthManagers.add(new MonthManager(7, 0));
                monthManagers.add(new MonthManager(8, 0));
                monthManagers.add(new MonthManager(9, 0));
                monthManagers.add(new MonthManager(10, 0));
                monthManagers.add(new MonthManager(11, 0));
                monthManagers.add(new MonthManager(12, 0));

                monthListAdapterManager = new MonthListAdapterManager(getBaseContext(), monthManagers);
                recyclerMonth.setAdapter(monthListAdapterManager);
                recyclerMonth.setLayoutManager(new LinearLayoutManager(getBaseContext()));
                monthListAdapterManager.setID(linearListStaff, recyclerMonth);

            }
        });

        txtThietLapLuong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearHangThang.setVisibility(View.GONE);
                frameThietlapLuong.setVisibility(View.VISIBLE);

                txtThietLapLuong.setBackgroundColor(getResources().getColor(R.color.lightGreen));
                txtThietLapLuong.setTextColor(getResources().getColor(R.color.white));

                txtHangThang.setBackgroundColor(getResources().getColor(R.color.silver));
                txtHangThang.setTextColor(getResources().getColor(R.color.black));
            }
        });

        linearQuanLyNhanVienThuong.setVisibility(View.VISIBLE);
        linearQuanLyNhanVienPhat.setVisibility(View.GONE);
        linearQuanLyNhanVienLuong.setVisibility(View.GONE);

        txtThuong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtThuong.setBackgroundColor(getResources().getColor(R.color.lightGreen));
                txtThuong.setTextColor(getResources().getColor(R.color.white));

                txtPhat.setBackgroundColor(getResources().getColor(R.color.silver));
                txtPhat.setTextColor(getResources().getColor(R.color.black));

                txtLuong.setBackgroundColor(getResources().getColor(R.color.silver));
                txtLuong.setTextColor(getResources().getColor(R.color.black));

                linearQuanLyNhanVienThuong.setVisibility(View.VISIBLE);
                linearQuanLyNhanVienPhat.setVisibility(View.GONE);
                linearQuanLyNhanVienLuong.setVisibility(View.GONE);
            }
        });

        txtPhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtPhat.setBackgroundColor(getResources().getColor(R.color.lightGreen));
                txtPhat.setTextColor(getResources().getColor(R.color.white));

                txtThuong.setBackgroundColor(getResources().getColor(R.color.silver));
                txtThuong.setTextColor(getResources().getColor(R.color.black));

                txtLuong.setBackgroundColor(getResources().getColor(R.color.silver));
                txtLuong.setTextColor(getResources().getColor(R.color.black));

                linearQuanLyNhanVienThuong.setVisibility(View.GONE);
                linearQuanLyNhanVienPhat.setVisibility(View.VISIBLE);
                linearQuanLyNhanVienLuong.setVisibility(View.GONE);
            }
        });

        txtLuong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtLuong.setBackgroundColor(getResources().getColor(R.color.lightGreen));
                txtLuong.setTextColor(getResources().getColor(R.color.white));

                txtPhat.setBackgroundColor(getResources().getColor(R.color.silver));
                txtPhat.setTextColor(getResources().getColor(R.color.black));

                txtThuong.setBackgroundColor(getResources().getColor(R.color.silver));
                txtThuong.setTextColor(getResources().getColor(R.color.black));

                linearQuanLyNhanVienThuong.setVisibility(View.GONE);
                linearQuanLyNhanVienPhat.setVisibility(View.GONE);
                linearQuanLyNhanVienLuong.setVisibility(View.VISIBLE);
            }
        });


        EditText edtTimKiemChiTietNhanVien = findViewById(R.id.edtTimKiemChiTietNhanVien);
        edtTimKiemChiTietNhanVien.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                //after the change calling the method and passing the search input
                filterChiTietNhanVien(editable.toString());
            }
        });

        EditText edtTimKiemCaiDatNhanVienThuong = findViewById(R.id.edtTimKiemCaiDatNhanVienThuong);
        edtTimKiemCaiDatNhanVienThuong.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                //after the change calling the method and passing the search input
                filterNhanVienThuong(editable.toString());
            }
        });

        EditText edtTimKiemCaiDatNhanVienPhat = findViewById(R.id.edtTimKiemCaiDatNhanVienPhat);
        edtTimKiemCaiDatNhanVienPhat.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                //after the change calling the method and passing the search input
                filterNhanVienPhat(editable.toString());
            }
        });


        EditText edtTimKiemCaiDatNhanVienLuong = findViewById(R.id.edtTimKiemCaiDatNhanVienLuong);
        edtTimKiemCaiDatNhanVienLuong.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                //after the change calling the method and passing the search input
                filterNhanVienLuong(editable.toString());
            }
        });

    }

    private void filterChiTietNhanVien(String text) {
        //new array list that will hold the filtered data
        ArrayList<Staff> filterdNames = new ArrayList<>();

        //looping through existing elements
        for (Staff s : staffs) {
            //if the existing elements contains the search input
            if (s.getViTri().toLowerCase().contains(text.toLowerCase())) {
                //adding the element to filtered list
                filterdNames.add(s);
            }
        }

        //calling a method of the adapter class and passing the filtered list
        staffListAdapter.filterList(filterdNames);
    }

    private void filterNhanVienThuong(String text) {
        //new array list that will hold the filtered data
        ArrayList<Staff> filterdNames = new ArrayList<>();

        //looping through existing elements
        for (Staff s : staffs) {
            //if the existing elements contains the search input
            if (s.getViTri().toLowerCase().contains(text.toLowerCase())) {
                //adding the element to filtered list
                filterdNames.add(s);
            }
        }

        //calling a method of the adapter class and passing the filtered list
        staffListAdapterSetBonus.filterList(filterdNames);
    }

    private void filterNhanVienPhat(String text) {
        //new array list that will hold the filtered data
        ArrayList<Staff> filterdNames = new ArrayList<>();

        //looping through existing elements
        for (Staff s : staffs) {
            //if the existing elements contains the search input
            if (s.getViTri().toLowerCase().contains(text.toLowerCase())) {
                //adding the element to filtered list
                filterdNames.add(s);
            }
        }

        //calling a method of the adapter class and passing the filtered list
        staffListAdapterSetFine.filterList(filterdNames);
    }

    private void filterNhanVienLuong(String text) {
        //new array list that will hold the filtered data
        ArrayList<Staff> filterdNames = new ArrayList<>();

        //looping through existing elements
        for (Staff s : staffs) {
            //if the existing elements contains the search input
            if (s.getViTri().toLowerCase().contains(text.toLowerCase())) {
                //adding the element to filtered list
                filterdNames.add(s);
            }
        }

        //calling a method of the adapter class and passing the filtered list
        staffListAdapterSetSalary.filterList(filterdNames);
    }

}
