package com.example.app_food;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class category1Adapter extends RecyclerView.Adapter<category1Adapter.Category1ViewHolder>{
    private Context context;
    private ArrayList<category1> mListCategory;
    private ArrayList<book1> mbooks;
    public interface OnBookItemClickListener {
        void onBookItemClick(int categoryPosition, int bookPosition);
    }
    private OnBookItemClickListener onBookItemClickListener;
    public void setOnBookItemClickListener(OnBookItemClickListener listener) {
        this.onBookItemClickListener = listener;
    }

    public category1Adapter(Context context, ArrayList<category1> mListCategory, ArrayList<book1> mbooks) {
        this.context = context;
        this.mListCategory = mListCategory;
        this.mbooks = mbooks;

    }
    public void setData(ArrayList<category1> list){
        this.mListCategory = list;
        notifyDataSetChanged();

    }
    @NonNull
    @Override
    public Category1ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category1, parent, false);
        return new category1Adapter.Category1ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Category1ViewHolder holder, int position) {

        category1 category1 = mListCategory.get(position);
        if (category1 == null){
            return;
        }
        int a = position;
        holder.tvNameCategory1.setText(category1.getNameCategory());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context,RecyclerView.HORIZONTAL, false);
        holder.rcvBook1.setLayoutManager(linearLayoutManager);
        book1Adapter book1Adapter = new book1Adapter(context, mbooks);
        book1Adapter.setData(category1.getBooks());
        holder.rcvBook1.setAdapter(book1Adapter);
        book1Adapter.setOnItemClickListener(new book1Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(int bookPosition) {
                if (onBookItemClickListener != null) {
                    onBookItemClickListener.onBookItemClick(a, bookPosition);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        if (mListCategory != null){
            return mListCategory.size();
        }
        return 0;
    }

    public class Category1ViewHolder extends RecyclerView.ViewHolder{

        private TextView tvNameCategory1;
        private RecyclerView rcvBook1;
        public Category1ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNameCategory1 = itemView.findViewById(R.id.tv_name_category1);
            rcvBook1 = itemView.findViewById(R.id.rcv_book1);
        }
    }
}
