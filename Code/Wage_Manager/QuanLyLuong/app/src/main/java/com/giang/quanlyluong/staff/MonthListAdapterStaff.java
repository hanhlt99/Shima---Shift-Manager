package com.giang.quanlyluong.staff;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.giang.quanlyluong.R;

import java.util.ArrayList;

public class MonthListAdapterStaff extends RecyclerView.Adapter<MonthListAdapterStaff.ViewHolder>  {

    LinearLayout linearListStaff;
    RecyclerView recyclerMonthManager;


    Context mContext;
    ArrayList<MonthStaff> monthStaffs;

    public void setID(LinearLayout linearListStaff, RecyclerView recyclerMonthManager){
        this.linearListStaff = linearListStaff;
        this.recyclerMonthManager = recyclerMonthManager;
    }

    public MonthListAdapterStaff(Context mContext, ArrayList<MonthStaff> monthStaffs) {
        this.mContext = mContext;
        this.monthStaffs = monthStaffs;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtTenThang;
        private TextView txtTongLuong;
        private LinearLayout linearChiTiet;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTenThang = itemView.findViewById(R.id.txtTenThang);
            txtTongLuong = itemView.findViewById(R.id.txtTongLuong);
            linearChiTiet = itemView.findViewById(R.id.linearChiTiet);
        }
    }

    @NonNull
    @Override
    public MonthListAdapterStaff.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View heroView = inflater.inflate(R.layout.item_month, parent, false);
        MonthListAdapterStaff.ViewHolder viewHolder = new MonthListAdapterStaff.ViewHolder(heroView);
        return viewHolder;
    }

    MonthStaff monthStaff;

    @Override
    public void onBindViewHolder(@NonNull MonthListAdapterStaff.ViewHolder holder, final int position) {
        monthStaff = monthStaffs.get(position);
        holder.txtTenThang.setText("Tháng " + monthStaff.getId());
        holder.txtTongLuong.setText("" + monthStaff.getLuongThucTra());
        holder.linearChiTiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext, DetailWageMonthlyStaffActivity.class);
                i.putExtra("duLieuThang", monthStaffs.get(position));
                mContext.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return monthStaffs.size();
    }

}
