package com.example.blackdandan.wechatmomentsdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.blackdandan.wechatmomentsdemo.R;
import com.example.blackdandan.wechatmomentsdemo.mode.Tweet;

import java.util.List;

public class CommentsListAdapter extends BaseAdapter{
    private List<Tweet.Comment> comments ;
    private Context context;
    public CommentsListAdapter(Context context) {
        this.context = context;
    }

    public void setComments(List<Tweet.Comment> comments) {
        this.comments = comments;
    }

    @Override
    public int getCount() {
        return comments == null?0:comments.size();
    }

    @Override
    public Object getItem(int position) {
        return comments.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView view;//后期可实现部分点击效果,现在先拼接
        if (convertView == null){
            view = new TextView(context);
            view.setTextSize(context.getResources().getDimension(R.dimen.comment_text));
            view.setTextColor(context.getResources().getColor(R.color.color_tweet_content));
        }else {
            view = (TextView) convertView;
        }
        view.setText(comments.get(position).getSender()+" : "+comments.get(position).getContent());
        return view;
    }
}
