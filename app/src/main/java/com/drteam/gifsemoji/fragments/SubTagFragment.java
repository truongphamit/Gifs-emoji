package com.drteam.gifsemoji.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.drteam.gifsemoji.API.GifsServices;
import com.drteam.gifsemoji.Constants;
import com.drteam.gifsemoji.MainActivity;
import com.drteam.gifsemoji.R;
import com.drteam.gifsemoji.models.searchdetail.SearchResult;
import com.drteam.gifsemoji.views.adapters.SubTagsAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class SubTagFragment extends Fragment {
    public static final String INTENT_TAG = "tag";

    @BindView(R.id.rv_sub_tags)
    RecyclerView rv_sub_tags;

    private MainActivity activity;
    private GifsServices gifsServices;

    public static SubTagFragment newInstance(String tag) {

        Bundle args = new Bundle();
        args.putString(INTENT_TAG, tag);
        SubTagFragment fragment = new SubTagFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public SubTagFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sub_tag, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        activity = (MainActivity) getActivity();
        gifsServices = activity.getGifsServices();

        init(getArguments().getString(INTENT_TAG));
    }

    private void init(String tag) {
        Call<SearchResult> call = gifsServices.getSearchByKeyResult(tag, Constants.API_KEY, 25, 0, "y", "en", "json");
        call.enqueue(new Callback<SearchResult>() {
            @Override
            public void onResponse(Call<SearchResult> call, Response<SearchResult> response) {
                SearchResult searchResult = response.body();

                rv_sub_tags.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
                SubTagsAdapter adapter = new SubTagsAdapter(activity, searchResult.getData());
                rv_sub_tags.setAdapter(adapter);
                rv_sub_tags.setHasFixedSize(true);
            }

            @Override
            public void onFailure(Call<SearchResult> call, Throwable t) {

            }
        });
    }
}
