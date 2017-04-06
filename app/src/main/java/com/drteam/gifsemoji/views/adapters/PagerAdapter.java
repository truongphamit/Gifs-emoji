package com.drteam.gifsemoji.views.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.drteam.gifsemoji.models.Category;

import java.util.List;

/**
 * Created by truongpq on 06/04/2017.
 */

public class PagerAdapter extends FragmentPagerAdapter {
    private Context context;

    List<Fragment> fragments;
    List<Category> categories;

    public PagerAdapter(FragmentManager fm, Context context, List<Fragment> fragments, List<Category> categories) {
        super(fm);
        this.context = context;
        this.fragments = fragments;
        this.categories = categories;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return categories.get(position).getName();
    }
}
