package com.example.app_food;

public class danhgia {
//    sql = "CREATE TABLE danhgia(" +
//            "madanhgia INTEGER PRIMARY KEY AUTOINCREMENT, " +
//            "danhgia TEXT, " +
//            "masanpham INTEGER, " +
//            "sosao INTEGER, " +
//            "taikhoanuser TEXT, " +
//            "tensanpham TEXT, " +
//            "FOREIGN KEY (masanpham) REFERENCES sanphams1(masanpham), " +
//            "FOREIGN KEY (taikhoanuser) REFERENCES user(taikhoanuser)" +
//            ");";
//        db.execSQL(sql);
    private int madanhgia;
    private String danhgia;
    private int masanpham;
    private int sosao;
    private String taikhoanuser;
    private String tensanpham;

    public danhgia(int madanhgia, String danhgia, int masanpham, int sosao, String taikhoanuser, String tensanpham) {
        this.madanhgia = madanhgia;
        this.danhgia = danhgia;
        this.masanpham = masanpham;
        this.sosao = sosao;
        this.taikhoanuser = taikhoanuser;
        this.tensanpham = tensanpham;
    }
    public danhgia(){

    }

    public int getMadanhgia() {
        return madanhgia;
    }

    public void setMadanhgia(int madanhgia) {
        this.madanhgia = madanhgia;
    }

    public String getDanhgia() {
        return danhgia;
    }

    public void setDanhgia(String danhgia) {
        this.danhgia = danhgia;
    }

    public int getMasanpham() {
        return masanpham;
    }

    public void setMasanpham(int masanpham) {
        this.masanpham = masanpham;
    }

    public int getSosao() {
        return sosao;
    }

    public void setSosao(int sosao) {
        this.sosao = sosao;
    }

    public String getTaikhoanuser() {
        return taikhoanuser;
    }

    public void setTaikhoanuser(String taikhoanuser) {
        this.taikhoanuser = taikhoanuser;
    }

    public String getTensanpham() {
        return tensanpham;
    }

    public void setTensanpham(String tensanpham) {
        this.tensanpham = tensanpham;
    }
}
