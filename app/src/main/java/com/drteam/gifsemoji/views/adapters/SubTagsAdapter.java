package com.drteam.gifsemoji.views.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.drteam.gifsemoji.models.searchdetail.Data;

import java.util.List;

/**
 * Created by truongpq on 14/04/2017.
 */

public class SubTagsAdapter extends RecyclerView.Adapter<SubTagsAdapter.ViewHolder> {
    private Context context;
    private List<Data> datas;

    public SubTagsAdapter(Context context, List<Data> datas) {
        this.context = context;
        this.datas = datas;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ImageView view = new ImageView(parent.getContext());
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Data data = datas.get(position);
        Glide.with(context)
                .load(data.getImages().getFixedHeight().getUrl())
                .asGif()
                .fitCenter()
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    @Override
    public void onViewRecycled(ViewHolder holder) {
        super.onViewRecycled(holder);
//        Glide.clear(holder.image);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView;
        }
    }
}
