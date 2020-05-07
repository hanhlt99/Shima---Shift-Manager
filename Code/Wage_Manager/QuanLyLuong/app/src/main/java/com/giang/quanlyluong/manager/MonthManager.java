package com.giang.quanlyluong.manager;

import java.io.Serializable;

public class MonthManager implements Serializable {
    private int id, luongThucTra;

    public MonthManager(int id, int luongThucTra) {
        this.id = id;
        this.luongThucTra = luongThucTra;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLuongThucTra() {
        return luongThucTra;
    }

    public void setLuongThucTra(int luongThucTra) {
        this.luongThucTra = luongThucTra;
    }
}
