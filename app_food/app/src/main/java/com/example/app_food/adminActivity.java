package com.example.app_food;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class adminActivity extends AppCompatActivity {

    Spinner spinner;
    Spinner spinner1;
    int vitriss = 0;
    int sanPhamId = 0;
    int madm = 0;

    Spinner spinner2;
    ArrayList<book1> list;
    userSpinAdapter userSpinAdapter;
    book3Adapter book3Adapter;
    ArrayList<Integer> listint;
    ArrayList<book> lists;
    ArrayList<book> lists1;

    TextView tx1;
    TextView tx2;
    ArrayList<user>user;
    book1SpinAdapter book1SpinAdapter;

    book2Adapter book2Adapter;
    Button btn;
    Button btn3;
    int madm1 = 0;
    int vitri1 = 0;
    Button btnquaylai;
    Button btnxoamonan;
    Button btnsuamonan;
    Button btn4;
    Button btn5;
    int vitri = 0;
//    ArrayList<book2> bk;
    ArrayList<book3> bk;
    RecyclerView rcvlichsu;
    bookSpinAdapter bookSpinAdapter;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        list = new ArrayList<>();
        list = userDAO.getdanhmuc(adminActivity.this);

        book1SpinAdapter = new book1SpinAdapter(this, R.layout.spinner1, list);
        spinner = (Spinner) findViewById(R.id.spinner1);
        spinner.setAdapter(book1SpinAdapter);


        lists = new ArrayList<>();
        lists = userDAO.getsanphams11(adminActivity.this);
        bookSpinAdapter = new bookSpinAdapter(this, R.layout.spinner, lists);
        spinner1 = (Spinner) findViewById(R.id.spinner2);
        spinner1.setAdapter(bookSpinAdapter);

        user = new ArrayList<>();
        user = userDAO.getuser(adminActivity.this);
        user u = user.get(0);
        String tk = u.getTaikhoanuser();
        userSpinAdapter = new userSpinAdapter(this, R.layout.spinner2, user);
       spinner2 = (Spinner) findViewById(R.id.spinner3);
       spinner2.setAdapter(userSpinAdapter);


       rcvlichsu = (RecyclerView)findViewById(R.id.rcv_lichsudonhang);

        bk = list(tk); // Initialize your listbook
        book3Adapter = new book3Adapter(adminActivity.this, bk); // Initialize the adapter with the original list
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rcvlichsu.setLayoutManager(linearLayoutManager);
        rcvlichsu.setAdapter(book3Adapter);
        rcvlichsu.setVerticalScrollBarEnabled(true);




        btn = (Button) findViewById(R.id.btnthemdanhmuc);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addanhmuc();
            }
        });
        btn3 = (Button) findViewById(R.id.btnthemmonan);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addmonan();

            }
        });
        Button btnsuamonan = (Button)findViewById(R.id.btnsuamonan);
        btnsuamonan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                suamonan();
            }
        });
        btnxoamonan = (Button)findViewById(R.id.btnxoamonan);
        btnxoamonan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                book bk = lists.get(vitri1);
                madm = bk.getMasanpham();
                if (userDAO.deletesanpham(adminActivity.this, madm)) {
                    Toast.makeText(adminActivity.this, "Xóa sản phẩm thành công", Toast.LENGTH_SHORT).show();
                    lists.clear();
                    lists.addAll(userDAO.getsanphams11(adminActivity.this));
                    bookSpinAdapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(adminActivity.this, "Xóa sản phẩm thất bại" , Toast.LENGTH_SHORT).show();
                }

            }
        });
        btnquaylai = (Button) findViewById(R.id.btnquaylai);
        btnquaylai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(adminActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                vitri = position;
                Toast.makeText(adminActivity.this, "vi tri" + vitri, Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                user u = user.get(position);
                String s = u.getTaikhoanuser();
                load(s);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                vitri1 = position;

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        btn4 = (Button) findViewById(R.id.btnsuadanhmuc);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                suadanhmuc();

            }
        });
        Button btn6 = (Button) findViewById(R.id.btnxoadanhmuc);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                book1 bki = list.get(vitri);
                madm = bki.getMadanhmuc();
                listint = filterDatas(madm);
                if (userDAO.delete(adminActivity.this, madm)) {
                    Toast.makeText(adminActivity.this, "xoa danh muc thanh cong", Toast.LENGTH_SHORT).show();
                    list.clear();
                    list.addAll(userDAO.getdanhmuc(adminActivity.this));
                    book1SpinAdapter.notifyDataSetChanged();

                    for (int i = 0; i < listint.size(); i++) {
                         sanPhamId = listint.get(i);
                        if (userDAO.deletesanpham(adminActivity.this, sanPhamId)) {
                            Toast.makeText(adminActivity.this, "Xóa sản phẩm thành công", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(adminActivity.this, "Xóa sản phẩm thất bại" , Toast.LENGTH_SHORT).show();
                        }
                    }
                    lists.clear();
                    lists.addAll(userDAO.getsanphams11(adminActivity.this));
                    bookSpinAdapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(adminActivity.this, "xoa san pham dua vao danh muc that bai", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void suadanhmuc(){
        AlertDialog.Builder builder = new AlertDialog.Builder(adminActivity.this);
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.suadanhmuc, null);
        builder.setView(view);
        Dialog dialog = builder.create();
        dialog.show();
        EditText ed3 = (EditText) view.findViewById(R.id.edithinhanhsua);
        EditText ed4 = (EditText) view.findViewById(R.id.editdanhmuccsua);
        btn5 = (Button)view.findViewById(R.id.btnsuadanhmuccc);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = ed3.getText().toString();
                int b = userDAO.intm(adminActivity.this, a);
                String c = ed4.getText().toString();

                if (userDAO.updatedanhmuc(adminActivity.this, b,c,vitri+1)){
                    Toast.makeText(adminActivity.this, "Sua danh muc thanh cong", Toast.LENGTH_SHORT).show();

                    list.clear();
                    list.addAll(userDAO.getdanhmuc(adminActivity.this));
                    book1SpinAdapter.notifyDataSetChanged();
//                    book1Adapter.updateData(list);
                    dialog.dismiss();
                }
                else {
                    Toast.makeText(adminActivity.this, "Sua danh muc that bai", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
    private void suamonan(){
        AlertDialog.Builder builder = new AlertDialog.Builder(adminActivity.this);
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.suamonan, null);
//        masanpham INTEGER PRIMARY KEY AUTOINCREMENT, tensanpham text, giatien INTEGER, hinhanh INTEGER, mota text, madanhmuc INTEGER, FOREIGN KEY (madanhmuc) REFERENCES huy(madanhmuc)
        builder.setView(view);
        Dialog dialog = builder.create();
        dialog.show();
        EditText ed6 = (EditText) view.findViewById(R.id.edittensanpham);
        EditText ed7 = (EditText) view.findViewById(R.id.editgiatien);
        EditText ed8 = (EditText) view.findViewById(R.id.edithinhanh);
        EditText ed9 = (EditText) view.findViewById(R.id.editmota);
        EditText ed10 = (EditText) view.findViewById(R.id.editmadanhmuc);


        btnsuamonan = (Button)view.findViewById(R.id.btnsuamonan);
        btnsuamonan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = ed6.getText().toString();
                String b = ed7.getText().toString();
                int bb = Integer.parseInt(b);
                String c = ed8.getText().toString();
                int cc = userDAO.intm(adminActivity.this, c);
                String d = ed9.getText().toString();
                String e = ed10.getText().toString();
                int ee = Integer.parseInt(e);
                book bk = lists.get(vitri1);
                madm1 = bk.getMasanpham();


                if (userDAO.updatemonan(adminActivity.this, a, bb,cc,d,ee, madm1)){
                    Toast.makeText(adminActivity.this, "Sua mon an thanh cong", Toast.LENGTH_SHORT).show();

                    lists.clear();
                    lists.addAll(userDAO.getsanphams11(adminActivity.this));
                    bookSpinAdapter.notifyDataSetChanged();
//                    book1Adapter.updateData(list);
                    dialog.dismiss();
                }
                else {
                    Toast.makeText(adminActivity.this, "Sua mon an that bai", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
    private void addanhmuc(){
        AlertDialog.Builder builder = new AlertDialog.Builder(adminActivity.this);
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.adddanhmuc, null);
        builder.setView(view);
        Dialog dialog = builder.create();
        dialog.show();
        tx1 = (TextView) view.findViewById(R.id.edithinhanh);
        tx2 = (TextView) view.findViewById(R.id.editdanhmucc);
        Button btn1 = (Button) view.findViewById(R.id.btnthemdanhmucc);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = tx1.getText().toString();
                int c = userDAO.intm(adminActivity.this, a);
                String b = tx2.getText().toString();
                if (userDAO.insert(adminActivity.this, c, b)){
                    Toast.makeText(adminActivity.this, "Them moi thanh cong", Toast.LENGTH_SHORT).show();

                    list.clear();
                    list.addAll(userDAO.getdanhmuc(adminActivity.this));
                    book1SpinAdapter.notifyDataSetChanged();
//                    book1Adapter.updateData(list);
                    dialog.dismiss();
                }
                else
                {
                    Toast.makeText(adminActivity.this, "That bai", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void addmonan(){
        AlertDialog.Builder builder = new AlertDialog.Builder(adminActivity.this);
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.addmonan, null);
        builder.setView(view);
        Dialog dialog = builder.create();
        dialog.show();
//        masanpham INTEGER PRIMARY KEY AUTOINCREMENT, tensanpham text, giatien INTEGER, hinhanh INTEGER, mota text, madanhmuc INTEGER
        TextView tx1 = (TextView) view.findViewById(R.id.edtensanpham);
        TextView tx2 = (TextView) view.findViewById(R.id.edgiatien);
        TextView tx3 = (TextView) view.findViewById(R.id.edhinhanh);
        TextView tx4 = (TextView) view.findViewById(R.id.edmota);
        TextView tx5 = (TextView) view.findViewById(R.id.edmadanhmuc);
        Button btn1 = (Button) view.findViewById(R.id.btnthemmonan);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = tx1.getText().toString();
                String b = tx2.getText().toString();
                int bb = Integer.parseInt(b);
                String c = tx3.getText().toString();
                int cc = userDAO.intm(adminActivity.this, c);
                String d = tx4.getText().toString();
                String e = tx5.getText().toString();
                int ee = Integer.parseInt(e);
                if (userDAO.insertsanpham(adminActivity.this, a,bb, cc,d,0,ee,0)){
                    Toast.makeText(adminActivity.this, "Them moi mon an thanh cong", Toast.LENGTH_SHORT).show();

                    lists.clear();
                    lists.addAll(userDAO.getsanphams11(adminActivity.this));
                    bookSpinAdapter.notifyDataSetChanged();
//                    book1Adapter.updateData(list);
                    dialog.dismiss();
                }
                else
                {
                    Toast.makeText(adminActivity.this, "That bai", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private ArrayList<Integer> filterDatas(int condition) {
        ArrayList<Integer> filteredPositions = new ArrayList<>();

        // Lọc dữ liệu từ listbook tương ứng với điều kiện (ví dụ: madanhmuc)
        for (int i = 0; i < lists.size(); i++) {
            book book = lists.get(i);
            if (book.getMadanhmuc() == condition) {
                filteredPositions.add(book.getMasanpham());
            }
        }

        // Trả về danh sách vị trí của các cuốn sách thỏa mãn điều kiện
        return filteredPositions;
    }
//    public ArrayList<book2> list(String taikhoanuser){
//        ArrayList<book2> bk = new ArrayList<>();
//        bk = userDAO.getsanphams2(adminActivity.this, taikhoanuser);
//        return bk;
//    }
public ArrayList<book3> list(String taikhoanuser){
    ArrayList<book3> bk = new ArrayList<>();
    bk = userDAO.getlichsu(adminActivity.this, taikhoanuser);
    return bk;
}
//    public void load(String tk){
//        ArrayList<book2> bk = list(tk); // Khởi tạo danh sách từ list(tk)
//        book2Adapter = new book2Adapter(adminActivity.this, bk); // Khởi tạo adapter với danh sách mới
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
//        rcvlichsu.setLayoutManager(linearLayoutManager);
//        rcvlichsu.setAdapter(book2Adapter);
//        rcvlichsu.setVerticalScrollBarEnabled(true);
//
//    }
public void load(String tk){
    ArrayList<book3> bk = list(tk); // Khởi tạo danh sách từ list(tk)
    book3Adapter = new book3Adapter(adminActivity.this, bk); // Khởi tạo adapter với danh sách mới
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
    rcvlichsu.setLayoutManager(linearLayoutManager);
    rcvlichsu.setAdapter(book3Adapter);
    rcvlichsu.setVerticalScrollBarEnabled(true);

}
}