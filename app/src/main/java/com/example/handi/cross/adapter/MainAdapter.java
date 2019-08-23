package com.example.handi.cross.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.handi.cross.R;
import com.example.handi.cross.model.response.ResponseItemBlog;
import com.example.handi.cross.model.response.ResponseItems;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by handi.imsi on 22/08/2019.
 */



public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    private ArrayList<ResponseItemBlog> Mimages;
    private Context context;

    public MainAdapter(Context context,ArrayList<ResponseItemBlog> Mimages) {
        this.context = context;
        this.Mimages = Mimages;

    }

    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycle_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

        viewHolder.tv_android.setText(Mimages.get(i).getArticleTitle());

        Picasso.get()
                .load(Mimages.get(i).getArticleImage())
                .fit()
                .into(viewHolder.img_android);
    }

    @Override
    public int getItemCount() {
        return Mimages.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tv_android;
        ImageView img_android;
        public ViewHolder(View view) {
            super(view);

            tv_android = (TextView)view.findViewById(R.id.txt_card);
            img_android = (ImageView)view.findViewById(R.id.img_card);
        }
    }




    public class CustomGridLayoutManager extends LinearLayoutManager {
        private boolean isScrollEnabled = true;

        public CustomGridLayoutManager(Context context) {
            super(context);
        }

        public void setScrollEnabled(boolean flag) {
            this.isScrollEnabled = flag;
        }

        @Override
        public boolean canScrollVertically() {
            //Similarly you can customize "canScrollHorizontally()" for managing horizontal scroll
            return isScrollEnabled && super.canScrollVertically();
        }
    }
}