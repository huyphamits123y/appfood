package com.example.app_food;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class book1SpinAdapter extends ArrayAdapter<book1> {
    public book1SpinAdapter(@NonNull Context context, int resource, @NonNull List<book1> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.spinner1, parent, false);
        TextView tx2 = convertView.findViewById(R.id.txt2danhmuc);
        book1 pb = this.getItem(position);
        if (pb != null){
            tx2.setText(pb.getTitle());
        }
        return convertView;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item1, parent, false);
        TextView tx = convertView.findViewById(R.id.txt1danhmuc);
        book1 pb = this.getItem(position);
        if (pb != null){
            tx.setText(pb.getTitle());
        }
        return convertView;
    }
}
