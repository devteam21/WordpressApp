package com.techybazaar.wordpressapp;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.techybazaar.wordpressapp.adapter.PostAdapter;
import com.techybazaar.wordpressapp.adapter.PostLargeAdapter;
import com.techybazaar.wordpressapp.adapter.ViewPagerAdapter;
import com.techybazaar.wordpressapp.api.GetdataService;
import com.techybazaar.wordpressapp.api.RetrofitClient;
import com.techybazaar.wordpressapp.model.Category;
import com.techybazaar.wordpressapp.model.Post;
import com.techybazaar.wordpressapp.utils.Tools;

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
    private ViewPager viewPager;
    private ViewPagerAdapter vAdapter;
    private TabLayout tabLayout;





    private int page_no = 1;
    private boolean loading = true;

    private CategoryList categoryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpToolbar();
        getPostData(page_no);
        getCategoryPost();

        progressBar = findViewById(R.id.psbar);
        viewPager = findViewById(R.id.viewpager);
        vAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        tabLayout = findViewById(R.id.tablayout);


        // Large banner recyclerview
        recyclerViewLarge = findViewById(R.id.post_list_large);
        manager = new LinearLayoutManager(this, LinearLayout.HORIZONTAL, false);
        recyclerViewLarge.setLayoutManager(manager);
        recyclerViewLarge.setHasFixedSize(true);
        pLargeAdapter = new PostLargeAdapter(MainActivity.this, postLarge, this);
        recyclerViewLarge.setAdapter(pLargeAdapter);


        recyclerViewLarge.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

            }
        });


//        post recyclerview
//        recyclerView = findViewById(R.id.post_list);
//        manager = new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(manager);
//        recyclerView.setHasFixedSize(true);
//        pAdapter = new PostAdapter(MainActivity.this, post, this);
//        recyclerView.setAdapter(pAdapter);
//
//        progressBar.setVisibility(View.VISIBLE);
//
//
//        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
//
//            @Override
//            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
//                super.onScrolled(recyclerView, dx, dy);
//                progressBar.setVisibility(View.VISIBLE);
//                int lastPos = manager.findLastVisibleItemPosition();
//                if (lastPos == (pAdapter.getItemCount() - 1)) {
//                    page_no++;
//                    getPostData(page_no);
//
//                } else {
//                    pAdapter.setLoaded();
//                }
//                loading = true;
//                progressBar.setVisibility(View.GONE);
//
//            }
//        });

        //adapter setup
        viewPager.setAdapter(vAdapter);
        tabLayout.setupWithViewPager(viewPager);

        //add fragment


//        vAdapter.addFragment(new Fragment(), "cinema");

        setUpToolbar();
    }


    private void getPostData(int page_no) {

        GetdataService service = RetrofitClient.getRetrofitInstance().create(GetdataService.class);
        Call<List<Post>> call = service.getAllPosts(page_no);
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(@NonNull Call<List<Post>> call, @NonNull Response<List<Post>> response) {
                List<Post> mlist = null;
                try {
                    mlist = response.body();
                    post.addAll(mlist);
                    pAdapter.notifyDataSetChanged();

                } catch (NullPointerException ignored) {

                }

            }

            @Override
            public void onFailure(@NonNull Call<List<Post>> call, @NonNull Throwable t) {
//                Toast.makeText(MainActivity.this, "Loading Post...", Toast.LENGTH_LONG).show();

            }
        });
    }

    public void getCategoryPost() {
        GetdataService service = RetrofitClient.getRetrofitInstance().create(GetdataService.class);
        Call<List<Post>> call = service.getCategoryPost("392", page_no);
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(@NonNull Call<List<Post>> call, @NonNull Response<List<Post>> response) {
                List<Post> mlist = null;
                try {
                    mlist = response.body();
                    postLarge.addAll(mlist);
                     pLargeAdapter.notifyDataSetChanged();
                     progressBar.setVisibility(View.GONE);
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
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;
            case R.id.nav_privacy:
                Tools.privacyAction(this);
                break;
            case R.id.nav_about:
                Tools.aboutAction(this);
                break;
            case R.id.nav_more:
                Tools.moreAction(this);
                break;
            case R.id.nav_update:
                Tools.rateAction(this);
                break;
            case R.id.nav_rate:
                Tools.rateAction(this);
                break;
            case R.id.nav_share:
                Tools.shareAction(this);
                break;
        }
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_action_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_share:
                Tools.shareAction(this);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}