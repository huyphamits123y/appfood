package com.example.app_food;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.app_food.databinding.ActivityDanhgiaBinding;
import com.example.app_food.databinding.ActivitySecondBinding;

import java.util.ArrayList;

public class danhgiaActivity extends AppCompatActivity {

    ArrayList<book> list;
    Spinner spinner;
    private RatingBar ratingBar;
    private TextView textViewResult;
    danhgia danhgia;
    danhgiaAdapter danhgiaAdapter;
    ArrayList<danhgia> dg;
    private RecyclerView rcvDanhgia;
    int vitri = 0;
    Button btn;
    TextView tx1;
    int sosao = 0;
    String taikhoanuser ="";
    ActivityDanhgiaBinding binding;
    bookSpinAdapter bookSpinAdapter;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_danhgia);
        binding = ActivityDanhgiaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.home){
                Intent intent = new Intent(danhgiaActivity.this, SecondActivity.class);
                startActivity(intent);

            }
            else
            if (item.getItemId() == R.id.shorts)
            {
                Intent intent = new Intent(danhgiaActivity.this, giohangActivity.class);

                intent.putExtra("taikhoanuser", taikhoanuser);

                startActivity(intent);
            }
            else
            if (item.getItemId() == R.id.subscriptions){
//                Intent intent = new Intent(SecondActivity.this, danhgiaActivity.class);
//                startActivity(intent);
            }
            else
            {
                Intent intent = new Intent(danhgiaActivity.this, lichsuActivity.class);

                intent.putExtra("taikhoanuser", taikhoanuser);

                startActivity(intent);
            }

            return true;
        });
        if (getIntent().hasExtra("taikhoanuser")){
            taikhoanuser = getIntent().getStringExtra("taikhoanuser");
        }
        list = new ArrayList<>();
        list = userDAO.getsanphams11(danhgiaActivity.this);
        bookSpinAdapter = new bookSpinAdapter(this, R.layout.spinner,list);
        tx1 = (TextView)findViewById(R.id.eddanhgia);
        spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setAdapter(bookSpinAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                vitri = position;

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        ratingBar = findViewById(R.id.ratingBar);
        textViewResult = findViewById(R.id.textViewResult);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                // Xử lý khi người dùng đánh giá
                textViewResult.setText("Đánh giá: " + rating);
                sosao =  Math.round(rating);

            }
        });
//        sql = "CREATE TABLE danhgia(" +
//                "madanhgia INTEGER PRIMARY KEY AUTOINCREMENT, " +
//                "danhgia TEXT, " +
//                "masanpham INTEGER, " +
//                "sosao INTEGER, " +
//                "taikhoanuser TEXT, " +
//                "tensanpham TEXT, " +
//                "FOREIGN KEY (masanpham) REFERENCES sanphams1(masanpham), " +
//                "FOREIGN KEY (taikhoanuser) REFERENCES user(taikhoanuser)" +
//                ");";
//        db.execSQL(sql);
        btn = (Button) findViewById(R.id.btndanhgia);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                book bk = list.get(vitri);
                int masp = bk.getMasanpham();
                String tensp = bk.getTensanpham();
                String dg = tx1.getText().toString();
                if (userDAO.insertdanhgia(danhgiaActivity.this, dg, masp, sosao, SecondActivity.personEmail, tensp)){
                    Toast.makeText(danhgiaActivity.this, "them danh gia thanh cong", Toast.LENGTH_SHORT).show();
                }else
                {
                    Toast.makeText(danhgiaActivity.this, "them danh gia that bai", Toast.LENGTH_SHORT).show();
                }


            }
        });

    }
}