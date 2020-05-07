package com.giang.quanlyluong.staff;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.giang.quanlyluong.R;

public class DetailWageMonthlyStaffActivity extends AppCompatActivity {

    ImageView imgBack;
    TextView txtSoBuoiLam;
    TextView txtLuongTheoThang;
    TextView txtTienThuong;
    TextView txtTienPhat;
    TextView txtLuongThucTe;
    TextView textViewViTri;
    TextView textViewHoVaTen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_wage_monthly_staff);

        MonthStaff monthStaff = (MonthStaff)getIntent().getSerializableExtra("duLieuThang");

//        textViewViTri = findViewById(R.id.textViewViTri);
//        textViewHoVaTen = findViewById(R.id.textViewHoVaTen);
        txtSoBuoiLam = findViewById(R.id.txtSoBuoiLam);
        txtLuongTheoThang = findViewById(R.id.txtLuongTheoThang);
        txtTienThuong = findViewById(R.id.txtTienThuong);
        txtTienPhat = findViewById(R.id.txtTienPhat);
        txtLuongThucTe = findViewById(R.id.txtLuongThucTe);

//                int position = month.getId();
//        textViewHoVaTen.setText("" + month.getHoTen());
//        textViewViTri.setText("" + month.getViTri());
        txtSoBuoiLam.setText("" + monthStaff.getSoBuoiLam());
        txtLuongTheoThang.setText("" + monthStaff.getLuongTheoThang());
        txtTienThuong.setText("" + monthStaff.getTienThuong());
        txtTienPhat.setText("" + monthStaff.getTienPhat());
        txtLuongThucTe.setText("" + monthStaff.getLuongThucTra());

        imgBack = findViewById(R.id.imgBackWageStaffDetails);

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
