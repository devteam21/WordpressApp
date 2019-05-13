package com.techybazaar.wordpressapp.api;

import com.techybazaar.wordpressapp.model.Post;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    @GET("/wp-json/wp/v2/posts")
    Call<Post> getPosts();
}
