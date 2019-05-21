package com.cinehitz.cinehitzapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.cinehitz.cinehitzapp.adapter.PostLargeAdapter;
import com.cinehitz.cinehitzapp.adapter.ViewPagerAdapter;
import com.cinehitz.cinehitzapp.api.GetdataService;
import com.cinehitz.cinehitzapp.api.RetrofitClient;
import com.cinehitz.cinehitzapp.fragment.AnmeegamFragment;
import com.cinehitz.cinehitzapp.fragment.CinemaFragment;
import com.cinehitz.cinehitzapp.fragment.CricketFragment;
import com.cinehitz.cinehitzapp.fragment.EntertainmentFragment;
import com.cinehitz.cinehitzapp.fragment.IndiaFragment;
import com.cinehitz.cinehitzapp.fragment.NewsFragment;
import com.cinehitz.cinehitzapp.fragment.TamilNaduFragment;
import com.cinehitz.cinehitzapp.fragment.WorldFragment;
import com.cinehitz.cinehitzapp.model.Post;
import com.cinehitz.cinehitzapp.utils.NetworkCheck;
import com.cinehitz.cinehitzapp.utils.Tools;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

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
    private AdView mAdview;
    private InterstitialAd mInterstitialAd;


    private int page_no = 1;
    private boolean loading = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpToolbar();
        connectionCheck();
        getCategoryPost(1);

        appBarLayout = findViewById(R.id.appbar);
        mShimmerViewContainer = findViewById(R.id.shimmer_view_container);
        viewPager = findViewById(R.id.viewpager);
        vAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        tabLayout = findViewById(R.id.tablayout);
        relativeLayout = findViewById(R.id.content_layout);
        failedView = findViewById(R.id.failed_view);

        //admob ads
        MobileAds.initialize(this, getString(R.string.admob_app_id));
        mAdview = new AdView(this);
        mAdview.setAdUnitId(getString(R.string.admob_banner_id));
        mAdview.setAdSize(AdSize.LARGE_BANNER);
        LinearLayout layout = findViewById(R.id.banner_ad);
        layout.addView(mAdview);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdview.loadAd(adRequest);
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getString(R.string.admob_interstitial_id));
        mInterstitialAd.loadAd(adRequest);


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
                int lastPos = manager.findLastVisibleItemPosition();
                if (lastPos == (pLargeAdapter.getItemCount() - 1)) {
                    page_no++;
                    getCategoryPost(page_no);
                } else {
                    pLargeAdapter.setLoaded();
                }
                loading = true;


            }
        });


        // add fragment
        vAdapter.addFragment(new CinemaFragment(), getString(R.string.cinema));
        vAdapter.addFragment(new NewsFragment(), getString(R.string.news));
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
                    getCategoryPost(1);
                }
            }
        });
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        drawerLayout.closeDrawers();
        switch (menuItem.getItemId()) {
            case R.id.nav_categories:
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                    mInterstitialAd.setAdListener(new AdListener() {
                        @Override
                        public void onAdClosed() {
                            super.onAdClosed();
                            Intent categoryIntent = new Intent(MainActivity.this, CategoryList.class);
                            startActivity(categoryIntent);
                        }
                    });
                } else {
                    Intent categoryIntent = new Intent(MainActivity.this, CategoryList.class);
                    startActivity(categoryIntent);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                }
                break;
            case R.id.nav_setting:
                Intent settingIntent = new Intent(this, SettingActivity.class);
                startActivity(settingIntent);
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
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                    mInterstitialAd.setAdListener(new AdListener() {
                        @Override
                        public void onAdClosed() {
                            super.onAdClosed();
                            Intent searchIntent = new Intent(MainActivity.this, SearchActivity.class);
                            ActivityOptionsCompat options = ActivityOptionsCompat
                                    .makeSceneTransitionAnimation(MainActivity.this, appBarLayout, "appbar");
                            startActivity(searchIntent, options.toBundle());
                        }
                    });
                } else {
                    Intent searchIntent = new Intent(this, SearchActivity.class);
                    ActivityOptionsCompat options = ActivityOptionsCompat
                            .makeSceneTransitionAnimation(this, appBarLayout, "appbar");
                    startActivity(searchIntent, options.toBundle());
                }
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


    public void getCategoryPost(int page_no) {
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
