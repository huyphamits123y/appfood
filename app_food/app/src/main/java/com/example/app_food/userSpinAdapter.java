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

public class userSpinAdapter extends ArrayAdapter<user> {
    public userSpinAdapter(@NonNull Context context, int resource, @NonNull List<user> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.spinner2, parent, false);
        TextView tx2 = convertView.findViewById(R.id.txtaikhoanuser2);
        user pb = this.getItem(position);
        if (pb != null){
            tx2.setText(pb.getTaikhoanuser());
        }
        return convertView;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item2, parent, false);
        TextView tx = convertView.findViewById(R.id.txtaikhoanuser);
        user pb = this.getItem(position);
        if (pb != null){
            tx.setText(pb.getTaikhoanuser());
        }
        return convertView;
    }
}
