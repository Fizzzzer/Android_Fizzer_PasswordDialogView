package com.fizzer.doraemon.passwordinputdialog;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Fizzer on 2017/4/18.
 * Email: doraemonmqq@sina.com
 */

public class KeyBoardAdapter extends BaseAdapter {

    String[] num;
    Context mContext;

    public KeyBoardAdapter(Context mContext, String[] num) {
        this.mContext = mContext;
        this.num = num;
    }

    @Override
    public int getCount() {
        return num.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = View.inflate(mContext, R.layout.key_board_item_view, null);
        TextView textView = (TextView) convertView.findViewById(R.id.tvItemView);
        ImageView ivDel = (ImageView) convertView.findViewById(R.id.ivDel);
        RelativeLayout content = (RelativeLayout) convertView.findViewById(R.id.Content);
        textView.setText(num[position]);

        ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 150);
        convertView.setLayoutParams(lp);

        if (position == 9 || position == 11) {
            textView.setBackgroundColor(Color.parseColor("#D5D8DB"));
        }
        if(position == 11){
            textView.setVisibility(View.GONE);
            ivDel.setVisibility(View.VISIBLE);
            content.setBackgroundResource(R.drawable.keyboard_del_item_selector);
        }
        return convertView;
    }
}
