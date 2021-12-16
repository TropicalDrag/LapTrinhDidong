package com.example.appnhaconline.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.appnhaconline.Activity.DanhsachbaihatActivity;
import com.example.appnhaconline.Model.Quangcao;
import com.example.appnhaconline.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class BannerAdapter extends PagerAdapter {
    Context context;
    ArrayList<Quangcao> arrayListBanner;

    public BannerAdapter(Context context, ArrayList<Quangcao> arrayListBanner) {
        this.context = context;
        this.arrayListBanner = arrayListBanner;
    }

    @Override
    public int getCount() {
        return arrayListBanner.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_banner,null);
        ImageView IMback_banner = view.findViewById(R.id.ivbackbanner);
        ImageView IMsongbanner = view.findViewById(R.id.iv_banner);
        TextView TVtitlesongbanner = view.findViewById(R.id.tv_title_banner_song);
        TextView TVnoidung = view.findViewById(R.id.tv_noidung);


        Picasso.with(context).load(arrayListBanner.get(position).getHinhAnh()).into(IMback_banner);
        Picasso.with(context).load(arrayListBanner.get(position).getHinhBaiHat()).into(IMsongbanner);
        TVtitlesongbanner.setText(arrayListBanner.get(position).getTenBaiHat());
        TVnoidung.setText(arrayListBanner.get(position).getNoiDung());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  intent= new Intent(context, DanhsachbaihatActivity.class);
                intent.putExtra("banner",arrayListBanner.get(position));
                context.startActivity(intent);
            }
        });
        container.addView(view);
        return view;
        }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
