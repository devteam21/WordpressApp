package com.techybazaar.wordpressapp;

import android.app.Dialog;
import android.app.MediaRouteButton;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.techybazaar.wordpressapp.adapter.PostAdapter;
import com.techybazaar.wordpressapp.adapter.PostLargeAdapter;
import com.techybazaar.wordpressapp.adapter.ViewPagerAdapter;
import com.techybazaar.wordpressapp.api.GetdataService;
import com.techybazaar.wordpressapp.api.RetrofitClient;
import com.techybazaar.wordpressapp.fragment.AnmeegamFragment;
import com.techybazaar.wordpressapp.fragment.CinemaFragment;
import com.techybazaar.wordpressapp.fragment.CricketFragment;
import com.techybazaar.wordpressapp.fragment.EntertainmentFragment;
import com.techybazaar.wordpressapp.fragment.IndiaFragment;
import com.techybazaar.wordpressapp.fragment.NewsFragment;
import com.techybazaar.wordpressapp.fragment.TamilNaduFragment;
import com.techybazaar.wordpressapp.fragment.WorldFragment;
import com.techybazaar.wordpressapp.model.Category;
import com.techybazaar.wordpressapp.model.Post;
import com.techybazaar.wordpressapp.utils.NetworkCheck;
import com.techybazaar.wordpressapp.utils.Tools;

import java.io.EOFException;
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
    private List<Post> postLarge = new ArrayList<>();
    private ViewPager viewPager;
    private ViewPagerAdapter vAdapter;
    private TabLayout tabLayout;
    private ShimmerFrameLayout mShimmerViewContainer;
    private RelativeLayout relativeLayout, failedView;
    private AppBarLayout appBarLayout;


    private int page_no = 1;
    private boolean loading = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpToolbar();
        connectionCheck();
        getCategoryPost();

        appBarLayout = findViewById(R.id.appbar);
        mShimmerViewContainer = findViewById(R.id.shimmer_view_container);
        viewPager = findViewById(R.id.viewpager);
        vAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        tabLayout = findViewById(R.id.tablayout);
        relativeLayout = findViewById(R.id.content_layout);
        failedView = findViewById(R.id.failed_view);

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


        // add fragment
        vAdapter.addFragment(new NewsFragment(), getString(R.string.news));
        vAdapter.addFragment(new CinemaFragment(), getString(R.string.cinema));
        vAdapter.addFragment(new EntertainmentFragment(), getString(R.string.entertainment));
        vAdapter.addFragment(new TamilNaduFragment(), getString(R.string.tamilnadu));
        vAdapter.addFragment(new CricketFragment(), getString(R.string.cricket));
        vAdapter.addFragment(new IndiaFragment(), getString(R.string.india));
        vAdapter.addFragment(new WorldFragment(), getString(R.string.world));
        vAdapter.addFragment(new AnmeegamFragment(), getString(R.string.anmeegam));

        //adapter setup
        viewPager.setAdapter(vAdapter);
        vAdapter.notifyDataSetChanged();
        tabLayout.setupWithViewPager(viewPager);

    }



    private void setUpToolbar() {
        drawerLayout = findViewById(R.id.drawer_layout);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.home);
        toolbar.setTitleTextAppearance(this, R.style.ToolbarTextStyle);
        setSupportActionBar(toolbar);
        navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }

    public void connectionCheck() {
        relativeLayout = findViewById(R.id.content_layout);
        failedView = findViewById(R.id.failed_view);
        if (!NetworkCheck.isConnectingToInternet(this)) {
            relativeLayout.setVisibility(View.GONE);
            failedView.setVisibility(View.VISIBLE);
        } else {
            relativeLayout.setVisibility(View.VISIBLE);
            failedView.setVisibility(View.GONE);
        }
        Button retry;
        retry = findViewById(R.id.failed_retry);
        retry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (NetworkCheck.isConnectingToInternet(MainActivity.this)) {
                    relativeLayout.setVisibility(View.VISIBLE);
                    failedView.setVisibility(View.GONE);
                    getCategoryPost();
                }
            }
        });
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
            case R.id.action_search:
                Intent searchIntent = new Intent(this, SearchActivity.class);
                ActivityOptionsCompat options = ActivityOptionsCompat
                        .makeSceneTransitionAnimation(this,appBarLayout,"appbar" );
                startActivity(searchIntent, options.toBundle());
                break;
            case R.id.action_share:
                Tools.shareAction(this);
                break;
            case R.id.action_rateapp:
                Tools.rateAction(this);
                break;
            case R.id.action_gotoweb:
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(RetrofitClient.BASE_URL));
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;

        }
        return super.onOptionsItemSelected(item);
    }


    public void getCategoryPost() {
        GetdataService service = RetrofitClient.getRetrofitInstance().create(GetdataService.class);
        Call<List<Post>> call = service.getCategoryPost("280", page_no);
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(@NonNull Call<List<Post>> call, @NonNull Response<List<Post>> response) {
                List<Post> mlist = null;
                try {
                    if (response.isSuccessful()) {
                        mlist = response.body();
                        postLarge.addAll(mlist);
                        pLargeAdapter.notifyDataSetChanged();
                    } else {
                        mShimmerViewContainer.stopShimmer();
                        mShimmerViewContainer.setVisibility(View.VISIBLE);
                    }
                } catch (NullPointerException ignored) {

                }
                mShimmerViewContainer.stopShimmer();
                mShimmerViewContainer.setVisibility(View.GONE);

            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
//                Toast.makeText(MainActivity.this, "Error Occured", Toast.LENGTH_LONG).show();

            }
        });

    }


    @Override
    public void onBackPressed() {
        drawerLayout.closeDrawers();
        super.onBackPressed();
    }
}
