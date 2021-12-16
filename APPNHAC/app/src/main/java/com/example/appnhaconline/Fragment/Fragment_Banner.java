package com.example.appnhaconline.Fragment;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.appnhaconline.Adapter.BannerAdapter;
import com.example.appnhaconline.Model.Quangcao;
import com.example.appnhaconline.R;
import com.example.appnhaconline.Service.APIService;
import com.example.appnhaconline.Service.DataService;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_Banner extends Fragment {
    View view;
    ViewPager viewPager;
    CircleIndicator circleIndicator;
    BannerAdapter bannerAdapter;
    Runnable runnable;
    Handler handler;
    int current_item;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_banner,container,false);
        anhxa();
        getData();
        return view;
    }

    private void anhxa() {
        viewPager=  view.findViewById(R.id.viewpager);
        circleIndicator = view.findViewById(R.id.indicator);
    }

    private void getData() {
        DataService dataService = APIService.getService();
        Call<List<Quangcao>> callback= dataService.GetDataBanner();
        callback.enqueue(new Callback<List<Quangcao>>() {
            @Override
            public void onResponse(Call<List<Quangcao>> call, Response<List<Quangcao>> response) {
                ArrayList<Quangcao> banners = (ArrayList<Quangcao>) response.body();
                bannerAdapter = new BannerAdapter(getActivity(),banners);
                viewPager.setAdapter(bannerAdapter);
                circleIndicator.setViewPager(viewPager);
                handler =new Handler();
                runnable = new Runnable() {
                    @Override
                    public void run() {
                        current_item = viewPager.getCurrentItem();
                        current_item++;
                        if(current_item >= viewPager.getAdapter().getCount()){
                            current_item=0;
                        }
                        viewPager.setCurrentItem(current_item,true);
                        handler.postDelayed(runnable,4000);
                    }
                };
                handler.postDelayed(runnable,4000);
            }

            @Override
            public void onFailure(Call<List<Quangcao>> call, Throwable t) {

            }
        });
    }
}
