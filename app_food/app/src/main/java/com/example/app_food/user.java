package com.example.app_food;

public class user {
//    sql = "CREATE TABLE user(taikhoanuser text PRIMARY KEY, hoten text, diachi text, sdt INTEGER)";
    private String taikhoanuser;
    private String hoten;
    private String diachi;
    private int sdt;

    public user(String taikhoanuser, String hoten, String diachi, int sdt) {
        this.taikhoanuser = taikhoanuser;
        this.hoten = hoten;
        this.diachi = diachi;
        this.sdt = sdt;
    }
    public user(){

    }

    public String getTaikhoanuser() {
        return taikhoanuser;
    }

    public void setTaikhoanuser(String taikhoanuser) {
        this.taikhoanuser = taikhoanuser;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public int getSdt() {
        return sdt;
    }

    public void setSdt(int sdt) {
        this.sdt = sdt;
    }
}
