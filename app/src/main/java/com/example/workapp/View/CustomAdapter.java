package com.example.workapp.View;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.workapp.R;
import com.example.workapp.model.Result;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends BaseAdapter {

    private List<Result> results = new ArrayList<>();
    private Context context;
    private LayoutInflater layoutInflater;

    public CustomAdapter(List<Result> results, Context context) {
        this.results = results;
        this.context = context;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return results.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null){
            view = layoutInflater.inflate(R.layout.activity_item,viewGroup,false);
        }
        ImageView imageView = view.findViewById(R.id.imageView);
        TextView textView = view.findViewById(R.id.textView);
        System.out.println(results.get(i).getTitle());
        System.out.println(results.get(i).getThumbnailUrl());
        textView.setText(results.get(i).getTitle());
        String url = results.get(i).getThumbnailUrl();
        Glide.with(context).load(url).override(300, 200).into(imageView);
        return view;
    }
}
