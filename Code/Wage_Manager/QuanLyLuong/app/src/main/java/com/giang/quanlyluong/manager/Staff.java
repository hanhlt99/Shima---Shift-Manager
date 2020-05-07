package com.giang.quanlyluong.manager;

import java.io.Serializable;

public class Staff implements Serializable {
    private int id;
    private String hoTen, viTri;
    private int soBuoiLam, luongTheoThang, tienThuong, tienPhat, luongThucTra;

    public Staff(int id, String hoTen, String viTri, int soBuoiLam, int luongTheoThang, int tienThuong, int tienPhat, int luongThucTra) {
        this.id = id;
        this.hoTen = hoTen;
        this.viTri = viTri;
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

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getViTri() {
        return viTri;
    }

    public void setViTri(String viTri) {
        this.viTri = viTri;
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
