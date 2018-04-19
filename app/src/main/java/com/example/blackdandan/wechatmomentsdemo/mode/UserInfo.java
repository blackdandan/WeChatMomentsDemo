package com.example.blackdandan.wechatmomentsdemo.mode;

import com.google.gson.annotations.SerializedName;

public class UserInfo {
    @SerializedName("profile-name")
    private String profile_image;
    private String avatar;
    private String nick;
    private String username;

    public String getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(String profile_image) {
        this.profile_image = profile_image;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return  "user_info:" + "\n" +
                "profile_image:" + profile_image + "\n" +
                "avatar:" + avatar + "\n" +
                "nick:" + nick + "\n" +
                "username:" + username;
    }
}
