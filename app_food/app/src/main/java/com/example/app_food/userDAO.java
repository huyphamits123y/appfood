package com.example.app_food;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.Toast;

import java.util.ArrayList;

public class userDAO {
//    public static ArrayList<user> getAll(Context context){
//        ArrayList<user> ds = new ArrayList<>();
//        database db = new database(context);
//        SQLiteDatabase dbs = db.getReadableDatabase();
//        Cursor cs = dbs.rawQuery("SELECT * FROM user", null);
//        cs.moveToFirst();
//        if (cs != null) {
//            while (!cs.isAfterLast()) {
//                String taikhoan = cs.getString(0);
//                String hoten = cs.getString(1);
//                String diachi = cs.getString(2);
//                user u = new user(taikhoan, hoten, diachi);
//                ds.add(u);
//                cs.moveToNext();
//            }
//        }
//        else {
//            Toast.makeText(context, "Database trong khong", Toast.LENGTH_SHORT).show();
//        }
//        cs.close();
//        return ds;
//    }
//    public static ArrayList<admin> getadmin(Context context){
//        ArrayList<admin> ds = new ArrayList<>();
//        database db = new database(context);
//        SQLiteDatabase dbs = db.getReadableDatabase();
//        Cursor cs = dbs.rawQuery("SELECT * FROM admin", null);
//        cs.moveToFirst();
//        if (cs != null) {
//            while (!cs.isAfterLast()) {
//                String taikhoanad = cs.getString(0);
//                String matkhauad = cs.getString(1);
//
//                admin u = new admin(taikhoanad, matkhauad);
//                ds.add(u);
//                cs.moveToNext();
//            }
//        }
//        else {
//            Toast.makeText(context, "Database trong khong", Toast.LENGTH_SHORT).show();
//        }
//        cs.close();
//        return ds;
//    }
    public static ArrayList<book1> getdanhmuc(Context context){
        ArrayList<book1> ds = new ArrayList<>();
        database db = new database(context);
        SQLiteDatabase dbs = db.getReadableDatabase();
        Cursor cs = dbs.rawQuery("SELECT * FROM danhmuc", null);
        cs.moveToFirst();
        if (cs != null) {
            while (!cs.isAfterLast()) {
                int madanhmuc = cs.getInt(0);
               int hinhanh = cs.getInt(1);
                String title = cs.getString(2);
                book1 u = new book1(madanhmuc, hinhanh, title);
                ds.add(u);
                cs.moveToNext();
            }
        }
        else {
            Toast.makeText(context, "Database trong khong", Toast.LENGTH_SHORT).show();
        }
        cs.close();
        return ds;
    }
//    sql = "CREATE TABLE sanphams(masanpham INTEGER PRIMARY KEY AUTOINCREMENT, tensanpham text, giatien INTEGER, hinhanh INTEGER, danhgia text, madanhmuc INTEGER, FOREIGN KEY (madanhmuc) REFERENCES huy(madanhmuc))";
//        db.execSQL(sql);
//    public static ArrayList<book> getsanphams(Context context){
//        ArrayList<book> ds = new ArrayList<>();
//        database db = new database(context);
//        SQLiteDatabase dbs = db.getReadableDatabase();
//        Cursor cs = dbs.rawQuery("SELECT * FROM sanphams1", null);
//        cs.moveToFirst();
//        if (cs != null) {
//            while (!cs.isAfterLast()) {
//                int masanpham = cs.getInt(0);
//                String tensanpham = cs.getString(1);
//                int giatien = cs.getInt(2);
//                int hinhanh = cs.getInt(3);
//                String danhgia = cs.getString(4);
//                int madanhmuc = cs.getInt(5);
//                book u = new book(masanpham, tensanpham, giatien, hinhanh, danhgia, madanhmuc);
//                ds.add(u);
//                cs.moveToNext();
//            }
//        }
//        else {
//            Toast.makeText(context, "Database trong khong", Toast.LENGTH_SHORT).show();
//        }
//        cs.close();
//        return ds;
//    }
    public static ArrayList<book> getsanphams1(Context context, int madanhmucs){
        ArrayList<book> ds = new ArrayList<>();
        database db = new database(context);
        SQLiteDatabase dbs = db.getReadableDatabase();
        Cursor cs = dbs.rawQuery("SELECT * FROM sanpham WHERE madanhmuc=?", new String[]{String.valueOf(madanhmucs)});
        cs.moveToFirst();
        if (cs != null) {
            while (!cs.isAfterLast()) {
                int masanpham = cs.getInt(0);
                String tensanpham = cs.getString(1);
                int giatien = cs.getInt(2);
                int hinhanh = cs.getInt(3);
                String mota = cs.getString(4);
                int soluong = cs.getInt(5);
                int madanhmuc = cs.getInt(6);
                int isBestSeller = cs.getInt(7);
                book u = new book(masanpham, tensanpham, giatien, hinhanh, mota, soluong, madanhmuc, isBestSeller);
                ds.add(u);
                cs.moveToNext();
            }
        }
        else {
            Toast.makeText(context, "Database trong khong", Toast.LENGTH_SHORT).show();
        }
        cs.close();
        return ds;
    }
    public static ArrayList<book> getsanphams11(Context context){
        ArrayList<book> ds = new ArrayList<>();
        database db = new database(context);
        SQLiteDatabase dbs = db.getReadableDatabase();
        Cursor cs = dbs.rawQuery("SELECT * FROM sanpham", null);
        cs.moveToFirst();
        if (cs != null) {
            while (!cs.isAfterLast()) {
                int masanpham = cs.getInt(0);
                String tensanpham = cs.getString(1);
                int giatien = cs.getInt(2);
                int hinhanh = cs.getInt(3);
                String mota = cs.getString(4);
                int soluong = cs.getInt(5);
                int madanhmuc = cs.getInt(6);
                int isBestSeller = cs.getInt(7);
                book u = new book(masanpham, tensanpham, giatien, hinhanh, mota, soluong, madanhmuc, isBestSeller);
                ds.add(u);
                cs.moveToNext();
            }
        }
        else {
            Toast.makeText(context, "Database trong khong", Toast.LENGTH_SHORT).show();
        }
        cs.close();
        return ds;
    }
//    id INTEGER PRIMARY KEY AUTOINCREMENT, masanpham INTEGER, tensanpham text, giatien INTEGER, hinhanh INTEGER, soluong INTEGER, tongtien INTEGER, ngaydathang text, taikhoanuser text, FOREIGN KEY (taikhoanuser) REFERENCES user(taikhoanuser)
    public static boolean insertlistdh(Context context, int masanpham, String tensanpham, int giatien, int hinhanh, int soluong, int tongtien, String ngaydathang, String taikhoanuser){
        database data = new database(context);
        SQLiteDatabase db = data.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("masanpham", masanpham);
        values.put("tensanpham", tensanpham );
        values.put("giatien",giatien);
        values.put("hinhanh",hinhanh);
        values.put("soluong",soluong);
        values.put("tongtien",tongtien);
        values.put("ngaydathang", ngaydathang);
        values.put("taikhoanuser",taikhoanuser);
        long row = db.insert("giohang", null, values);
        return (row > 0);
    }
    public static boolean insertlistls(Context context, int idls, int masanpham, String tensanpham, int giatien, int hinhanh, int soluong, int tongtien, String ngaydathang, String taikhoanuser){
        database data = new database(context);
        SQLiteDatabase db = data.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("idls", idls);
        values.put("masanpham", masanpham);
        values.put("tensanpham", tensanpham );
        values.put("giatien",giatien);
        values.put("hinhanh",hinhanh);
        values.put("soluong",soluong);
        values.put("tongtien",tongtien);
        values.put("ngaydathang", ngaydathang);
        values.put("taikhoanuser",taikhoanuser);
        long row = db.insert("lichsu", null, values);
        return (row > 0);
    }
    public static ArrayList<book3> getlichsu(Context context, String taikhoanusers){
        ArrayList<book3> ds = new ArrayList<>();
        database db = new database(context);
        SQLiteDatabase dbs = db.getReadableDatabase();
        String[] selectionArgs = { taikhoanusers };
        //    id INTEGER PRIMARY KEY AUTOINCREMENT, masanpham INTEGER, tensanpham text, giatien INTEGER, hinhanh INTEGER, soluong INTEGER, tongtien INTEGER, ngaydathang text, taikhoanuser text, FOREIGN KEY (taikhoanuser) REFERENCES user(taikhoanuser)
        // Thực hiện truy vấn SQL với điều kiện "taikhoanuser"
        Cursor cs = dbs.rawQuery("SELECT * FROM lichsu WHERE taikhoanuser=?", selectionArgs);
        cs.moveToFirst();
        if (cs != null) {
            while (!cs.isAfterLast()) {
                int idls = cs.getInt(0);
                int masanpham = cs.getInt(1);
                String tensanpham = cs.getString(2);
                int giatien = cs.getInt(3);
                int hinhanh = cs.getInt(4);
                int soluong = cs.getInt(5);
                int tongtien = cs.getInt(6);
                String ngaydathang = cs.getString(7);
                String taikhoanuser = cs.getString(8);
                book3 u = new book3(idls, masanpham, tensanpham, giatien, hinhanh, soluong, tongtien, ngaydathang, taikhoanuser);
                ds.add(u);
                cs.moveToNext();
            }
        }
        else {
            Toast.makeText(context, "Database trong khong", Toast.LENGTH_SHORT).show();
        }
        cs.close();
        return ds;
    }
//    taikhoanuser text PRIMARY KEY, hoten text, diachi text, sdt INTEGER
public static ArrayList<user> getuser(Context context){
    ArrayList<user> ds = new ArrayList<>();
    database db = new database(context);
    SQLiteDatabase dbs = db.getReadableDatabase();

    //    id INTEGER PRIMARY KEY AUTOINCREMENT, masanpham INTEGER, tensanpham text, giatien INTEGER, hinhanh INTEGER, soluong INTEGER, tongtien INTEGER, ngaydathang text, taikhoanuser text, FOREIGN KEY (taikhoanuser) REFERENCES user(taikhoanuser)
    // Thực hiện truy vấn SQL với điều kiện "taikhoanuser"
    Cursor cs = dbs.rawQuery("SELECT * FROM khachhang", null);
    cs.moveToFirst();
    if (cs != null) {
        while (!cs.isAfterLast()) {
         String taikhoanuser = cs.getString(0);
         String hoten = cs.getString(1);
         String diachi = cs.getString(2);
         int sdt = cs.getInt(3);
         user u = new user(taikhoanuser,hoten, diachi, sdt);
         ds.add(u);
         cs.moveToNext();
        }
    }
    else {
        Toast.makeText(context, "Database trong khong", Toast.LENGTH_SHORT).show();
    }
    cs.close();
    return ds;
}

