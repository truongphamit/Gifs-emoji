package com.drteam.gifsemoji;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.drteam.gifsemoji.API.GifsApi;
import com.drteam.gifsemoji.API.GifsServices;
import com.drteam.gifsemoji.controller.HTTPController;
import com.drteam.gifsemoji.fragments.TagFragment;
import com.drteam.gifsemoji.models.Category;
import com.drteam.gifsemoji.models.searchdetail.SearchResult;
import com.drteam.gifsemoji.utils.Utils;
import com.drteam.gifsemoji.views.adapters.PagerAdapter;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tabs)
    TabLayout tabs;

    @BindView(R.id.viewpager)
    ViewPager viewpager;

    private List<Category> categories;
    private GifsServices gifsServices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        init();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    private void init() {
        gifsServices = GifsApi.getCoreServices();

        categories = loadDataFiles();

        List<Fragment> fragments = new ArrayList<>();
        for (int i = 0; i < categories.size(); i++) {
            fragments.add(TagFragment.newInstance(categories.get(i)));
        }

        viewpager.setAdapter(new PagerAdapter(getSupportFragmentManager(), this, fragments, categories));
        tabs.setupWithViewPager(viewpager);
    }

    private List<Category> loadDataFiles() {
        List<Category> categories = new ArrayList<>();
        try {
            String jsonFile = Utils.loadJSONFromAsset(this, "categories.json");
            JSONObject obj = new JSONObject(jsonFile);
            JSONArray m_jArry = obj.getJSONArray("categories");
            for (int i = 0; i < m_jArry.length(); i++) {
                JSONObject temp = m_jArry.getJSONObject(i);
                Category cate = new Category();
                cate.setName(temp.getString("name"));

                JSONArray sub_arr = temp.getJSONArray("sub");
                List<String> sub = new ArrayList();
                for (int j = 0; j < sub_arr.length(); j++) {
                    JSONObject object = sub_arr.getJSONObject(j);
                    sub.add(object.getString("sub_name"));
                }

                cate.setSub(sub);
                categories.add(cate);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return categories;
    }

    public GifsServices getGifsServices() {
        return gifsServices;
    }
}
