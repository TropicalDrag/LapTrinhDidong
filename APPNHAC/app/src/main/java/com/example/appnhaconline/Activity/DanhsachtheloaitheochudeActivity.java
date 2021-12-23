package com.example.appnhaconline.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


import com.example.appnhaconline.Adapter.DanhsachtheloaitheochudeAdapter;
import com.example.appnhaconline.Model.Chude;
import com.example.appnhaconline.Model.Theloai;
import com.example.appnhaconline.R;
import com.example.appnhaconline.Service.APIService;
import com.example.appnhaconline.Service.DataService;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DanhsachtheloaitheochudeActivity extends AppCompatActivity {
    Chude chuDe;
    RecyclerView recyclerViewtheloaitheochude;
    Toolbar toolbartheloaiteochude;
    DanhsachtheloaitheochudeAdapter danhsachtheloaitheochudeAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhsachtheloaitheochude);
        GetIntent();
        init();
        GetData();
    }

    private void GetData() {
        DataService dataservice = APIService.getService();
        Call<List<Theloai>> callback = dataservice.GetTheloaitheoChude(chuDe.getIDchude());
        callback.enqueue(new Callback<List<Theloai>>() {
            @Override
            public void onResponse(Call<List<Theloai>> call, Response<List<Theloai>> response) {
                ArrayList<Theloai> mangtheloai = (ArrayList<Theloai>) response.body();
                danhsachtheloaitheochudeAdapter = new DanhsachtheloaitheochudeAdapter(DanhsachtheloaitheochudeActivity.this,mangtheloai);
                recyclerViewtheloaitheochude.setLayoutManager(new GridLayoutManager(DanhsachtheloaitheochudeActivity.this,2));
               recyclerViewtheloaitheochude.setAdapter(danhsachtheloaitheochudeAdapter);
            }
            @Override
            public void onFailure(Call<List<Theloai>> call, Throwable t) {
                Log.d("FFF","SAI ROI EM");
            }
        });
    }
    private void init() {
        recyclerViewtheloaitheochude = findViewById(R.id.recyclerviewtheloaitheochude);
        toolbartheloaiteochude = findViewById(R.id.toolbartheloaitheochude);
        setSupportActionBar(toolbartheloaiteochude);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(chuDe.getTenchude());
        toolbartheloaiteochude.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void GetIntent() {
        Intent intent = getIntent();
        if (intent.hasExtra("chude")){
            chuDe = (Chude) intent.getSerializableExtra("chude");
        }
    }
}