package com.ww.demo1;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yingzi on 2017/6/26.
 */
public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
    private List<String> tags;

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;

    }

    public MyFragmentPagerAdapter(FragmentManager fm, List<String> tags) {
        super(fm);
        if (tags != null && tags.size() > 0) {
            this.tags = tags;
        } else {
            this.tags = new ArrayList<>();

        }
    }

    @Override
    public Fragment getItem(int position) {
        return MyFragment.newInstance(tags.get(position).toString());
    }

    @Override
    public int getCount() {
        return tags.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tags.get(position).toString();
    }
}
