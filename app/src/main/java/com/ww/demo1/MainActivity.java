package com.ww.demo1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yingzi on 2017/6/26.
 */

public class MainActivity extends AppCompatActivity {
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private MyFragmentPagerAdapter mPagerAdapter;
    List<String> tags = new ArrayList<String>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tags.add("test1");
        tags.add("test2");
        mTabLayout = (TabLayout) findViewById(R.id.tablelayout);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), tags);
        mViewPager.setAdapter(mPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.setTabMode(TabLayout.MODE_FIXED);
    }
}
