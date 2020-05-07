package com.giang.quanlyluong.staff;

import java.io.Serializable;

public class MonthStaff implements Serializable {
    private int id, soBuoiLam, luongTheoThang, tienThuong, tienPhat, luongThucTra;

    public MonthStaff(int id, int soBuoiLam, int luongTheoThang, int tienThuong, int tienPhat, int luongThucTra) {
        this.id = id;
        this.soBuoiLam = soBuoiLam;
        this.luongTheoThang = luongTheoThang;
        this.tienThuong = tienThuong;
        this.tienPhat = tienPhat;
        this.luongThucTra = luongThucTra;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSoBuoiLam() {
        return soBuoiLam;
    }

    public void setSoBuoiLam(int soBuoiLam) {
        this.soBuoiLam = soBuoiLam;
    }

    public int getLuongTheoThang() {
        return luongTheoThang;
    }

    public void setLuongTheoThang(int luongTheoThang) {
        this.luongTheoThang = luongTheoThang;
    }

    public int getTienThuong() {
        return tienThuong;
    }

    public void setTienThuong(int tienThuong) {
        this.tienThuong = tienThuong;
    }

    public int getTienPhat() {
        return tienPhat;
    }

    public void setTienPhat(int tienPhat) {
        this.tienPhat = tienPhat;
    }

    public int getLuongThucTra() {
        return luongThucTra;
    }

    public void setLuongThucTra(int luongThucTra) {
        this.luongThucTra = luongThucTra;
    }
}
