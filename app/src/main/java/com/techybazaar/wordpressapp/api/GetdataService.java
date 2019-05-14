package com.techybazaar.wordpressapp.api;

import com.techybazaar.wordpressapp.model.Category;
import com.techybazaar.wordpressapp.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GetdataService {



        @GET("/wp-json/wp/v2/posts?_embed")
        Call<List<Post>> getAllPosts();

        @GET ("/wp-json/wp/v2/categories")
        Call<List<Category>> getCategotyList(@Query("page") String page_no);
}
