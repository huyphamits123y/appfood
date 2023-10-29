package com.example.app_food;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class book3Adapter extends RecyclerView.Adapter<book3Adapter.Book3ViewHolder>{
    private Context context;
    private ArrayList<book3> bk3;
    public void setData(ArrayList<book3> list){
        this.bk3 = list;
        notifyDataSetChanged();
    }
    public book3Adapter(Context context,ArrayList<book3> mBooks){

        this.bk3 = mBooks;

        this.context = context;


    }
    @NonNull
    @Override
    public Book3ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itembook3, parent, false);
        return new book3Adapter.Book3ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Book3ViewHolder holder, int position) {

        book3 book3s = bk3.get(position);
        if (book3s == null){
            return;
        }
        holder.imgBook.setImageResource(book3s.getHinhanh());
        holder.tt1.setText(book3s.getTensanpham());
        holder.tt2.setText("x"+book3s.getSoluong());
        holder.tt3.setText(book3s.getNgaydathang());
        holder.tt4.setText(book3s.getGiatien() + " ");
        holder.tt5.setText(book3s.getTongtien() + " ");
    }

    @Override
    public int getItemCount() {
        if (bk3 != null)
        {
            return bk3.size();
        }
        return 0;
    }

    public class Book3ViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgBook;
        private TextView tt1;
        private TextView tt2;
        private CardView cd1;
        private TextView tt3;
        private TextView tt4;
        private TextView tt5;

        public Book3ViewHolder(@NonNull View itemView) {
            super(itemView);
            cd1 = itemView.findViewById(R.id.layout_item2);
            imgBook = itemView.findViewById(R.id.img_itembook3);
            tt1 = itemView.findViewById(R.id.tensanpham);
            tt2 = itemView.findViewById(R.id.soluong);
            tt3 = itemView.findViewById(R.id.date);
            tt4 = itemView.findViewById(R.id.giatien);
            tt5 = itemView.findViewById(R.id.tonggiatien);



        }
    }
}
