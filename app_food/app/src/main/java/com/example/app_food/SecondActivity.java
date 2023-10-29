package com.example.app_food;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.app_food.databinding.ActivityMainBinding;
import com.example.app_food.databinding.ActivitySecondBinding;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    GoogleSignInOptions gso;
    //    TextView name, email;
//    ArrayAdapter adapter;
    Button signOutBtn;
    bookAdapter bookAdapter;
    ArrayList<book> listbook;
    ArrayList<book1> listbookss;
    book1Adapter book1Adapter;
    int click = 0;
    int o = 0;
    ArrayList<Integer> lb;
    book bkj;
    int search = 0;
    String kytu = "";





    ArrayList<user> us;
    GoogleSignInClient gsc;
    ActivitySecondBinding binding;
    category1Adapter category1Adapter;

//    ArrayList<book1> bkb;
    EditText ed;
    TextView  tx1;
    String personName;
    public static String personEmail;
    ArrayList<category1> listcategoryss;
    int masp;


    FloatingActionButton fab;
    private RecyclerView rcvCategory;
    private RecyclerView rcvCategory1;
    Button btn;
    SearchView searchView;

//    TextView txv;


//    ImageView huy;








//     private categoryAdapter categoryAdapter;

    //    ListView lv;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.home){
                Toast.makeText(this, "This is a short toast message", Toast.LENGTH_SHORT).show();

            }
            else
            if (item.getItemId() == R.id.shorts)
            {
                Intent intent = new Intent(SecondActivity.this, giohangActivity.class);

                intent.putExtra("taikhoanuser", personEmail);

                startActivity(intent);
            }
            else
            if (item.getItemId() == R.id.subscriptions){
                Intent intent = new Intent(SecondActivity.this, danhgiaActivity.class);
                intent.putExtra("taikhoanuser", personEmail);
                startActivity(intent);
            }
            else
            {
                Intent intent = new Intent(SecondActivity.this, lichsuActivity.class);

                intent.putExtra("taikhoanuser", personEmail);

                startActivity(intent);
            }

            return true;
        });



         fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (personEmail.equals("huyzxv123@gmail.com")){
                    Intent intent = new Intent(SecondActivity.this, adminActivity.class);
                    startActivity(intent);
                }
            }
        });
//        setContentView(R.layout.activity_second);
//        name = findViewById(R.id.name);
//        email = findViewById(R.id.email);



//                btn = (Button)findViewById(R.id.huyy);
//        btn.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                //                //        masanpham, tensanpham, giatien, hinhanh, danhgia, madanhmuc
//                String a = "img_18";
//                int b = userDAO.intm(SecondActivity.this, a);
//                if (userDAO.insertsanpham(SecondActivity.this, "Sting", 20000, b, "nuoc ngot", 4)){
//                    Toast.makeText(SecondActivity.this, "them thanh cong", Toast.LENGTH_SHORT).show();
//                }
//                else
//                    Toast.makeText(SecondActivity.this, "them that bai", Toast.LENGTH_SHORT).show();
//
//
//
//            }
//        });











//
        rcvCategory = findViewById(R.id.rcv_category);
        listbook = getListCategory(); // Initialize your listbook
        book bestSellingProduct = findBestSellingProduct(listbook);
        if (bestSellingProduct != null){
            bestSellingProduct.setIsBestSeller(1);
        }
        bookAdapter = new bookAdapter(SecondActivity.this, listbook); // Initialize the adapter with the original list
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rcvCategory.setLayoutManager(linearLayoutManager);
        rcvCategory.setAdapter(bookAdapter);
        rcvCategory.setVerticalScrollBarEnabled(true);

