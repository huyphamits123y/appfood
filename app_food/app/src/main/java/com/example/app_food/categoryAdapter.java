//package com.example.app_food;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.app_food.bookAdapter;
//
//import java.util.List;
//
//public class categoryAdapter extends RecyclerView.Adapter<categoryAdapter.CategoryViewHolder>{
//    private Context context;
//    private List<category> mListCategory;
//
//    public categoryAdapter(Context context) {
//        this.context = context;
//    }
//    public void setData(List<category> list){
//        this.mListCategory = list;
//        notifyDataSetChanged();
//
//    }
//    @NonNull
//    @Override
//    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, parent, false);
//        return new CategoryViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
//
//        category category = mListCategory.get(position);
//        if (category == null){
//            return;
//        }
//        holder.tvNameCategory.setText(category.getNameCategory());
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context,RecyclerView.HORIZONTAL, false);
//        holder.rcvBook.setLayoutManager(linearLayoutManager);
//        bookAdapter bookAdapter = new bookAdapter();
//        bookAdapter.setData(category.getBooks());
//        holder.rcvBook.setAdapter(bookAdapter);
//    }
//
//    @Override
//    public int getItemCount() {
//        if (mListCategory != null){
//            return mListCategory.size();
//        }
//        return 0;
//    }
//
//    public class CategoryViewHolder extends RecyclerView.ViewHolder{
//
//        private TextView tvNameCategory;
//        private RecyclerView rcvBook;
//        public CategoryViewHolder(@NonNull View itemView) {
//            super(itemView);
//            tvNameCategory = itemView.findViewById(R.id.tv_name_category);
//            rcvBook = itemView.findViewById(R.id.rcv_book);
//        }
//    }
//}
