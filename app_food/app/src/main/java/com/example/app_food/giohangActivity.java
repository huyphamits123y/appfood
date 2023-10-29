package com.example.app_food;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.app_food.databinding.ActivityGiohangBinding;
import com.example.app_food.databinding.ActivityLichsuBinding;
import com.example.app_food.databinding.ActivitySecondBinding;

import java.util.ArrayList;

public class giohangActivity extends AppCompatActivity {

    RecyclerView rcv_giohang;
    String taikhoanuser = "";
    TextView tx1;
    TextView tx2;
    int tongtien1 = 0;
    int tongtien2 = 0;
    Button btnthanhtoan;
    ActivityGiohangBinding binding;
    book2Adapter book2Adapter;
    ArrayList<book2> bk = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_giohang);
        binding = ActivityGiohangBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.home){
                Intent intent = new Intent(giohangActivity.this, SecondActivity.class);
                startActivity(intent);

            }
            else
            if (item.getItemId() == R.id.shorts)
            {
                Intent intent = new Intent(giohangActivity.this, giohangActivity.class);

                intent.putExtra("taikhoanuser", taikhoanuser);

                startActivity(intent);
            }
            else
            if (item.getItemId() == R.id.subscriptions){
                Intent intent = new Intent(giohangActivity.this, danhgiaActivity.class);
                intent.putExtra("taikhoanuser", taikhoanuser);
                startActivity(intent);
            }
            else
            {
                Intent intent = new Intent(giohangActivity.this, lichsuActivity.class);

                intent.putExtra("taikhoanuser", taikhoanuser);

                startActivity(intent);
            }

            return true;
        });
        tx1 = (TextView) findViewById(R.id.tongtien1);
        tx2 = (TextView) findViewById(R.id.tongtien2);
        if (getIntent().hasExtra("taikhoanuser")){
            taikhoanuser = getIntent().getStringExtra("taikhoanuser");
        }
        rcv_giohang = findViewById(R.id.rcv_giohang);
        bk = list(); // Initialize your listbook
        book2Adapter = new book2Adapter(giohangActivity.this, bk); // Initialize the adapter with the original list
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rcv_giohang.setLayoutManager(linearLayoutManager);
        rcv_giohang.setAdapter(book2Adapter);
        rcv_giohang.setVerticalScrollBarEnabled(true);

        for (int i = 0; i < bk.size(); i++){
            book2 bko = bk.get(i);
            tongtien1 += bko.getTongtien();
        }
        tongtien2 = tongtien1 + 50000;
        tx1.setText(tongtien1 +"");
        tx2.setText(tongtien2 +"");
        btnthanhtoan = (Button) findViewById(R.id.thanhtoan);
        btnthanhtoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                idls INTEGER PRIMARY KEY, masanpham INTEGER, tensanpham text, giatien INTEGER, hinhanh INTEGER, soluong INTEGER, tongtien INTEGER, ngaydathang text, taikhoanuser text
                for (int i = 0; i < bk.size(); i++){
                    if (userDAO.insertlistls(giohangActivity.this, bk.get(i).getId(), bk.get(i).getMasanpham(), bk.get(i).getTensanpham(), bk.get(i).getGiatien(), bk.get(i).getHinhanh(), bk.get(i).getSoluong(), bk.get(i).getTongtien(), bk.get(i).getNgaydathang(), bk.get(i).getTaikhoanuser())){
                        Toast.makeText(giohangActivity.this, "...", Toast.LENGTH_SHORT).show();
                    }

                }
                Toast.makeText(giohangActivity.this, " thanh toan thanh cong", Toast.LENGTH_SHORT).show();
                userDAO.deletegiohang(giohangActivity.this);


            }
        });
    }
    public ArrayList<book2> list(){
        ArrayList<book2> bk = new ArrayList<>();
        bk = userDAO.getsanphams2(giohangActivity.this, taikhoanuser);
        return bk;
    }
}