package com.giang.quanlyluong.manager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.giang.quanlyluong.R;
import com.giang.quanlyluong.staff.MonthStaff;

public class DetailWageMonthStaffInMangerActivity extends AppCompatActivity {
    TextView txtSoBuoiLam;
    TextView txtLuongTheoThang;
    TextView txtTienThuong;
    TextView txtTienPhat;
    TextView txtLuongThucTe;
    TextView textViewViTri;
    TextView textViewHoVaTen;
    ImageView imgBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_wage_month_staff_in_manger);

        Staff staff = (Staff) getIntent().getSerializableExtra("duLieuNhanVien");

        textViewViTri = findViewById(R.id.textViewViTri);
        textViewHoVaTen = findViewById(R.id.textViewHoVaTen);
        txtSoBuoiLam = findViewById(R.id.txtSoBuoiLam);
        txtLuongTheoThang = findViewById(R.id.txtLuongTheoThang);
        txtTienThuong = findViewById(R.id.txtTienThuong);
        txtTienPhat = findViewById(R.id.txtTienPhat);
        txtLuongThucTe = findViewById(R.id.txtLuongThucTe);
        imgBack = findViewById(R.id.imgBackWageStaffDetailsManager);

//                int position = month.getId();
        textViewHoVaTen.setText("" + staff.getHoTen());
        textViewViTri.setText("" + staff.getViTri());
        txtSoBuoiLam.setText("" + staff.getSoBuoiLam());
        txtLuongTheoThang.setText("" + staff.getLuongTheoThang());
        txtTienThuong.setText("" + staff.getTienThuong());
        txtTienPhat.setText("" + staff.getTienPhat());
        txtLuongThucTe.setText("" + staff.getLuongThucTra());

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
