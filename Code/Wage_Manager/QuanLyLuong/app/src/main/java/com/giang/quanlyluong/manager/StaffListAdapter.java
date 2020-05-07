package com.giang.quanlyluong.manager;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.giang.quanlyluong.R;
import com.giang.quanlyluong.staff.DetailWageMonthlyStaffActivity;

import java.util.ArrayList;
import java.util.List;

public class StaffListAdapter extends RecyclerView.Adapter<StaffListAdapter.ViewHolder>  {

    private Context mContext;
    private ArrayList<Staff> staffs;
    private ArrayList<Staff> staffsList;

    public StaffListAdapter(Context mContext, ArrayList<Staff> staffs) {
        this.mContext = mContext;
        this.staffs = staffs;
        staffsList = staffs;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtHoVaTen;
        private TextView txtViTri;
        private TextView txtLuong;
        private LinearLayout linearItemStaff;
        private Button btnCaiDat;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtHoVaTen = itemView.findViewById(R.id.txtHoVaTen);
            txtViTri = itemView.findViewById(R.id.txtViTri);
            txtLuong = itemView.findViewById(R.id.txtLuong);
            linearItemStaff = itemView.findViewById(R.id.linearItemStaff);
        }
    }

    @NonNull
    @Override
    public StaffListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View heroView = inflater.inflate(R.layout.item_staff, parent, false);
        StaffListAdapter.ViewHolder viewHolder = new StaffListAdapter.ViewHolder(heroView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull StaffListAdapter.ViewHolder holder,final int position) {
        final Staff staff = staffs.get(position);
        holder.txtHoVaTen.setText("" + staff.getHoTen());
        holder.txtViTri.setText("" + staff.getViTri());
        holder.txtLuong.setText("" + staff.getLuongThucTra());

        holder.linearItemStaff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext, DetailWageMonthStaffInMangerActivity.class);
                i.putExtra("duLieuNhanVien", staffs.get(position));
                mContext.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return staffs.size();
    }

    //This method will filter the list
    //here we are passing the filtered data
    //and assigning it to the list with notifydatasetchanged method
    public void filterList(ArrayList<Staff> filterdNames) {
        this.staffs = filterdNames;
        notifyDataSetChanged();
    }

}
