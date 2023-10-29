package com.example.app_food;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class database extends SQLiteOpenHelper {
    public database(Context context) {
        super(context, "huyyuvrkf1.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE nguoiquantri(taikhoanad text PRIMARY KEY, matkhauad text)";
        db.execSQL(sql);
        sql = "INSERT INTO nguoiquantri VALUES ('huyzxv123@gmail.com', 'huyzxv123456')";
        db.execSQL(sql);
        sql = "CREATE TABLE khachhang(taikhoanuser text PRIMARY KEY, hoten text, diachi text, sdt INTEGER)";
        db.execSQL(sql);
        sql = "CREATE TABLE hoadon(mahoadon INTEGER PRIMARY KEY AUTOINCREMENT, hoten text, tongtien INTEGER, ngaydathang text, taikhoanuser text, FOREIGN KEY (taikhoanuser) REFERENCES khachhang(taikhoanuser))";
        db.execSQL(sql);
        sql = "CREATE TABLE danhmuc(madanhmuc INTEGER PRIMARY KEY AUTOINCREMENT,  hinhanh INTEGER, title text)";
        db.execSQL(sql);
        sql = "INSERT INTO danhmuc VALUES(NULL, 2131165339, 'Pizza')";
        db.execSQL(sql);
        sql = "INSERT INTO danhmuc VALUES(NULL, 2131165341, 'Burgur')";
        db.execSQL(sql);
        sql = "INSERT INTO danhmuc VALUES(NULL, 2131165342, 'Hotdog')";
        db.execSQL(sql);
        sql = "INSERT INTO danhmuc VALUES(NULL, 2131165343, 'Drink')";
        db.execSQL(sql);
        sql = "CREATE TABLE sanpham(masanpham INTEGER PRIMARY KEY AUTOINCREMENT, tensanpham text, giatien INTEGER, hinhanh INTEGER, mota text, soluong INTEGER,madanhmuc INTEGER, bestSeller INTEGER,FOREIGN KEY (madanhmuc) REFERENCES danhmuc(madanhmuc))";
        db.execSQL(sql);
        sql = "INSERT INTO sanpham VALUES (NULL, 'Pizza xuc xich', 120000,2131165344, 'Pizza xuc xich', 0, 1, 0)";
        db.execSQL(sql);
        sql = "INSERT INTO sanpham VALUES (NULL, 'Pizza pho mai', 110000,2131165345, 'Pizza pho mai', 0, 1, 0)";
        db.execSQL(sql);
        sql = "INSERT INTO sanpham VALUES (NULL, 'Burgur pho mai', 70000,2131165331, 'Burgur pho mai', 0, 2, 0)";
        db.execSQL(sql);
        sql = "INSERT INTO sanpham VALUES (NULL, 'Burgur ca hoi', 80000,2131165332, 'Burgur ca hoi', 0, 2, 0)";
        db.execSQL(sql);
        sql = "INSERT INTO sanpham VALUES (NULL, 'Hotdog pho mai', 50000,2131165334, 'Hotdog pho mai', 0, 3, 0)";
        db.execSQL(sql);
        sql = "INSERT INTO sanpham VALUES (NULL, 'Hotdog xuc xich', 55000,2131165335, 'Hotdog xuc xich', 0, 3, 0)";
        db.execSQL(sql);
        sql = "INSERT INTO sanpham VALUES (NULL, 'Pepsi', 20000,2131165336, 'Pepsi', 0, 4, 0)";
        db.execSQL(sql);
        sql = "INSERT INTO sanpham VALUES (NULL, 'Sting', 20000,2131165337,'Sting', 0, 4, 0)";
        db.execSQL(sql);
        sql = "CREATE TABLE giohang(id INTEGER PRIMARY KEY AUTOINCREMENT, masanpham INTEGER, tensanpham text, giatien INTEGER, hinhanh INTEGER, soluong INTEGER, tongtien INTEGER, ngaydathang text, taikhoanuser text, FOREIGN KEY (taikhoanuser) REFERENCES khachhang(taikhoanuser), FOREIGN KEY (masanpham) REFERENCES sanpham(masanpham))";
        db.execSQL(sql);
        sql = "CREATE TABLE lichsu(idls INTEGER PRIMARY KEY, masanpham INTEGER, tensanpham text, giatien INTEGER, hinhanh INTEGER, soluong INTEGER, tongtien INTEGER, ngaydathang text, taikhoanuser text, FOREIGN KEY (taikhoanuser) REFERENCES khachhang(taikhoanuser), FOREIGN KEY (masanpham) REFERENCES sanpham(masanpham))";
        db.execSQL(sql);
        sql = "CREATE TABLE danhgia(" +
                "madanhgia INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "danhgia TEXT, " +
                "masanpham INTEGER, " +
                "sosao INTEGER, " +
                "taikhoanuser TEXT, " +
                "tensanpham TEXT, " +
                "FOREIGN KEY (masanpham) REFERENCES sanpham(masanpham), " +
                "FOREIGN KEY (taikhoanuser) REFERENCES khachhang(taikhoanuser)" +
                ");";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
