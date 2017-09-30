package de.dortmund.dohack2017.recipeswiper.features;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import de.dortmund.dohack2017.recipeswiper.R;

/**
 * Created by downh on 30.09.2017.
 */

public class SwipeCardAdapter extends BaseAdapter {

    Context mContext;
    LayoutInflater mLayoutInflater;
    ArrayList mSwipeCardArrayList;

    public SwipeCardAdapter(Context context, LayoutInflater layoutInflater, ArrayList<SwipeCard> swipeCards){
        this.mContext = context;
        this.mLayoutInflater = layoutInflater;
        this.mSwipeCardArrayList = swipeCards;
    }

    @Override
    public int getCount() {
        return mSwipeCardArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null){
            convertView = mLayoutInflater.inflate(R.layout.carditem, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.textView1 = (TextView) convertView.findViewById(R.id.cardItemText1);
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.cardItemImage);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        SwipeCard sw = (SwipeCard) mSwipeCardArrayList.get(position);
        viewHolder.textView1.setText(sw.getText1());
        viewHolder.imageView.setImageResource(sw.getImageId());
        return convertView;
    }

    private static class ViewHolder{
        public TextView textView1;
        public ImageView imageView;
    }
}
