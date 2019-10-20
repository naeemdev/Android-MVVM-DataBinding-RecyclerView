package com.android_mvvm_databinding_recyclerviewexample.Model;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.android_mvvm_databinding_recyclerviewexample.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.annotations.SerializedName;


public class DeveloperModel {

    @SerializedName("username")

    private String username;
    @SerializedName("name")

    private String name;

    @SerializedName("avatar")

    private String avatar;

    @BindingAdapter({"avatar"})
    public static void loadImage(ImageView imageView, String imageURL) {

        Glide.with(imageView.getContext())
                .setDefaultRequestOptions(new RequestOptions()
                        .circleCrop())
                .load(imageURL)
                .placeholder(R.mipmap.ic_launcher)
                .into(imageView);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
