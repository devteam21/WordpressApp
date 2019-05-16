package com.techybazaar.wordpressapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
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
    private List<Category> category = new ArrayList<>();
    private LinearLayoutManager manager;

    private int PAGE_NO = 1;

    private static final String TAG = "CategoryList";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_list);
        setupToolbar();
        getCategoryData();
        //recyclerview
        recyclerView = findViewById(R.id.category_list);
        manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);
        categoryAdapter = new CategoryListAdapter(CategoryList.this, category);
        recyclerView.setAdapter(categoryAdapter);


    }

    private void setupToolbar() {
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(getString(R.string.categories));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void getCategoryData() {
        GetdataService service = RetrofitClient.getRetrofitInstance().create(GetdataService.class);
        Call<List<Category>> call = service.getCategotyList(30);
        call.enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                List<Category> categories = response.body();
                category.addAll(categories);
                categoryAdapter.notifyDataSetChanged();


            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {
                Toast.makeText(CategoryList.this, "Error Occured", Toast.LENGTH_LONG).show();

            }
        });
    }


}
