package com.example.app_food;

public class book {
//    sql = "CREATE TABLE sanpham(masanpham INTEGER PRIMARY KEY AUTOINCREMENT, tensanpham text, giatien INTEGER, hinhanh INTEGER, danhgia text, madanhmuc INTEGER, FOREIGN KEY (madanhmuc) REFERENCES huy(madanhmuc))";
//        db.execSQL(sql);
    private int masanpham;
    private String tensanpham;
    private int giatien;
    private int hinhanh;
    private String mota;
    private int soluong;
    private int madanhmuc;
    private int isBestSeller;

    public book(int masanpham, String tensanpham, int giatien, int hinhanh, String mota, int soluong, int madanhmuc, int isBestSeller) {
        this.masanpham = masanpham;
        this.tensanpham = tensanpham;
        this.giatien = giatien;
        this.hinhanh = hinhanh;
        this.mota = mota;
        this.soluong = soluong;
        this.madanhmuc = madanhmuc;
        this.isBestSeller = isBestSeller;
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

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public int getMadanhmuc() {
        return madanhmuc;
    }

    public void setMadanhmuc(int madanhmuc) {
        this.madanhmuc = madanhmuc;
    }

    public int getIsBestSeller() {
        return isBestSeller;
    }

    public void setIsBestSeller(int isBestSeller) {
        this.isBestSeller = isBestSeller;
    }
}
