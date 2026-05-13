package com.example.spinnerapplication;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Formatter;
import java.util.List;

public class CategoryAdapter extends  ArrayAdapter<Category>{

    public CategoryAdapter(@NonNull Context context, int resource, @NonNull List<Category> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.iteam_category,parent,false);
        TextView tvCategory = convertView.findViewById(R.id.tv_category);

        Category category = this.getItem(position);
        if (category!= null){
            tvCategory.setText(category.getName());
        }
        return convertView;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.select_item,parent,false);
        TextView tvItem= convertView.findViewById(R.id.tv_slected);

        Category category = this.getItem(position);
        if (category!= null){
            tvItem.setText(category.getName());
        }
        return convertView;
    }
}