//
//
//
        rcvCategory1 = findViewById(R.id.rcv_category1);
        book1Adapter book1Adapter = new book1Adapter(SecondActivity.this, listbookss);
        category1Adapter = new category1Adapter(this, listcategoryss, listbookss);
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rcvCategory1.setLayoutManager(linearLayoutManager1);
        category1Adapter.setData(getListCategory1());
        rcvCategory1.setAdapter(category1Adapter);
        //
        //
        //
        //

        ///
        ///
        ///
        ///
        category1Adapter.setOnBookItemClickListener(new category1Adapter.OnBookItemClickListener() {
            @Override
            public void onBookItemClick(int categoryPosition, int bookPosition) {
//                Toast.makeText(MainActivity.this, "thanh cong", Toast.LENGTH_SHORT).show();
                book1 selectedBook = listbookss.get(bookPosition);
                filterData(selectedBook.getMadanhmuc());
                click++;
                o = bookPosition;
            }
        });
        ///
        ///
        ///
        bookAdapter.setOnItemClickListener(new bookAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                if (search != 0 && kytu != null && !kytu.isEmpty()){
                    for (int i = 0; i < searchBooks(kytu).size(); i++){
                        if (position == i)
                        {
                            bkj = listbook.get(searchBooks(kytu).get(i));
                        }
                    }
                    Intent intent = new Intent(SecondActivity.this, ttspActivity.class);
                    String a = bkj.getTensanpham();
                    int masp1 = bkj.getMasanpham();
                    intent.putExtra("taikhoanuser", personEmail);
                    intent.putExtra("tensanpham", a);
                    intent.putExtra("masanpham", masp1);
                    startActivity(intent);
                }
                else if (search == 0  && click == 0){
                    Intent intent = new Intent(SecondActivity.this, ttspActivity.class);
                    book bki = listbook.get(position);
                    int masp2 = bki.getMasanpham();
                    String a = bki.getTensanpham();
                    intent.putExtra("taikhoanuser", personEmail);
                    intent.putExtra("tensanpham", a);
                    intent.putExtra("masanpham", masp2);
                    startActivity(intent);

                }else {
                    book1 selectedBook = listbookss.get(o);
                    Intent intent = new Intent(SecondActivity.this, ttspActivity.class);
                    lb = filterDatas(selectedBook.getMadanhmuc());
                    for (int i = 0; i < lb.size(); i++)
                    {
                        if (position == i)
                        {
                            bkj = listbook.get(lb.get(i));
                        }
                    }
                    String a = bkj.getTensanpham();
                   int  masp3 = bkj.getMasanpham();
                    intent.putExtra("taikhoanuser", personEmail);
                    intent.putExtra("tensanpham", a);
                    intent.putExtra("masanpham", masp3);
                    startActivity(intent);
                }
            }
        });
//
        //
        //
        //
        //
        //
        //









        searchView = findViewById(R.id.searchView);
        searchView.clearFocus();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                search++;
                kytu = newText.toLowerCase();
                fileListzz(newText);
                return true;
            }
        });


//        btn = (Button) findViewById(R.id.huyy);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //        masanpham, tensanpham, giatien, hinhanh, danhgia, madanhmuc
//                String a = "img_9";
//                int b = userDAO.intm(SecondActivity.this, a);
//                if (userDAO.insertsanpham(SecondActivity.this, "Pizza gà", 150000, b, "vip", 0)){
//                    Toast.makeText(SecondActivity.this, "them thanh cong", Toast.LENGTH_SHORT).show();
//                }
//                else
//                    Toast.makeText(SecondActivity.this, "them that bai", Toast.LENGTH_SHORT).show();
//
//
//            }
//        });









        signOutBtn = findViewById(R.id.signout);
        us = new ArrayList<>();
        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc = GoogleSignIn.getClient(this, gso);
