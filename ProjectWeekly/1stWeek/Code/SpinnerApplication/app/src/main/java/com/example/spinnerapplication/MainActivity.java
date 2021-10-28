package com.example.spinnerapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private Spinner spnCategory;
    private CategoryAdapter categoryAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spnCategory = findViewById(R.id.spinner_Category);
        categoryAdapter = new CategoryAdapter(this , R.layout.select_item, getListcategory());
        spnCategory.setAdapter(categoryAdapter);
        spnCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,categoryAdapter.getItem(i).getName(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    final List<Category> getListcategory(){
         List<Category> list = new ArrayList<>();
         list.add(new Category("Lập Trình Di Dong"));
         list.add(new Category("Lập Trình ASP.Net"));
         list.add(new Category("Lập Trình A.I"));
         list.add(new Category("Internet Of Things"));
        return list;
    }
}