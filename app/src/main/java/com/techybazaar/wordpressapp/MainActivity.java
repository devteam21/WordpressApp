package com.techybazaar.wordpressapp;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.techybazaar.wordpressapp.adapter.PostAdapter;
import com.techybazaar.wordpressapp.adapter.PostLargeAdapter;
import com.techybazaar.wordpressapp.api.GetdataService;
import com.techybazaar.wordpressapp.api.RetrofitClient;
import com.techybazaar.wordpressapp.model.Post;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    public Toolbar toolbar;
    public DrawerLayout drawerLayout;
    public NavigationView navigationView;
    public ActionBarDrawerToggle toggle;
    private RecyclerView recyclerView, recyclerViewLarge;
    private LinearLayoutManager manager;
    private PostLargeAdapter pLargeAdapter;
    private PostAdapter pAdapter;
    private List<Post> post = new ArrayList<>();
    private List<Post> postLarge = new ArrayList<>();
    private ProgressBar progressBar;

    private int page_no = 1;
    private boolean loading = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpToolbar();
        getPostData(page_no);
        getCategoryPost();

        progressBar = findViewById(R.id.psbar);


        // Large banner recyclerview
        recyclerViewLarge = findViewById(R.id.post_list_large);
        manager = new LinearLayoutManager(this, LinearLayout.HORIZONTAL, false);
        recyclerViewLarge.setLayoutManager(manager);
        recyclerViewLarge.setHasFixedSize(true);
        pLargeAdapter = new PostLargeAdapter(MainActivity.this, postLarge);
        recyclerViewLarge.setAdapter(pLargeAdapter);


        recyclerViewLarge.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

            }
        });


        //post recyclerview
        recyclerView = findViewById(R.id.post_list);
        manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);
        pAdapter = new PostAdapter(MainActivity.this, post);
        recyclerView.setAdapter(pAdapter);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int lastPos = manager.findLastVisibleItemPosition();
                if ( lastPos == (pAdapter.getItemCount() - 1 )) {
                    page_no++;
                    getPostData(page_no);
                }else {
                    pAdapter.setLoaded();
                }
                    loading = true;
            }
        });
    }

    private void getPostData(int page_no) {

        GetdataService service = RetrofitClient.getRetrofitInstance().create(GetdataService.class);
        Call<List<Post>> call = service.getAllPosts(page_no);
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse( @NonNull Call<List<Post>> call, @NonNull  Response<List<Post>> response) {
                List<Post> mlist = null;
                try {
                    mlist = response.body();
                    post.addAll(mlist);
                    pAdapter.notifyDataSetChanged();

                } catch (NullPointerException ignored) {

                }

            }

            @Override
            public void onFailure(@NonNull  Call<List<Post>> call, @NonNull  Throwable t) {
//                Toast.makeText(MainActivity.this, "Loading Post...", Toast.LENGTH_LONG).show();

            }
        });
    }

    public void getCategoryPost() {
        GetdataService service = RetrofitClient.getRetrofitInstance().create(GetdataService.class);
        Call<List<Post>> call = service.getCategoryPost("392",page_no);
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(@NonNull Call<List<Post>> call,@NonNull Response<List<Post>> response) {
                List<Post> mlist = null;
                try {
                    mlist = response.body();
                    postLarge.addAll(mlist);
                    pAdapter.notifyDataSetChanged();

                } catch (NullPointerException ignored) {

                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
//                Toast.makeText(MainActivity.this, "Error Occured", Toast.LENGTH_LONG).show();

            }
        });

    }

    private void setUpToolbar() {
        drawerLayout = findViewById(R.id.drawer_layout);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        menuItem.setChecked(true);
        drawerLayout.closeDrawers();
        switch (menuItem.getItemId()) {
            case R.id.nav_categories:
                Intent categoryIntent = new Intent(MainActivity.this, CategoryList.class);
                startActivity(categoryIntent);
                break;
        }
        return false;
    }

}