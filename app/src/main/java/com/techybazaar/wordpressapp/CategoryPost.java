package com.techybazaar.wordpressapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;


import com.techybazaar.wordpressapp.adapter.PostAdapter;
import com.techybazaar.wordpressapp.api.GetdataService;
import com.techybazaar.wordpressapp.api.RetrofitClient;
import com.techybazaar.wordpressapp.model.Post;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class CategoryPost extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private Toolbar toolbar;
    private String CATEGORY_ID;
    private String catName;
    private  LinearLayoutManager manager;
    private PostAdapter pAdapter;
    private List<Post> postList = new ArrayList<>();


    private int page_no = 1;
    private boolean loading = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_post);

        progressBar = findViewById(R.id.psbar);

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        String name = intent.getStringExtra("name");
        CATEGORY_ID = id;
        catName = name;
        getCategoryPostData(CATEGORY_ID, page_no);
        setupToolbar(catName);

        recyclerView = findViewById(R.id.category_post_list);
        manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);
        pAdapter = new PostAdapter(this, postList, this);
        recyclerView.setAdapter(pAdapter);
        progressBar.setVisibility(View.VISIBLE);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                progressBar.setVisibility(View.VISIBLE);
                int lastPos = manager.findLastVisibleItemPosition();
                if ( lastPos == (pAdapter.getItemCount() - 1 )) {
                    page_no++;
                    getCategoryPostData(CATEGORY_ID, page_no);
                }else {
                    pAdapter.setLoaded();
                }
                loading = true;
                progressBar.setVisibility(View.GONE);
            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupToolbar(String categoryName ) {
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(categoryName);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void getCategoryPostData(String catId ,int page_no){
        GetdataService service = RetrofitClient.getRetrofitInstance().create(GetdataService.class);
        Call<List<Post>> call = service.getCategoryPost(CATEGORY_ID, page_no);
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                List<Post> list = null;
                try{
                    list= response.body();
                    postList.addAll(list);
                    pAdapter.notifyDataSetChanged();

                }catch (NullPointerException ignored){

                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

            }
        });

    }

    @Override
    public void onBackPressed() {

        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}
