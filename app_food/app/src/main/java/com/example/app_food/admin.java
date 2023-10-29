package com.example.app_food;

public class admin {
    private String taikhoanad;
    private String matkhauad;

    public admin(String taikhoanad, String matkhauad) {
        this.taikhoanad = taikhoanad;
        this.matkhauad = matkhauad;
    }
    public admin(){

    }

    public String getTaikhoanad() {
        return taikhoanad;
    }

    public void setTaikhoanad(String taikhoanad) {
        this.taikhoanad = taikhoanad;
    }

    public String getMatkhauad() {
        return matkhauad;
    }

    public void setMatkhauad(String matkhauad) {
        this.matkhauad = matkhauad;
    }
}
