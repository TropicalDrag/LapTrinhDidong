package com.example.appnhaconline.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.appnhaconline.Adapter.MainViewPagerAdapter;
import com.example.appnhaconline.Fragment.Fragment_TimKiem;
import com.example.appnhaconline.Fragment.Fragment_TrangChu;
import com.example.appnhaconline.R;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        init();
    }
    private void init(){
        MainViewPagerAdapter mainViewPagerAdapter = new MainViewPagerAdapter(getSupportFragmentManager());
        mainViewPagerAdapter.addFragment(new Fragment_TrangChu(), "Trang Chủ");
        mainViewPagerAdapter.addFragment(new Fragment_TimKiem(), "Tìm Kiếm");
        viewPager.setAdapter(mainViewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.icontrangchu);
        tabLayout.getTabAt(1).setIcon(R.drawable.icontimkiem);
    }
    private void anhxa(){
        tabLayout = (TabLayout) findViewById(R.id.myTabLayout);
        viewPager = (ViewPager) findViewById(R.id.myViewPager);
    }
}