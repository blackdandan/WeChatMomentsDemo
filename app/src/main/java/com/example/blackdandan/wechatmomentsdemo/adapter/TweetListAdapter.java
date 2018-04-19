package com.example.blackdandan.wechatmomentsdemo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.blackdandan.wechatmomentsdemo.R;
import com.example.blackdandan.wechatmomentsdemo.imageloader.ImageLoaderConfig;
import com.example.blackdandan.wechatmomentsdemo.imageloader.MemoryCache;
import com.example.blackdandan.wechatmomentsdemo.imageloader.SimpleImageLoader;
import com.example.blackdandan.wechatmomentsdemo.mode.Tweet;
import com.example.blackdandan.wechatmomentsdemo.mode.UserInfo;
import com.example.blackdandan.wechatmomentsdemo.view.TweetImagesView;

import java.util.List;
import java.util.Map;

public class TweetListAdapter extends RecyclerView.Adapter {
    private static final int TYPE_HEAD = 0;
    private static final int TYPE_TWEET= 1;
    private UserInfo selfInfo;
    private List<Tweet> tweets;
    private Context context;
    private ImageLoaderConfig imageLoaderConfig = new ImageLoaderConfig.Builder().setFaildImage(R.drawable.default_profile_image)
            .setCachePolicy(new MemoryCache())
            .setThreadCount(1).build();
    public TweetListAdapter(Context context){
        this.context = context;
    }

    public void setSelfInfo(UserInfo selfInfo) {
        this.selfInfo = selfInfo;
    }

    public void setTweets(List<Tweet> tweets) {
        this.tweets = tweets;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0)return TYPE_HEAD;
        else return TYPE_TWEET;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_HEAD){
            View view = LayoutInflater.from(context).inflate(R.layout.moment_head,null);
            return new HeadViewHolder(view);
        }
        if (viewType == TYPE_TWEET){
            View view = LayoutInflater.from(context).inflate(R.layout.tweet_item,null);
            return new TweetViewHolder(view,context);
        }
        View view = LayoutInflater.from(context).inflate(R.layout.moment_head,null);
         return new HeadViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == TYPE_HEAD){
            if (selfInfo == null)return;//显示默认
           HeadViewHolder headViewHolder = (HeadViewHolder)holder;
            SimpleImageLoader.getInstance(imageLoaderConfig).displayImage(headViewHolder.profileImage,selfInfo.getProfile_image());
            SimpleImageLoader.getInstance(imageLoaderConfig).displayImage(headViewHolder.headImage,selfInfo.getAvatar());
            headViewHolder.nick.setText(selfInfo.getNick());
        }
        if (getItemViewType(position) == TYPE_TWEET){
            Tweet tweet = tweets.get(position-1);
            TweetViewHolder tweetViewHolder = (TweetViewHolder)holder;
            if (tweet.getSender()!=null)
            SimpleImageLoader.getInstance(imageLoaderConfig).displayImage(tweetViewHolder.headImage,tweet.getSender().getAvatar());
            tweetViewHolder.content.setText(tweet.getContent());
            if (tweet.getImages()!=null)
            tweetViewHolder.setImages(tweet.getImages());
            if (tweet.getComments()!=null)
            tweetViewHolder.setComments(tweet.getComments());
        }
    }

    @Override
    public int getItemCount() {
        return tweets == null?1:1+tweets.size();
    }
    public class TweetViewHolder extends RecyclerView.ViewHolder{
        public ImageView headImage;
        public TextView sender;
        public TextView content;
        public TweetImagesView tweetImagesView;
        public ListView comments;
        private CommentsListAdapter commentAdapter;
        private TweetImagesAdapter imagesAdapter;
        private Context context;
        public TweetViewHolder(View itemView, Context context) {
            super(itemView);
            this.context = context;
            initView(itemView);
        }

        private void initView(View itemView) {
            headImage = itemView.findViewById(R.id.head);
            sender = itemView.findViewById(R.id.sender);
            content = itemView.findViewById(R.id.content);
            tweetImagesView = itemView.findViewById(R.id.images);
            comments = itemView.findViewById(R.id.comments);
            imagesAdapter = new TweetImagesAdapter(context);
            tweetImagesView.setAdapter(imagesAdapter);
            commentAdapter = new CommentsListAdapter(context);
            comments.setAdapter(commentAdapter);
        }
        public void setImages(List<Map<String ,String>> images){
            imagesAdapter.setImages(images);
            imagesAdapter.notifyDataSetChanged();
        }
        public void setComments(List<Tweet.Comment> comments){
            commentAdapter.setComments(comments);
            commentAdapter.notifyDataSetChanged();
        }
    }
    public class HeadViewHolder extends RecyclerView.ViewHolder{
        public ImageView profileImage;
        public ImageView headImage;
        public TextView nick;
        public HeadViewHolder(View itemView) {
            super(itemView);
            initView(itemView);
        }

        private void initView(View itemView) {
            profileImage = itemView.findViewById(R.id.profile_image);
            headImage = itemView.findViewById(R.id.head);
            nick = itemView.findViewById(R.id.nick);
        }
    }
}
