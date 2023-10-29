package com.example.app_food;

import android.graphics.Bitmap;

public class book1 {

    private int madanhmuc;
    private int hinhanh;
    private String title;

   public book1(){

   }

    public book1(int madanhmuc, int hinhanh, String title) {
        this.madanhmuc = madanhmuc;
        this.hinhanh = hinhanh;
        this.title = title;
    }

    public int getMadanhmuc() {
        return madanhmuc;
    }

    public void setMadanhmuc(int madanhmuc) {
        this.madanhmuc = madanhmuc;
    }

    public int getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(int hinhanh) {
        this.hinhanh = hinhanh;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
