package com.techybazaar.wordpressapp.api;

import com.techybazaar.wordpressapp.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetdataService {

        @GET("/wp-json/wp/v2/posts?_embed")
        Call<List<Post>> getAllPosts();

}
