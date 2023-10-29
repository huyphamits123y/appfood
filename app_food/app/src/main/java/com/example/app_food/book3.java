package com.example.app_food;

public class book3 {
    private int idls;
    private int masanpham;
    private String tensanpham;
    private int giatien;
    private int hinhanh;
    private int soluong;
    private int tongtien;
    private String ngaydathang;
    private String taikhoanuser;

    public book3(int idls, int masanpham, String tensanpham, int giatien, int hinhanh, int soluong, int tongtien, String ngaydathang, String taikhoanuser) {
        this.idls = idls;
        this.masanpham = masanpham;
        this.tensanpham = tensanpham;
        this.giatien = giatien;
        this.hinhanh = hinhanh;
        this.soluong = soluong;
        this.tongtien = tongtien;
        this.ngaydathang = ngaydathang;
        this.taikhoanuser = taikhoanuser;
    }
    public book3(){

    }

    public int getIdls() {
        return idls;
    }

    public int getMasanpham() {
        return masanpham;
    }

    public String getTensanpham() {
        return tensanpham;
    }

    public int getGiatien() {
        return giatien;
    }

    public int getHinhanh() {
        return hinhanh;
    }

    public int getSoluong() {
        return soluong;
    }

    public int getTongtien() {
        return tongtien;
    }

    public String getNgaydathang() {
        return ngaydathang;
    }

    public String getTaikhoanuser() {
        return taikhoanuser;
    }

    public void setIdls(int idls) {
        this.idls = idls;
    }

    public void setMasanpham(int masanpham) {
        this.masanpham = masanpham;
    }

    public void setTensanpham(String tensanpham) {
        this.tensanpham = tensanpham;
    }

    public void setGiatien(int giatien) {
        this.giatien = giatien;
    }

    public void setHinhanh(int hinhanh) {
        this.hinhanh = hinhanh;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public void setTongtien(int tongtien) {
        this.tongtien = tongtien;
    }

    public void setNgaydathang(String ngaydathang) {
        this.ngaydathang = ngaydathang;
    }

    public void setTaikhoanuser(String taikhoanuser) {
        this.taikhoanuser = taikhoanuser;
    }
}
