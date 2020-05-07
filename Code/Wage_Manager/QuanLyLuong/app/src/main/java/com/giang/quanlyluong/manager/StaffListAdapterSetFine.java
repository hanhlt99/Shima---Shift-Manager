package com.giang.quanlyluong.manager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.giang.quanlyluong.R;

import java.util.ArrayList;

public class StaffListAdapterSetFine extends RecyclerView.Adapter<StaffListAdapterSetFine.ViewHolder>  {

    private Context mContext;
    private ArrayList<Staff> staffs;

    public StaffListAdapterSetFine(Context mContext, ArrayList<Staff> staffs) {
        this.mContext = mContext;
        this.staffs = staffs;
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
            btnCaiDat = itemView.findViewById(R.id.btnCaiDat);
        }
    }

    @NonNull
    @Override
    public StaffListAdapterSetFine.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View heroView = inflater.inflate(R.layout.item_staff_set_salary, parent, false);
        StaffListAdapterSetFine.ViewHolder viewHolder = new StaffListAdapterSetFine.ViewHolder(heroView);
        return viewHolder;
    }

    int khoanTien = 0;
    @Override
    public void onBindViewHolder(@NonNull StaffListAdapterSetFine.ViewHolder holder, final int position) {
        final Staff staff = staffs.get(position);
        holder.txtHoVaTen.setText("" + staff.getHoTen());
        holder.txtViTri.setText("" + staff.getViTri());
        holder.txtLuong.setText("" + staff.getLuongThucTra());

        holder.btnCaiDat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // get prompts.xml view
                LayoutInflater li = LayoutInflater.from(mContext);
                View promptsView = li.inflate(R.layout.set_salary, null);

                final EditText edtKhoanTien = promptsView.findViewById(R.id.edtKhoanTien);

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(mContext);

                // set prompts.xml to alertdialog builder
                alertDialogBuilder.setView(promptsView);

                alertDialogBuilder.setTitle(R.string.nhapPhatTheoThang);

                // create alert dialog
                final AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();

                Button btnApDung = promptsView.findViewById(R.id.btnApDung);
                Button btnApDungTatCa = promptsView.findViewById(R.id.btnApDungTatCa);
                Button btnHuy = promptsView.findViewById(R.id.btnHuy);

                btnApDung.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (edtKhoanTien.getText().toString() != ""){
                            khoanTien = Integer.parseInt(edtKhoanTien.getText().toString());
                        }
                        alertDialog.dismiss();
                        Toast.makeText(mContext, "Xong", Toast.LENGTH_SHORT).show();
                        Staff s = staffs.get(position);
                        staffs.get(position).setLuongThucTra(s.getLuongThucTra() - khoanTien);
                        staffs.get(position).setTienPhat(s.getTienPhat() + khoanTien);

                        notifyDataSetChanged();
                    }

                });

                btnApDungTatCa.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (edtKhoanTien.getText().toString() != ""){
                            khoanTien = Integer.parseInt(edtKhoanTien.getText().toString());
                        }
                        alertDialog.dismiss();
                        Toast.makeText(mContext, "Xong", Toast.LENGTH_SHORT).show();
                        for(Staff s: staffs){
                            if(staffs.get(position).getViTri() == s.getViTri()){
                                s.setLuongThucTra(s.getLuongThucTra() - khoanTien);
                                s.setTienThuong(s.getTienThuong() + khoanTien);
                            }
                        }

                        notifyDataSetChanged();
                    }
                });

                btnHuy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                        Toast.makeText(mContext, "Đã hủy", Toast.LENGTH_SHORT).show();
                    }
                });

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
