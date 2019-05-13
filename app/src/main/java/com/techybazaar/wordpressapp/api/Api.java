package com.techybazaar.wordpressapp.api;

import com.techybazaar.wordpressapp.model.Post;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    @GET("/posts")
    Call<Post> getPosts();
}
