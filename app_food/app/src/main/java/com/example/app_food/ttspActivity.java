package com.example.app_food;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import java.util.Calendar;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ttspActivity extends AppCompatActivity {

    ImageView im1;
    danhgia danhgia;
    danhgiaAdapter danhgiaAdapter;
    ArrayList<danhgia> dg;
    ArrayList<danhgia> dgg;
    private RecyclerView rcvDanhgia;
    ImageView im2;
    int gias = 0;

    int tru = 0;
    TextView txten;
    TextView txgia;
    TextView txmota;
    ImageView hinh;
    String sl = "";
    int soluong = 0;
    TextView tx;
    ArrayList<book> bk;
    String tensanpham = "";
    String taikhoanuser = "";
    book book;
    int vitri = 0;
    Button btn;
    int maspp = 0;

    private int currentValue = 0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ttsp);
        im1 = (ImageView) findViewById(R.id.imageView2);
        im2 = (ImageView) findViewById(R.id.imageView3);
        tx = (TextView) findViewById(R.id.textView3);
        txten = (TextView) findViewById(R.id.txten);
        txgia = (TextView) findViewById(R.id.txgia);
        txmota = (TextView) findViewById(R.id.txdanhgia);

        hinh = (ImageView) findViewById(R.id.imageViewza);
        if (getIntent().hasExtra("tensanpham")) {
            tensanpham = getIntent().getStringExtra("tensanpham");
        }
        if (getIntent().hasExtra("taikhoanuser")) {
            taikhoanuser = getIntent().getStringExtra("taikhoanuser");
        }
        if (getIntent().hasExtra("masanpham")) {
            maspp = getIntent().getIntExtra("masanpham", 0);
        }
        bk = new ArrayList<>();
        bk = userDAO.getsanphams11(ttspActivity.this);
        for (int i = 0; i < bk.size(); i++) {
            book = bk.get(i);
            if (book.getTensanpham().equals(tensanpham)) {
                vitri = i;
            }
        }
        book = bk.get(vitri);
        int masppp = book.getMasanpham();

        txten.setText(book.getTensanpham());
        txgia.setText(0 + "");
        txmota.setText(book.getMota());
        hinh.setImageResource(book.getHinhanh());
        int gia = book.getGiatien();
        Calendar calendar = Calendar.getInstance();

// Lấy ngày giờ hiện tại
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1; // Tháng bắt đầu từ 0
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);

        String dateTimeString = day + "/" + month + "/" + year + " " + hour + ":" + minute;
//
//        Toast.makeText(ttspActivity.this, dateTimeString, Toast.LENGTH_SHORT).show();

//        id INTEGER PRIMARY KEY AUTOINCREMENT, masanpham INTEGER, tensanpham text, giatien INTEGER, hinhanh INTEGER, soluong INTEGER, tongtien INTEGER, ngaydathang text, taikhoanuser text, FOREIGN KEY (taikhoanuser) REFERENCES user(taikhoanuser)
        btn = (Button) findViewById(R.id.buttonadddh);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (userDAO.insertlistdh(ttspActivity.this, book.getMasanpham(), book.getTensanpham(), book.getGiatien(), book.getHinhanh(), currentValue, gias, dateTimeString, taikhoanuser)) {
                    Toast.makeText(ttspActivity.this, "them san pham thanh cong", Toast.LENGTH_SHORT).show();
                    if (userDAO.updateslsanpham(ttspActivity.this, currentValue, masppp)){
                        Toast.makeText(ttspActivity.this, "sua so luong thanh cong", Toast.LENGTH_SHORT).show();

                    }
                    else{
                        Toast.makeText(ttspActivity.this, "sua so luong that bai", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(ttspActivity.this, "them san pham that bai", Toast.LENGTH_SHORT).show();
                }
//                                    Toast.makeText(ttspActivity.this, "them san pham that bai" + gias, Toast.LENGTH_SHORT).show();
            }
        });


// In ra ngày giờ hiện tại

        im1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentValue++;
                gias = gia * currentValue;
                txgia.setText(gias + "");
                tx.setText(String.valueOf(currentValue));
            }
        });
        im2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentValue > 0) {
                    currentValue--;
                    gias = gia * currentValue;
                    txgia.setText(gias + "");
                    tx.setText(String.valueOf(currentValue));

                }
            }
        });


        dgg = new ArrayList<>();
        rcvDanhgia = findViewById(R.id.rcv_danhgia);
        dgg = getListdanhgia(maspp); // Initialize your listbook
        danhgiaAdapter = new danhgiaAdapter(ttspActivity.this, dgg); // Initialize the adapter with the original list
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rcvDanhgia.setLayoutManager(linearLayoutManager);
        rcvDanhgia.setAdapter(danhgiaAdapter);
        rcvDanhgia.setVerticalScrollBarEnabled(true);


//        dgg = new ArrayList<>();
//        dgg = getListdanhgia(maspp);
//        danhgia koko = dgg.get(0);
//        Toast.makeText(ttspActivity.this, "ds" + maspp, Toast.LENGTH_SHORT).show();





    }

    private ArrayList<danhgia> getListdanhgia(int masp) {

        dg = new ArrayList<>();
        dg = userDAO.getdanhgia(ttspActivity.this, masp);
        return dg;
    }
}
