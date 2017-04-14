package com.drteam.gifsemoji.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.drteam.gifsemoji.MainActivity;
import com.drteam.gifsemoji.R;
import com.drteam.gifsemoji.models.Category;
import com.drteam.gifsemoji.utils.Utils;
import com.drteam.gifsemoji.views.adapters.TagsAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class TagFragment extends Fragment {
    public static final String ARG_CATE_NAME = "ARG_CATE_NAME";
    public static final String ARG_CATE_SUB = "ARG_CATE_SUB";

    @BindView(R.id.rv_tags)
    RecyclerView rv_tags;

    private MainActivity activity;

    public static TagFragment newInstance(Category category) {
        TagFragment fragment = new TagFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_CATE_NAME, category.getName());
        bundle.putStringArrayList(ARG_CATE_SUB, (ArrayList<String>) category.getSub());
        fragment.setArguments(bundle);
        return fragment;
    }

    public TagFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tag, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        activity = (MainActivity) getActivity();

        Category category = new Category();
        category.setName(getArguments().getString(ARG_CATE_NAME));
        category.setSub(getArguments().getStringArrayList(ARG_CATE_SUB));

        init(category);
    }

    private void init(final Category category) {
        TagsAdapter adapter = new TagsAdapter(activity, category.getSub());
        rv_tags.setAdapter(adapter);
        rv_tags.setLayoutManager(new GridLayoutManager(activity, 2));

        adapter.setOnItemClickListener(new TagsAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View itemView, int position) {
                Utils.slideFragment(SubTagFragment.newInstance(category.getSub().get(position)), activity.getSupportFragmentManager());
            }
        });
    }
}
