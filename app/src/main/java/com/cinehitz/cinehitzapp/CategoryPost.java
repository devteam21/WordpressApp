package com.cinehitz.cinehitzapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;


import com.facebook.shimmer.ShimmerFrameLayout;
import com.cinehitz.cinehitzapp.adapter.PostAdapter;
import com.cinehitz.cinehitzapp.api.GetdataService;
import com.cinehitz.cinehitzapp.api.RetrofitClient;
import com.cinehitz.cinehitzapp.model.Post;
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


public class CategoryPost extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Toolbar toolbar;
    private String CATEGORY_ID;
    private String catName;
    private LinearLayoutManager manager;
    private PostAdapter pAdapter;
    private List<Post> postList = new ArrayList<>();
    private ShimmerFrameLayout mShimmerViewContainer;
    private AdView mAdview;
    private InterstitialAd mInterstitialAd;


    private int page_no = 1;
    private boolean loading = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_post);

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

        //getting datas from intent
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        String name = intent.getStringExtra("name");
        CATEGORY_ID = id;
        catName = name;
        getCategoryPostData(CATEGORY_ID, page_no);
        setupToolbar(catName);

        mShimmerViewContainer = findViewById(R.id.shimmer_view_container);

        recyclerView = findViewById(R.id.category_post_list);
        manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);
        pAdapter = new PostAdapter(this, postList, this);
        recyclerView.setAdapter(pAdapter);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int lastPos = manager.findLastVisibleItemPosition();
                if (lastPos == (pAdapter.getItemCount() - 1)) {
                    page_no++;
                    getCategoryPostData(CATEGORY_ID, page_no);
                } else {
                    pAdapter.setLoaded();
                }
                loading = true;


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

    private void setupToolbar(String categoryName) {
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(categoryName);
        toolbar.setTitleTextAppearance(this, R.style.ToolbarTextStyle);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void getCategoryPostData(String catId, int page_no) {
        GetdataService service = RetrofitClient.getRetrofitInstance().create(GetdataService.class);
        Call<List<Post>> call = service.getCategoryPost(CATEGORY_ID, page_no);
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                List<Post> list = null;
                try {
                    if (response.isSuccessful()) {
                        list = response.body();
                        postList.addAll(list);
                        pAdapter.notifyDataSetChanged();
                        mShimmerViewContainer.stopShimmer();
                        mShimmerViewContainer.setVisibility(View.GONE);
                        mInterstitialAd.show();

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

            }
        });

    }

    @Override
    public void onBackPressed() {

        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}
