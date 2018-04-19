package com.example.blackdandan.wechatmomentsdemo.mode;

import java.util.List;
import java.util.Map;

public class Tweet {
    private String content;
    private List<Map<String,String>> images;
    private UserInfo sender;
    private List<Comment> comments;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setImages(List<Map<String, String>> images) {
        this.images = images;
    }

    public UserInfo getSender() {
        return sender;
    }

    public void setSender(UserInfo sender) {
        this.sender = sender;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
    public class Comment {
        private String content;
        private UserInfo sender;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public UserInfo getSender() {
            return sender;
        }

        public void setSender(UserInfo sender) {
            this.sender = sender;
        }
    }

}
