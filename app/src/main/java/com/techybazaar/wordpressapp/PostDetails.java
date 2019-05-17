package com.techybazaar.wordpressapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.techybazaar.wordpressapp.api.GetdataService;
import com.techybazaar.wordpressapp.api.RetrofitClient;
import com.techybazaar.wordpressapp.model.Category;
import com.techybazaar.wordpressapp.model.CategoryName;
import com.techybazaar.wordpressapp.utils.Tools;

import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostDetails extends AppCompatActivity {
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private AppBarLayout appBarLayout;
    private TextView postTitle, postCategory, viewSource;
    private WebView mwebView;
    private ImageView postImage;
    private Toolbar toolbar;
    private ProgressBar progressBar;
    private  CategoryList categoryList;

    private List<CategoryName> catName= new ArrayList<>();
    public String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_details);
        setupToolbar();


        final Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        String catId = intent.getStringExtra("catId");
        final String title = intent.getStringExtra("title");
        String content = intent.getStringExtra("content");
        String url = intent.getStringExtra("postLink");
        String imageUrl = intent.getStringExtra("imageUrl");

        Document doc = Jsoup.parse(title);
        String parsedTitle = doc.body().text();
        getCategoryNameData(catId);


        postTitle = findViewById(R.id.post_title);
        postCategory = findViewById(R.id.post_category);
        viewSource = findViewById(R.id.view_source);
        postImage = findViewById(R.id.postImage);

        postTitle.setText(parsedTitle);



        Glide.with(this).load(imageUrl).into(postImage);
        postImage.setScaleType(ImageView.ScaleType.FIT_XY);


        viewSource.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sourceIntent = new Intent(PostDetails.this, CategoryPost.class);
                sourceIntent.putExtra("id", catName.get(0).getId().toString());
                sourceIntent.putExtra("name", catName.get(0).getName());
                startActivity(sourceIntent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

            }
        });



        collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar);
        appBarLayout = findViewById(R.id.appbarLayout);
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = true;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbarLayout.setTitle(title);

                    isShow = true;
                } else if (isShow) {
                    collapsingToolbarLayout.setTitle(" ");//careful there should a space between double quote otherwise it wont work
                    isShow = false;
                }
            }
        });
        webView(content);


    }

    public void webView(String content) {
        mwebView = findViewById(R.id.post_webview);
        progressBar = findViewById(R.id.psbar);
        mwebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                progressBar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                progressBar.setVisibility(View.GONE);

            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);

            }
        });
        mwebView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
            }

            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
            }
        });
        String post_data = "<style>h2{font-size:16px}p{font-size:14px}img{max-width:100%;height:auto;} iframe{width:100%;}</style> ";
        post_data += content;
        mwebView.loadData(post_data, "text/html", null);
        WebSettings webSettings = mwebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }
    private void setupToolbar() {
        toolbar = findViewById(R.id.toolbar);
        //toolbar.setTitle();
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_activity_post_details,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case android.R.id.home:
                finish();
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                break;
            case R.id.open_in_browser:
                String postUrl = getIntent().getStringExtra("postLink");
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(postUrl));
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                break;
            case R.id.action_share:
                Tools.sharePost(this,getIntent().getStringExtra("imageUrl"));
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    public  void  getCategoryNameData(String catId){
        GetdataService service = RetrofitClient.getRetrofitInstance().create(GetdataService.class);
        Call <CategoryName> call = service.getCategoryName(catId);
        call.enqueue(new Callback<CategoryName>() {
            @Override
            public void onResponse(Call<CategoryName> call, Response<CategoryName> response) {
                CategoryName list = null;
                try {
                    list= response.body();
                    catName.add(list);
                    postCategory.setText(catName.get(0).getName());


                } catch (IndexOutOfBoundsException ignored) {

                }

            }

            @Override
            public void onFailure(Call <CategoryName> call, Throwable t) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        if (mwebView.canGoBack()) {
            mwebView.goBack();
        } else {
            super.onBackPressed();
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        }
    }
}
