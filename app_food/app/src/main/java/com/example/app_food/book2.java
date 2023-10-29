package com.example.app_food;

public class book2 {
//    id INTEGER PRIMARY KEY AUTOINCREMENT, masanpham INTEGER, tensanpham text, giatien INTEGER, hinhanh INTEGER, soluong INTEGER, tongtien INTEGER, taikhoanuser text, FOREIGN KEY (taikhoanuser) REFERENCES user(taikhoanuser)

    private int id;
    private int masanpham;
    private String tensanpham;
    private int giatien;
    private int hinhanh;
    private int soluong;
    private int tongtien;
    private String ngaydathang;
    private String taikhoanuser;

    public book2(int id, int masanpham, String tensanpham, int giatien, int hinhanh, int soluong, int tongtien, String ngaydathang, String taikhoanuser) {
        this.id = id;
        this.masanpham = masanpham;
        this.tensanpham = tensanpham;
        this.giatien = giatien;
        this.hinhanh = hinhanh;
        this.soluong = soluong;
        this.tongtien = tongtien;
        this.ngaydathang = ngaydathang;
        this.taikhoanuser = taikhoanuser;
    }

    public book2(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMasanpham() {
        return masanpham;
    }

    public void setMasanpham(int masanpham) {
        this.masanpham = masanpham;
    }

    public String getTensanpham() {
        return tensanpham;
    }

    public void setTensanpham(String tensanpham) {
        this.tensanpham = tensanpham;
    }

    public int getGiatien() {
        return giatien;
    }

    public void setGiatien(int giatien) {
        this.giatien = giatien;
    }

    public int getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(int hinhanh) {
        this.hinhanh = hinhanh;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public int getTongtien() {
        return tongtien;
    }

    public void setTongtien(int tongtien) {
        this.tongtien = tongtien;
    }

    public String getNgaydathang() {
        return ngaydathang;
    }

    public void setNgaydathang(String ngaydathang) {
        this.ngaydathang = ngaydathang;
    }

    public String getTaikhoanuser() {
        return taikhoanuser;
    }

    public void setTaikhoanuser(String taikhoanuser) {
        this.taikhoanuser = taikhoanuser;
    }
}

