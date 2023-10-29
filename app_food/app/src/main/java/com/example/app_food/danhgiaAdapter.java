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

public class danhgiaAdapter extends RecyclerView.Adapter<danhgiaAdapter.DanhgiaViewHolder>{

    private ArrayList<danhgia> mBooks;
    private Context context;
    public void setData(ArrayList<danhgia> list){
        this.mBooks = list;

        notifyDataSetChanged();
    }
    public danhgiaAdapter(Context context,ArrayList<danhgia> list){
        this.mBooks = list;
        this.context = context;


    }
    @NonNull
    @Override
    public DanhgiaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itembook4, parent, false);
        return new DanhgiaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DanhgiaViewHolder holder, int position) {

        danhgia book = mBooks.get(position);
        if (book == null){
            return;
        }
        holder.txgmail.setText(book.getTaikhoanuser());
        holder.txdanhgia.setText(book.getDanhgia());
        holder.txsao.setText(book.getSosao() + "");
    }

    @Override
    public int getItemCount() {
        if (mBooks != null)
        {
            return mBooks.size();
        }
        return 0;
    }

    public class DanhgiaViewHolder extends RecyclerView.ViewHolder{


        private TextView txgmail;
        private TextView txdanhgia;
        private TextView txsao;
        private CardView cd;

        public DanhgiaViewHolder(@NonNull View itemView) {
            super(itemView);
            cd = itemView.findViewById(R.id.layout_item3);
            txgmail = itemView.findViewById(R.id.txgmail);
            txdanhgia = itemView.findViewById(R.id.txdanhgiaa);
            txsao = itemView.findViewById(R.id.txsao);

        }
    }
}
