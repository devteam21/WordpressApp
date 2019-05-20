package com.techybazaar.wordpressapp;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.shimmer.ShimmerFrameLayout;
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

public class SearchActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private EditText edit_search;
    private RecyclerView recyclerView;
    private PostAdapter pAdapter;
    private ImageButton btn_clear, btn_search;
    private ShimmerFrameLayout mShimmerViewContainer;
    private LinearLayoutManager manager;
    private View parent_view;
    private List<Post> postSearch = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        setupToolbar();
        edit_search = findViewById(R.id.et_search);
        btn_clear = findViewById(R.id.btn_clear);
        btn_search = findViewById(R.id.btn_search);
        btn_clear.setVisibility(View.GONE);
        btn_search.setVisibility(View.VISIBLE);
        edit_search.addTextChangedListener(textWatcher);
        mShimmerViewContainer = findViewById(R.id.shimmer_view_container);

        // Large banner recyclerview
        recyclerView = findViewById(R.id.recyclerViewSearch);
        manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);
        pAdapter = new PostAdapter(SearchActivity.this, postSearch, SearchActivity.this);
        recyclerView.setAdapter(pAdapter);


        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

            }
        });

        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edit_search.setText("");
                pAdapter.resetListData();
            }
        });

        edit_search.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    pAdapter.resetListData();
                    hideKeyboard();
                    searchQuery();
                    return true;
                }
                return false;
            }
        });

    }

    TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void onTextChanged(CharSequence c, int i, int i1, int i2) {
            if (c.toString().trim().length() == 0) {
                pAdapter.resetListData();
                btn_search.setVisibility(View.VISIBLE);
                btn_clear.setVisibility(View.GONE);
                noItemFoundView(false);
            } else {
                btn_clear.setVisibility(View.VISIBLE);
                btn_search.setVisibility(View.GONE);
            }
        }

        @Override
        public void beforeTextChanged(CharSequence c, int i, int i1, int i2) {
        }

        @Override
        public void afterTextChanged(Editable editable) {
        }
    };

    private void setupToolbar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                supportFinishAfterTransition();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void getSearchPost(String query) {
        GetdataService service = RetrofitClient.getRetrofitInstance().create(GetdataService.class);
        Call<List<Post>> call = service.getAllSearchQueryPost(query);
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(@NonNull Call<List<Post>> call, @NonNull Response<List<Post>> response) {
                List<Post> mlist = null;
                try {
                    if (response.isSuccessful()) {
                        pAdapter.resetListData();
                        mlist = response.body();

                        if (mlist.size() == 0) {
                            noItemFoundView(true);
                        } else {
                            postSearch.addAll(mlist);
                            pAdapter.insertData(mlist);
                            pAdapter.notifyDataSetChanged();
                            mShimmerViewContainer.setVisibility(View.GONE);
                        }
                    } else {

                    }
                } catch (NullPointerException ignored) {

                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
//                Toast.makeText(MainActivity.this, "Error Occured", Toast.LENGTH_LONG).show();

            }
        });

    }


    private void searchQuery() {
        final String query = edit_search.getText().toString().trim();
        if (!query.equals("")) {
            mShimmerViewContainer.setVisibility(View.VISIBLE);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    getSearchPost(query);

                }
            }, 2000);
        } else {
            Toast.makeText(this, "error", Toast.LENGTH_SHORT).show();
        }
    }

    private void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public void noItemFoundView(boolean show) {

        View no_item_found = findViewById(R.id.noitemfound_layout);
        if (show) {
            mShimmerViewContainer.setVisibility(View.GONE);
            recyclerView.setVisibility(View.GONE);
            no_item_found.setVisibility(View.VISIBLE);
        } else {
            recyclerView.setVisibility(View.VISIBLE);
            no_item_found.setVisibility(View.GONE);
        }

    }


    @Override
    public void onBackPressed() {
        supportFinishAfterTransition();
        super.onBackPressed();
    }
}
