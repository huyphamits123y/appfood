package com.example.app_food;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class book1Adapter extends RecyclerView.Adapter<book1Adapter.Book1ViewHolder>{

    private Context context;

    private ArrayList<book1> mBooks;
    private ArrayList<book> mBook;

     private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }
    public void updateData(ArrayList<book1> newData) {
        mBooks.clear();
        mBooks.addAll(newData);
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public void setData(ArrayList<book1> list){
        this.mBooks = list;
        notifyDataSetChanged();
    }
    public book1Adapter(Context context,ArrayList<book1> mBooks){

        this.mBooks = mBooks;

        this.context = context;


    }


//    public void setOnItemClickListener(OnItemClickListener listener) {
//        this.listener = listener;
//    }
//    public interface OnItemClickListener {
//        void onItemClick(int filterCondition);
//    }
    @NonNull
    @Override
    public Book1ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itembook1, parent, false);
        return new Book1ViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull Book1ViewHolder holder, int position) {

        book1 book1s = mBooks.get(position);
        if (book1s == null){
            return;
        }
        holder.imgBook1.setImageResource(book1s.getHinhanh());
        holder.title1.setText(book1s.getTitle());


    }

    @Override
    public int getItemCount() {
        if (mBooks != null)
        {
            return mBooks.size();
        }
        return 0;
    }


    public class Book1ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgBook1;
        private CardView cd2;
        private TextView title1;
        public Book1ViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            imgBook1 = itemView.findViewById(R.id.img_book1);
            cd2 = itemView.findViewById(R.id.layout_item1);
            title1 = itemView.findViewById(R.id.tx_title1);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION && listener != null) {
                        listener.onItemClick(position);
                    }
                }
            });
        }
    }
}
