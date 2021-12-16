package com.example.appnhaconline.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;


import com.example.appnhaconline.R;

import com.example.appnhaconline.Adapter.DanhSachBaiHatAdapter;
import com.example.appnhaconline.Model.Album;
import com.example.appnhaconline.Model.Baihat;
import com.example.appnhaconline.Model.Playlist;
import com.example.appnhaconline.Model.Quangcao;
import com.example.appnhaconline.Model.Theloai;
import com.example.appnhaconline.Service.APIService;
import com.example.appnhaconline.Service.DataService;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DanhsachbaihatActivity extends AppCompatActivity {
    CoordinatorLayout coordinatorLayout;
    CollapsingToolbarLayout collapsingToolbarLayout;
    Toolbar toolbar;
    RecyclerView recyclerViewdanhsachbaihat;
    FloatingActionButton floatingActionButton;
    Quangcao quangcao;
    ImageView imgdanhsachcakhuc;
    ArrayList<Baihat> mangbaihat;
    DanhSachBaiHatAdapter danhsachbaihatAdapter;
    Playlist playlist;
    Theloai theLoai;
    Album album;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_bai_hat);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        DataIntent();
        anhxa();
        unit();
        if (quangcao != null && !quangcao.getTenBaiHat().equals("")) {
            setValueInView(quangcao.getTenBaiHat(), quangcao.getHinhBaiHat());
            GetDataQuangcao(quangcao.getIdquangcao());
        }
        if (playlist != null && !playlist.getTen().equals("")) {
            setValueInView(playlist.getTen(), playlist.getHinhNen());
            GetDataPlaylist(playlist.getIDplaylist());
        }
        if (theLoai != null && !theLoai.getTentheloai().equals("")) {
            setValueInView(theLoai.getTentheloai(), theLoai.getHinhtheloai());
            GetDataTheLoai(theLoai.getIDtheloai());
        }
