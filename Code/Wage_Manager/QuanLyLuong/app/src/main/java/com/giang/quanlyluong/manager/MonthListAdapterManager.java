package com.giang.quanlyluong.manager;

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
import com.giang.quanlyluong.staff.DetailWageMonthlyStaffActivity;

import java.util.ArrayList;

public class MonthListAdapterManager extends RecyclerView.Adapter<MonthListAdapterManager.ViewHolder>  {

    LinearLayout linearListStaff;
    RecyclerView recyclerMonthManager;


    Context mContext;
    ArrayList<MonthManager> monthManagers;

    public void setID(LinearLayout linearListStaff, RecyclerView recyclerMonthManager){
        this.linearListStaff = linearListStaff;
        this.recyclerMonthManager = recyclerMonthManager;
    }

    public MonthListAdapterManager(Context mContext, ArrayList<MonthManager> monthManagers) {
        this.mContext = mContext;
        this.monthManagers = monthManagers;
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
    public MonthListAdapterManager.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View heroView = inflater.inflate(R.layout.item_month, parent, false);
        MonthListAdapterManager.ViewHolder viewHolder = new MonthListAdapterManager.ViewHolder(heroView);
        return viewHolder;
    }

    MonthManager monthManager;

    @Override
    public void onBindViewHolder(@NonNull MonthListAdapterManager.ViewHolder holder, final int position) {
        monthManager = monthManagers.get(position);
        holder.txtTenThang.setText("Tháng " + monthManager.getId());
        holder.txtTongLuong.setText("" + monthManager.getLuongThucTra());
        holder.linearChiTiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerMonthManager.setVisibility(View.GONE);
                linearListStaff.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public int getItemCount() {
        return monthManagers.size();
    }

    public void clearAllRecyclerView(){
        monthManagers.clear();
        notifyDataSetChanged();
    }
}
