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

public class book2Adapter extends RecyclerView.Adapter<book2Adapter.Book2ViewHolder>{
    private Context context;
    private ArrayList<book2> bk2;
    public void setData(ArrayList<book2> list){
        this.bk2 = list;
        notifyDataSetChanged();
    }
    public book2Adapter(Context context,ArrayList<book2> mBooks){

        this.bk2 = mBooks;

        this.context = context;


    }
    @NonNull
    @Override
    public Book2ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itembook3, parent, false);
        return new book2Adapter.Book2ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Book2ViewHolder holder, int position) {
        book2 book2s = bk2.get(position);
        if (book2s == null){
            return;
        }
        holder.imgBook.setImageResource(book2s.getHinhanh());
        holder.tt1.setText(book2s.getTensanpham());
        holder.tt2.setText("x"+book2s.getSoluong());
        holder.tt3.setText(book2s.getNgaydathang());
        holder.tt4.setText(book2s.getGiatien() + " ");
        holder.tt5.setText(book2s.getTongtien() + " ");


    }



    @Override
    public int getItemCount() {
        if (bk2 != null)
        {
            return bk2.size();
        }
        return 0;
    }

    public class Book2ViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgBook;
        private TextView tt1;
        private TextView tt2;
        private CardView cd1;
        private TextView tt3;
        private TextView tt4;
        private TextView tt5;

        public Book2ViewHolder(@NonNull View itemView) {
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
