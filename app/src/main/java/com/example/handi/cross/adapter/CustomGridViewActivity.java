package com.example.handi.cross.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.handi.cross.R;
import com.example.handi.cross.model.response.ResponseItems;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by handi.imsi on 21/08/2019.
 */

public class CustomGridViewActivity extends BaseAdapter {
    private Context mContext;

    // private final int[] Imageid;

    private ArrayList<ResponseItems> images;

    public CustomGridViewActivity(Context context, ArrayList<ResponseItems> images){
        this.mContext = context;
        this.images = images;
    }

    private boolean isScrollEnabled = true;

    public int getCount(){
        return this.images.size();
    }

    public Object getItem(int position){
        return this.images.get(position);
    }

    public long getItemId(int position){
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View grid;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            grid = new View(mContext);
            grid = inflater.inflate(R.layout.gridview_layout, null);
            TextView textView = (TextView) grid.findViewById(R.id.android_gridview_text);
            ImageView imageView = (ImageView)grid.findViewById(R.id.android_gridview_image);
            textView.setText(images.get(position).getProductName());
            //imageView.setImageResource(Imageid[position]);
            Picasso.get()
                    .load(images.get(position).getProductImage())
                    .fit()
                    .into(imageView);

            final String link = images.get(position).getLinkProduct().toString();
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View viewHolder) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(link));
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    mContext.startActivity(intent);
                }

            });

        } else {
            grid = (View) convertView;
        }

        return grid;
    }
}