    public static ArrayList<book2> getsanphams2(Context context, String taikhoanusers){
        ArrayList<book2> ds = new ArrayList<>();
        database db = new database(context);
        SQLiteDatabase dbs = db.getReadableDatabase();
        String[] selectionArgs = { taikhoanusers };
        //    id INTEGER PRIMARY KEY AUTOINCREMENT, masanpham INTEGER, tensanpham text, giatien INTEGER, hinhanh INTEGER, soluong INTEGER, tongtien INTEGER, ngaydathang text, taikhoanuser text, FOREIGN KEY (taikhoanuser) REFERENCES user(taikhoanuser)
        // Thực hiện truy vấn SQL với điều kiện "taikhoanuser"
        Cursor cs = dbs.rawQuery("SELECT * FROM giohang WHERE taikhoanuser=?", selectionArgs);
        cs.moveToFirst();
        if (cs != null) {
            while (!cs.isAfterLast()) {
               int id = cs.getInt(0);
               int masanpham = cs.getInt(1);
               String tensanpham = cs.getString(2);
               int giatien = cs.getInt(3);
               int hinhanh = cs.getInt(4);
               int soluong = cs.getInt(5);
               int tongtien = cs.getInt(6);
               String ngaydathang = cs.getString(7);
               String taikhoanuser = cs.getString(8);
                book2 u = new book2(id, masanpham, tensanpham, giatien, hinhanh, soluong, tongtien, ngaydathang, taikhoanuser);
                ds.add(u);
                cs.moveToNext();
            }
        }
        else {
            Toast.makeText(context, "Database trong khong", Toast.LENGTH_SHORT).show();
        }
        cs.close();
        return ds;
    }
//    public static boolean insertsanpham(Context context, String tensanpham, int giatien, int hinhanh, String mota, int madanhmuc)
//    {
//        database data = new database(context);
//        SQLiteDatabase db = data.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put("tensanpham", tensanpham);
//        values.put("giatien", giatien);
//        values.put("hinhanh",hinhanh);
//        values.put("mota",mota);
//        values.put("madanhmuc",madanhmuc);
//        long row = db.insert("sanphams1", null, values);
//        return (row > 0);
//
//    }
public static boolean insertsanpham(Context context, String tenSanPham, int giaTien, int hinhAnh, String mota, int soLuong, int maDanhMuc, int bestSeller) {
    database data = new database(context);
    SQLiteDatabase db = data.getWritableDatabase();
    ContentValues values = new ContentValues();
    values.put("tensanpham", tenSanPham);
    values.put("giatien", giaTien);
    values.put("hinhanh", hinhAnh);
    values.put("mota", mota);
    values.put("soluong", soLuong);
    values.put("madanhmuc", maDanhMuc);
    values.put("bestSeller", bestSeller); // Không cần chuyển đổi kiểu BOOLEAN sang INTEGER
    long row = db.insert("sanpham", null, values);
    return (row > 0);
}
//    sql = "CREATE TABLE danhgia (" +
//            "madanhgia INTEGER PRIMARY KEY AUTOINCREMENT, " +
//            "danhgia TEXT, " +
//            "masanpham INTEGER, " +
//            "sosao INTEGER, " +
//            "taikhoanuser TEXT, " +
//            "FOREIGN KEY (masanpham) REFERENCES sanphams1(masanpham), " +
//            "FOREIGN KEY (taikhoanuser) REFERENCES user(taikhoanuser)" +
//            ");";
//        db.execSQL(sql);
public static boolean insertdanhgia(Context context, String danhgia, int masanpham, int sosao, String taikhoanuser, String tensanpham)
{
    database data = new database(context);
    SQLiteDatabase db = data.getWritableDatabase();
    ContentValues values = new ContentValues();
    values.put("danhgia", danhgia);
    values.put("masanpham", masanpham);
    values.put("sosao",sosao);
    values.put("taikhoanuser",taikhoanuser);
    values.put("tensanpham",tensanpham);
    long row = db.insert("danhgia", null, values);
    return (row > 0);

}
    public static ArrayList<danhgia> getdanhgia(Context context, int masanphams){
        ArrayList<danhgia> ds = new ArrayList<>();
        database db = new database(context);
        SQLiteDatabase dbs = db.getReadableDatabase();
        Cursor cs = dbs.rawQuery("SELECT * FROM danhgia WHERE masanpham=?", new String[]{String.valueOf(masanphams)});
        cs.moveToFirst();
        if (cs != null) {
            while (!cs.isAfterLast()) {
                int madanhgia = cs.getInt(0);
                String danhgia = cs.getString(1);
                int masanpham = cs.getInt(2);
                int sosao = cs.getInt(3);
                String taikhoanuser = cs.getString(4);
                String tensanpham = cs.getString(5);

                danhgia u = new danhgia(madanhgia, danhgia, masanpham, sosao, taikhoanuser, tensanpham);
                ds.add(u);
                cs.moveToNext();
            }
        }
        else {
            Toast.makeText(context, "Database trong khong", Toast.LENGTH_SHORT).show();
        }
        cs.close();
        return ds;
    }
    public static boolean insert(Context context, int hinhanh, String title)
    {
        database data = new database(context);
        SQLiteDatabase db = data.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("hinhanh", hinhanh);
        values.put("title", title);
        long row = db.insert("danhmuc", null, values);
        return (row > 0);

    }
//    taikhoanuser text PRIMARY KEY, hoten text, diachi text, sdt INTEGER
    public static boolean insertuser(Context context, String taikhoanuser, String hoten, String diachi, int sdt)
    {
        database data = new database(context);
        SQLiteDatabase db = data.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("taikhoanuser", taikhoanuser);
        values.put("hoten", hoten);
        values.put("diachi", diachi);
        values.put("sdt", sdt);
        long row = db.insert("khachhang", null, values);
        return (row > 0);

    }
//    public static ArrayList<user> getuser(Context context){
//        ArrayList<user> ds = new ArrayList<>();
//        database db = new database(context);
//        SQLiteDatabase dbs = db.getReadableDatabase();
//        Cursor cs = dbs.rawQuery("SELECT * FROM user", null);
//        cs.moveToFirst();
//        if (cs != null) {
//            while (!cs.isAfterLast()) {
//               String taikhoanuser = cs.getString(0);
//               String hoten = cs.getString(1);
//               String diachi = cs.getString(2);
//               int sdt = cs.getInt(3);
//               user u = new user(taikhoanuser, hoten, diachi, sdt);
//                ds.add(u);
//                cs.moveToNext();
//            }
//        }
//        else {
//            Toast.makeText(context, "Database trong khong", Toast.LENGTH_SHORT).show();
//        }
//        cs.close();
//        return ds;
//    }
//    public static boolean insert11(Context context, int madanhmuc, int hinhanh, String title)
//    {
//        database data = new database(context);
//        SQLiteDatabase db = data.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put("madanhmuc", madanhmuc);
//        values.put("hinhanh", hinhanh);
//        values.put("title", title);
//        long row = db.insert("book1", null, values);
//        return (row > 0);
//
//    }
    public static int intm(Context context, String a){
        int resId = context.getResources().getIdentifier(a, "drawable", context.getPackageName());
        return resId;
    }
    public static boolean updatedanhmuc(Context context, int hinhanh, String title, int madanhmuc) {
        database data = new database(context);
        SQLiteDatabase db = data.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("hinhanh", hinhanh);
        values.put("title", title);

        // Chuyển đổi giá trị madanhmuc thành chuỗi
        String madanhmucString = String.valueOf(madanhmuc);

        long row = db.update("danhmuc", values, "madanhmuc=?", new String[] { madanhmucString });
        return (row > 0);
    }
//    masanpham INTEGER PRIMARY KEY AUTOINCREMENT, tensanpham text, giatien INTEGER, hinhanh INTEGER, mota text, madanhmuc INTEGER, FOREIGN KEY (madanhmuc) REFERENCES huy(madanhmuc)
    public static boolean updatemonan(Context context, String tensanpham, int giatien, int hinhanh, String mota, int madanhmuc, int masanpham) {
        database data = new database(context);
        SQLiteDatabase db = data.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("tensanpham", tensanpham);
        values.put("giatien", giatien);
        values.put("hinhanh", hinhanh);
        values.put("mota", mota);
        values.put("madanhmuc", madanhmuc);

        // Chuyển đổi giá trị madanhmuc thành chuỗi
        String masanphamString = String.valueOf(masanpham);

        long row = db.update("sanpham", values, "masanpham=?", new String[] { masanphamString });
        return (row > 0);
    }

