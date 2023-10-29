package com.example.app_food;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_food.book;

import java.util.ArrayList;
import java.util.List;

public class bookAdapter extends RecyclerView.Adapter<bookAdapter.BookViewHolder> {
    private List<book> mBooks;
    private Context context;

    public void setData(List<book> list){
        this.mBooks = list;

        notifyDataSetChanged();
    }
    public bookAdapter(Context context,List<book> mBooks){
        this.mBooks = mBooks;
        this.context = context;


    }
    public void updateData(ArrayList<book> newData) {
        mBooks.clear();
        mBooks.addAll(newData);
        notifyDataSetChanged();
    }
    private bookAdapter.OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(bookAdapter.OnItemClickListener listener) {
        this.listener = listener;
    }
    public void setFilteredList(List<book> filteredList){
        this.mBooks = filteredList;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itembook, parent, false);
        return new BookViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        book book = mBooks.get(position);
        if (book == null){
            return;
        }
        holder.imgBook.setImageResource(book.getHinhanh());
        holder.tvTitle.setText(book.getTensanpham());
        String strNumber = String.valueOf(book.getGiatien());
        holder.titles.setText(strNumber);
        if (book.getIsBestSeller() == 1) {
            holder.tx.setText("Bán chạy");
            holder.tx.setVisibility(View.VISIBLE);
        } else {
            holder.tx.setVisibility(View.GONE);
        }
//        if (position == mBooks.size() - 1) {
//            holder.txx.setText("Sản phẩm mới");
//            holder.txx.setVisibility(View.VISIBLE);
//        } else {
//            holder.txx.setVisibility(View.GONE);
//        }


    }

    @Override
    public int getItemCount() {
        if (mBooks != null)
        {
            return mBooks.size();
        }
        return 0;
    }




    public class BookViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgBook;
        private TextView titles;
        private TextView tvTitle;
        private CardView cd;
        private TextView tx;
        private TextView txx;

        public BookViewHolder(@NonNull View itemView, final bookAdapter.OnItemClickListener listener) {
            super(itemView);
            cd = itemView.findViewById(R.id.layout_item);
            imgBook = itemView.findViewById(R.id.img_book);
            tvTitle = itemView.findViewById(R.id.tx_title);
            titles = itemView.findViewById(R.id.tx_titles);
            tx = itemView.findViewById(R.id.productStatusLabel);
            txx = itemView.findViewById(R.id.productStatusLabel11);
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
