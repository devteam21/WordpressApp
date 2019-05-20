package com.techybazaar.wordpressapp;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.techybazaar.wordpressapp.adapter.CategoryListAdapter;
import com.techybazaar.wordpressapp.api.GetdataService;
import com.techybazaar.wordpressapp.api.RetrofitClient;
import com.techybazaar.wordpressapp.model.Category;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryList extends AppCompatActivity {
    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private CategoryListAdapter categoryAdapter;
    public List<Category> category = new ArrayList<>();
    private LinearLayoutManager manager;
    private ProgressBar progressBar;

    private int page_no = 1;
    private boolean loading = true;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_list);
        setupToolbar();
        getCategoryList(page_no);

        progressBar = findViewById(R.id.cat_psbar);
        //recyclerview
        recyclerView = findViewById(R.id.category_list);
        manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);
        categoryAdapter = new CategoryListAdapter(CategoryList.this, category, this);
        recyclerView.setAdapter(categoryAdapter);
        progressBar.setVisibility(View.VISIBLE);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                progressBar.setVisibility(View.VISIBLE);
                int lastPos = manager.findLastVisibleItemPosition();
                if ( lastPos == (categoryAdapter.getItemCount() - 1 )) {

                    page_no++;
                    getCategoryList(page_no);
                }else {
                    categoryAdapter.setLoaded();
                }
                loading = true;
                progressBar.setVisibility(View.GONE);

            }
        });
    }



    private void setupToolbar() {
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(getString(R.string.categories));
        toolbar.setTitleTextAppearance(this, R.style.ToolbarTextStyle);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public  void getCategoryList(int page_no) {
        GetdataService service = RetrofitClient.getRetrofitInstance().create(GetdataService.class);
        Call<List<Category>> call = service.getCategotyList(15, page_no);
        call.enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                List<Category> categories = response.body();
                category.addAll(categories);
                categoryAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {
//                Toast.makeText(CategoryList.this, "Error Occured", Toast.LENGTH_LONG).show();

            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}