//        lv = (ListView)findViewById(R.id.lv);
//        us = userDAO.getAll(SecondActivity.this);
//        adapter = new ArrayAdapter(SecondActivity.this, android.R.layout.simple_expandable_list_item_1, us);
//        lv.setAdapter(adapter);

        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);

        if (acct != null) {
            personName = acct.getDisplayName();
            personEmail = acct.getEmail();
//            taikhoanuser text PRIMARY KEY, hoten text, diachi text, sdt INTEGER

            if (userDAO.insertuser(SecondActivity.this, personEmail, personName,"...", 123)){
                Toast.makeText(SecondActivity.this, "Them moi thanh cong", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(SecondActivity.this, "Them moi that bai", Toast.LENGTH_SHORT).show();
            }

        }
        tx1= (TextView)findViewById(R.id.tenmail);
        tx1.setText(personName);
        signOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signOut();
            }
        });

    }

    void signOut() {
        gsc.signOut().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(Task<Void> task) {
                finish();
                startActivity(new Intent(SecondActivity.this, MainActivity.class));

            }
        });
    }

    private ArrayList<book> getListCategory() {

         listbook = new ArrayList<>();
//        masanpham, tensanpham, giatien, hinhanh, danhgia, madanhmuc
//        listbook.add(new book(R.drawable.img_8, "Pepperoni Pizza", "Chese Burger"));
//        listbook.add(new book(R.drawable.img_8, "Pepperoni Pizza", "Chese Burger"));
//        listbook.add(new book(R.drawable.img_8, "Pepperoni Pizza", "Chese Burger"));
//        listbook.add(new book(R.drawable.img_8, "Pepperoni Pizza", "Chese Burger"));
//        listbook.add(new book(R.drawable.img_8, "Pepperoni Pizza", "Chese Burger"));
//        listbook.add(new book(1, "Pepperoni Pizza", 120000, R.drawable.img_3, "vip", 0));
//
//        listbook.add(new book(1, "ab", 120000, R.drawable.img_3, "vip", 0));
//        listbook.add(new book(1, "bca", 120000, R.drawable.img_3, "vip", 0));
//        listbook.add(new book(1, "c", 120000, R.drawable.img_3, "vip", 0));
//        listbook.add(new book(1, "d", 120000, R.drawable.img_3, "vip", 0));
        listbook = userDAO.getsanphams11(SecondActivity.this);
//        if (book1Adapter.mas == 100){
//            listbook = userDAO.getsanphams(SecondActivity.this);
//
//        }
//        else{
//            listbook = userDAO.getsanphams1(SecondActivity.this, book1Adapter.mas);
//
//        }





        return listbook;
    }
    private ArrayList<category1> getListCategory1() {
          listcategoryss = new ArrayList<>();
          listbookss = new ArrayList<>();

//         String a = "img_9";
//        int resId = ((Activity)SecondActivity.this).getResources().getIdentifier(a, "drawable", ((Activity)SecondActivity.this).getPackageName());
//         listbookss.add(new book1(1, resId, "huy"));
//        listbookss.add(new book1(2, resId, "huy"));
//        listbookss.add(new book1(3, resId, "huy"));
//        listbookss.add(new book1(4, resId, "huy"));

//        byte[] img3Bytes = getByteArrayFromDrawable(SecondActivity.this,R.drawable.img_3);
//        Bitmap img3Bitmap = BitmapFactory.decodeByteArray(img3Bytes, 0, img3Bytes.length);
//        byte[] img5Bytes = getByteArrayFromDrawable(SecondActivity.this,R.drawable.img_5);
//        Bitmap img5Bitmap = BitmapFactory.decodeByteArray(img5Bytes, 0, img5Bytes.length);
//        byte[] img6Bytes = getByteArrayFromDrawable(SecondActivity.this,R.drawable.img_6);
//        Bitmap img6Bitmap = BitmapFactory.decodeByteArray(img6Bytes, 0, img6Bytes.length);
//        byte[] img7Bytes = getByteArrayFromDrawable(SecondActivity.this,R.drawable.img_7);
//        Bitmap img7Bitmap = BitmapFactory.decodeByteArray(img7Bytes, 0, img7Bytes.length);
//         listbook.add(new book1(1, img3Bitmap, "pizza"));
//        listbook.add(new book1(2, img5Bitmap, "pizza"));
//        listbook.add(new book1(3, img6Bitmap, "pizza"));
//        listbook.add(new book1(4, img7Bitmap, "pizza"));
//        String a = "img_9";
//        int resId = ((Activity)SecondActivity.this).getResources().getIdentifier(a, "drawable", ((Activity)SecondActivity.this).getPackageName());
//        listbookss.add(new book1(9, resId, "pizza"));
//        listbookss.add(new book1(10, resId, "pizza"));
//        listbookss.add(new book1(11, resId, "pizza"));
//        listbookss.add(new book1(12, resId, "pizza"));
//        listbooks = userDAO.getdanhmuc(SecondActivity.this);
//        String ko = "img_6";
//        int kk = userDAO.ca(SecondActivity.this, ko);
//        if (userDAO.insert(SecondActivity.this, 100, kk, "huy100")){
//            Toast.makeText(SecondActivity.this, "them thanh cong", Toast.LENGTH_SHORT).show();
//        }
//        if (userDAO.insert(SecondActivity.this, 101, kk, "huy100")){
//            Toast.makeText(SecondActivity.this, "them thanh cong", Toast.LENGTH_SHORT).show();
//        }
//        if (userDAO.insert(SecondActivity.this, 102, kk, "huy100")){
//            Toast.makeText(SecondActivity.this, "them thanh cong", Toast.LENGTH_SHORT).show();
//        }
//        if (userDAO.insert(SecondActivity.this, 103, kk, "huy100")){
//            Toast.makeText(SecondActivity.this, "them thanh cong", Toast.LENGTH_SHORT).show();
//        }
//        bkb = new ArrayList<>();
//        bkb = userDAO.getdanhmuc(SecondActivity.this);
//        book1 book1 = bkb.get(0);
//        Toast.makeText(SecondActivity.this, "huuy"+book1.getHinhanh(), Toast.LENGTH_SHORT).show();


//        listbookss = userDAO.getdanhmuc(SecondActivity.this);
//        for (int i = 0; i < listbookss.size(); i++){
//            lb.add(new book1(listbookss.get(i).getMadanhmuc(), listbookss.get(i).getHinhanh(), listbookss.get(i).getTitle()));
//        }
//        String a = "img_9";
//        int resId = ((Activity)SecondActivity.this).getResources().getIdentifier(a, "drawable", ((Activity)SecondActivity.this).getPackageName());
//        for (int i = 0; i < listbookss.size(); i++){
//            lb.add(listbookss.get(i).getMadanhmuc(), listbookss.get(i).getHinhanh(), listbookss.get(i).getTitle());
//        }
        listbookss = userDAO.getdanhmuc(SecondActivity.this);
        listcategoryss.add(new category1("Danh mục", listbookss));
        return listcategoryss;
    }
    public ArrayList<Integer> searchBooks(String searchQuery) {
        ArrayList<Integer> resultIndexes = new ArrayList<>();

        if (searchQuery != null && !searchQuery.isEmpty()) {
            String query = searchQuery.toLowerCase().trim();

            for (int i = 0; i < listbook.size(); i++) {
                book currentBook = listbook.get(i);
                if (currentBook.getTensanpham().toLowerCase().contains(query)) {
                    resultIndexes.add(i);
                }
            }
        }

        return resultIndexes;
    }


    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }
    public byte[] getByteArrayFromDrawable(Context context, int drawableId) {
        // Chuyển đổi ID tài nguyên thành Drawable
        Drawable drawable = ContextCompat.getDrawable(context, drawableId);

        // Chuyển đổi Drawable thành Bitmap
        Bitmap bitmap = drawableToBitmap(drawable);

        // Chuyển đổi Bitmap thành mảng byte
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        return stream.toByteArray();
    }

    public Bitmap drawableToBitmap(Drawable drawable) {
        if (drawable == null) {
            return null;
        }

        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }

        int width = Math.max(drawable.getIntrinsicWidth(), 1);
        int height = Math.max(drawable.getIntrinsicHeight(), 1);

        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        drawable.setBounds(0, 0, width, height);
        drawable.draw(new Canvas(bitmap));

        return bitmap;
    }
    private void fileListzz(String newText) {
        List<book> filteredList = new ArrayList<>();
        for (book book : listbook){
            if (book.getTensanpham().toLowerCase().contains(newText.toLowerCase())){
                filteredList.add(book);
            }
        }
        if (filteredList.isEmpty()){
            Toast.makeText(this,"No data found", Toast.LENGTH_SHORT).show();
        }else
        {
            bookAdapter.setFilteredList(filteredList);
        }
    }
    private void filterData(int condition) {
        ArrayList<book> filteredData = new ArrayList<>();

        // Lọc dữ liệu từ listbook tương ứng với điều kiện (ví dụ: title)
        for (book book : listbook) {
            if (book.getMadanhmuc() == condition) {
                filteredData.add(book);
            }
        }

        // Cập nhật dữ liệu cho RecyclerView hiện tại
        bookAdapter.setData(filteredData);
    }
    private ArrayList<Integer> filterDatas(int condition) {
        ArrayList<Integer> filteredPositions = new ArrayList<>();

        // Lọc dữ liệu từ listbook tương ứng với điều kiện (ví dụ: madanhmuc)
        for (int i = 0; i < listbook.size(); i++) {
            book book = listbook.get(i);
            if (book.getMadanhmuc() == condition) {
                filteredPositions.add(i);
            }
        }

        // Trả về danh sách vị trí của các cuốn sách thỏa mãn điều kiện
        return filteredPositions;
    }
    private book findBestSellingProduct(List<book> productList) {
        book bestSellingProduct = null;
        int maxQuantity = -1;

        for (book product : listbook) {
            if (product.getSoluong() > maxQuantity) {
                maxQuantity = product.getSoluong();
                bestSellingProduct = product;
            }
        }

        return bestSellingProduct;
    }
}



