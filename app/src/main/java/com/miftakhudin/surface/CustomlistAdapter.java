package com.miftakhudin.surface;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * Created by miftakhudin on 6/11/17.
 */

public class CustomlistAdapter extends ArrayAdapter<Article> {
    Context context;
    int resource;
    ArrayList<Article> articles;

    public CustomlistAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull ArrayList<Article> articles) {
        super(context, resource, articles);
        this.context = context;
        this.resource = resource;
        this.articles = articles;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            layoutInflater.inflate(R.layout.custom_layout, null, true);

        }
        return super.getView(position, convertView, parent);
    }
}
