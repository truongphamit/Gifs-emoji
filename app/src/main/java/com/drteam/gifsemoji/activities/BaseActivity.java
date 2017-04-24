package com.drteam.gifsemoji.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.drteam.gifsemoji.API.GifsApi;
import com.drteam.gifsemoji.API.GifsServices;

/**
 * Created by DuongKK on 4/16/2017.
 */

public class BaseActivity extends AppCompatActivity {
    private GifsServices mGifService;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mGifService = GifsApi.getCoreServices();
    }

    public GifsServices getmGifService() {
        return mGifService;
    }
}