    //
    public static boolean delete(Context context, int madanhmuc)
    {
        database data = new database(context);
        SQLiteDatabase db = data.getWritableDatabase();
        long row = db.delete("danhmuc", "madanhmuc=?", new String[]{madanhmuc + ""});
        return (row > 0);

    }
    public static boolean deletegiohang(Context context){
        database data = new database(context);
        SQLiteDatabase db = data.getWritableDatabase();
        long row = db.delete("giohang", null, null);
        return (row > 0);
    }

    public static boolean deletesanpham(Context context, int masanpham)
    {
        database data = new database(context);
        SQLiteDatabase db = data.getWritableDatabase();
        long row = db.delete("sanpham", "masanpham=?", new String[]{masanpham + ""});
        return (row > 0);

    }
//    public static int ca(Context context,String a){
//        int resId = ((Activity)context).getResources().getIdentifier(a, "drawable", ((Activity)context).getPackageName());
//        return resId;
//
//    }
public static boolean updateslsanpham(Context context, int soluong,int masanpham) {
    database data = new database(context);
    SQLiteDatabase db = data.getWritableDatabase();
    ContentValues values = new ContentValues();
    values.put("soluong", soluong);
    // Chuyển đổi giá trị madanhmuc thành chuỗi
    String masanphamString = String.valueOf(masanpham);
    long row = db.update("sanpham", values, "masanpham=?", new String[] { masanphamString });
    return (row > 0);
}
}
