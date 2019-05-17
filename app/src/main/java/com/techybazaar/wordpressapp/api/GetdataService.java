package com.techybazaar.wordpressapp.api;

import com.techybazaar.wordpressapp.model.Category;
import com.techybazaar.wordpressapp.model.CategoryName;
import com.techybazaar.wordpressapp.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GetdataService {


        @GET("/wp-json/wp/v2/posts?_embed")
        Call<List<Post>> getAllPosts(@Query("page") int page_no);

        @GET ("/wp-json/wp/v2/categories")
        Call<List<Category>> getCategotyList(@Query("per_page") int per_page, @Query("page") int page_no);

        @GET ("/wp-json/wp/v2/posts?_embed")
        Call<List<Post>> getCategoryPost (@Query("categories") String caterogory_id, @Query("page") int page_no);

        @GET ("/wp-json/wp/v2/categories/{category_id}")
        Call<CategoryName> getCategoryName(@Path("category_id") String category_id);

}
