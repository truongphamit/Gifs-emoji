package com.drteam.gifsemoji.views.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.drteam.gifsemoji.R;

import java.util.List;

/**
 * Created by truongpq on 06/04/2017.
 */

public class TagsAdapter extends RecyclerView.Adapter<TagsAdapter.ViewHolder> {
    private Context context;
    private List<String> tags;

    public TagsAdapter(Context context, List<String> tags) {
        this.context = context;
        this.tags = tags;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View view = inflater.inflate(R.layout.item_sub_tag, parent, false);

        // Return a new holder instance
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String tag = tags.get(position);
        holder.tv_tag.setText(tag.toUpperCase());

        String gifUrl = "http://media0.giphy.com/media/Zw3oBUuOlDJ3W/200.gif";
        Glide.with(context)
                .load(gifUrl)
                .asGif()
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(holder.img);
    }

    @Override
    public int getItemCount() {
        return tags.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView img;
        public TextView tv_tag;

        public ViewHolder(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.img);
            tv_tag = (TextView) itemView.findViewById(R.id.tv_tag);
        }
    }
}