//        if(album !=null && !album.getTenalbum().equals("")){
//            setValueInView(album.getTenalbum(), album.getHinhalbum());
//            GetDataAlbum(album.getIdalbum());
//        }

    }


 /*   private void GetDataAlbum(String idAlbum) {
        DataService dataservice = APIService.getService();
        Call<List<Baihat>> callback = dataservice.GetDanhsachbaihatheoalbum(idAlbum);
        callback.enqueue(new Callback<List<Baihat>>() {
            @Override
            public void onResponse(Call<List<Baihat>> call, Response<List<Baihat>> response) {
                mangbaihat = (ArrayList<Baihat>) response.body();
                danhsachbaihatAdapter = new DanhsachbaihatAdapter(DanhsachbaihatActivity.this, mangbaihat);
                recyclerViewdanhsachbaihat.setLayoutManager(new LinearLayoutManager(DanhsachbaihatActivity.this));
                recyclerViewdanhsachbaihat.setAdapter(danhsachbaihatAdapter);
                eventClick();
            }
            @Override
            public void onFailure(Call<List<Baihat>> call, Throwable t) {

            }
        });

    }
*/
    private void GetDataTheLoai(String idtheloai){
        DataService dataservice = APIService.getService();
        Call<List<Baihat>> callback = dataservice.GetDSBaiHatTheoTheLoai(idtheloai);
        callback.enqueue(new Callback<List<Baihat>>() {
            @Override
            public void onResponse(Call<List<Baihat>> call, Response<List<Baihat>> response) {
                mangbaihat = (ArrayList<Baihat>) response.body();
                danhsachbaihatAdapter = new DanhSachBaiHatAdapter(DanhsachbaihatActivity.this, mangbaihat);
                recyclerViewdanhsachbaihat.setLayoutManager(new LinearLayoutManager(DanhsachbaihatActivity.this));
                recyclerViewdanhsachbaihat.setAdapter(danhsachbaihatAdapter);
//                eventClick();
            }
            @Override
            public void onFailure(Call<List<Baihat>> call, Throwable t) {
            }
        });
    }



    private void GetDataPlaylist(String idplaylist) {
        DataService dataservice = APIService.getService()  ;
        Call<List<Baihat>> callback = dataservice.GetDSBaiHatTheoPlaylist(idplaylist);
        callback.enqueue(new Callback<List<Baihat>>() {
            @Override
            public void onResponse(Call<List<Baihat>> call, Response<List<Baihat>> response) {
                mangbaihat = (ArrayList<Baihat>) response.body();
                danhsachbaihatAdapter = new DanhSachBaiHatAdapter(DanhsachbaihatActivity.this, mangbaihat);
                recyclerViewdanhsachbaihat.setLayoutManager(new LinearLayoutManager(DanhsachbaihatActivity.this));
                recyclerViewdanhsachbaihat.setAdapter(danhsachbaihatAdapter);
//                eventClick();
            }
            @Override
            public void onFailure(Call<List<Baihat>> call, Throwable t) {
            }
        });
    }


    private void setValueInView(String ten, String hinh) {
        collapsingToolbarLayout.setTitle(ten);
        try{
            URL url = new URL(hinh);
            Bitmap bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(),bitmap);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN){
                collapsingToolbarLayout.setBackground(bitmapDrawable);
            }
        } catch (MalformedURLException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Picasso.with(this).load(hinh).into(imgdanhsachcakhuc );
    }
    private void GetDataQuangcao(String idQuangCao) {
        final DataService dataservice = APIService.getService();
        Call<List<Baihat>> callback = dataservice.GetDSBaiHatTheoQuangCao(idQuangCao);
        callback.enqueue(new Callback<List<Baihat>>() {
            @Override
            public void onResponse(Call<List<Baihat>> call, Response<List<Baihat>> response) {
                mangbaihat = (ArrayList<Baihat>) response.body();
               danhsachbaihatAdapter = new DanhSachBaiHatAdapter(DanhsachbaihatActivity.this, mangbaihat);
                recyclerViewdanhsachbaihat.setLayoutManager(new LinearLayoutManager(DanhsachbaihatActivity.this));
               recyclerViewdanhsachbaihat.setAdapter(danhsachbaihatAdapter);
//                eventClick();
            }
            @Override
            public void onFailure(Call<List<Baihat>> call, Throwable t) {
            }
        });
    }


    private void unit() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        collapsingToolbarLayout.setExpandedTitleColor(Color.WHITE);
        collapsingToolbarLayout.setCollapsedTitleTextColor(Color.WHITE);
        floatingActionButton.setEnabled(false);    }

    private void anhxa() {
        coordinatorLayout = findViewById(R.id.coordinatorlayout);
        collapsingToolbarLayout = findViewById(R.id.collapsingtoolbar);
        toolbar = findViewById(R.id.toolbardanhsach);
        recyclerViewdanhsachbaihat = findViewById(R.id.recyclerviewdanhsachbaihat);
        floatingActionButton = findViewById(R.id.floatingactionbutton);
        imgdanhsachcakhuc = findViewById(R.id.imageviewdanhsachcakhuc);
    }

    private void DataIntent() {
        Intent intent = getIntent() ;
        if (intent != null){
            if (intent.hasExtra("banner")){
                quangcao = (Quangcao) intent.getSerializableExtra("banner");
                Toast.makeText(this, quangcao.getTenBaiHat(),Toast.LENGTH_SHORT).show();
            }
            if (intent.hasExtra("itemplaylist")){
                playlist = (Playlist) intent.getSerializableExtra("itemplaylist");
                Toast.makeText(this, playlist.getTen(),Toast.LENGTH_SHORT).show();
            }
            if (intent.hasExtra("idtheloai")){
                theLoai = (Theloai) intent.getSerializableExtra("idtheloai");
                Toast.makeText(this, theLoai.getTentheloai(),Toast.LENGTH_SHORT).show();
            }
//            if (intent.hasExtra("album")){
//                album = (Album) intent.getSerializableExtra("album");
//                Toast.makeText(this, album.getTenAlbum(),Toast.LENGTH_SHORT).show();
//            }

        }
    }
//    private void eventClick(){
//        floatingActionButton.setEnabled(true);
//        floatingActionButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(DanhsachbaihatActivity.this, PlayNhacActivity.class);
//                intent.putExtra("cacbaihat",mangbaihat);
//                startActivity(intent);
//            }
//        });
//    }
}