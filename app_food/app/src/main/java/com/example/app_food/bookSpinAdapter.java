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

public class bookSpinAdapter extends ArrayAdapter<book> {

    public static int number = 0;
    public bookSpinAdapter(@NonNull Context context, int resource, @NonNull List<book> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.spinner, parent, false);
        TextView tx2 = convertView.findViewById(R.id.txt2);
        book pb = this.getItem(position);
        number = position;
        if (pb != null){
            tx2.setText(pb.getTensanpham());
        }
        return convertView;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        TextView tx = convertView.findViewById(R.id.txt1);
        book pb = this.getItem(position);
        if (pb != null){
            tx.setText(pb.getTensanpham());
        }
        return convertView;
    }
}
