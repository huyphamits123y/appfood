package com.example.app_food;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.app_food.databinding.ActivityLichsuBinding;
import com.example.app_food.databinding.ActivitySecondBinding;

import java.util.ArrayList;

public class lichsuActivity extends AppCompatActivity {

    RecyclerView rcv;
    String taikhoanuser;
    TextView tx1;
    TextView tx2;
    TextView tx3;
    TextView tx4;
    ArrayList<book3> bk;
    Button btn;
    book3Adapter book3Adapter;
    ActivityLichsuBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_lichsu);
        binding = ActivityLichsuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.home){
//                Toast.makeText(this, "This is a short toast message", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(lichsuActivity.this, SecondActivity.class);
                startActivity(intent);

            }
            else
            if (item.getItemId() == R.id.shorts)
            {
                Intent intent = new Intent(lichsuActivity.this, giohangActivity.class);

                intent.putExtra("taikhoanuser", taikhoanuser);

                startActivity(intent);
            }
            else
            if (item.getItemId() == R.id.subscriptions){
                Intent intent = new Intent(lichsuActivity.this, danhgiaActivity.class);
                intent.putExtra("taikhoanuser", taikhoanuser);
                startActivity(intent);
            }
//            else
//            {
//                Intent intent = new Intent(lichsuActivity.this, lichsuActivity.class);
//
//                intent.putExtra("taikhoanuser", personEmail);
//
//                startActivity(intent);
//            }

            return true;
        });
        if (getIntent().hasExtra("taikhoanuser")){
            taikhoanuser = getIntent().getStringExtra("taikhoanuser");
        }
        rcv = (RecyclerView)findViewById(R.id.rcv_lichsudonhang1);
        bk = new ArrayList<>();

        bk = list(taikhoanuser); // Initialize your listbook
        book3Adapter = new book3Adapter(lichsuActivity.this, bk); // Initialize the adapter with the original list
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rcv.setLayoutManager(linearLayoutManager);
        rcv.setAdapter(book3Adapter);
        rcv.setVerticalScrollBarEnabled(true);
        btn = (Button)findViewById(R.id.map);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(lichsuActivity.this, mapActivity.class);
                startActivity(intent);

            }
        });



    }
    public ArrayList<book3> list(String taikhoanuser){
        ArrayList<book3> bk = new ArrayList<>();
        bk = userDAO.getlichsu(lichsuActivity.this, taikhoanuser);
        return bk;
    }
}