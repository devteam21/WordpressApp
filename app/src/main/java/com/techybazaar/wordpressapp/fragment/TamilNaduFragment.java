package com.techybazaar.wordpressapp.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.techybazaar.wordpressapp.R;
import com.techybazaar.wordpressapp.adapter.PostAdapter;
import com.techybazaar.wordpressapp.api.GetdataService;
import com.techybazaar.wordpressapp.api.RetrofitClient;
import com.techybazaar.wordpressapp.model.Post;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class TamilNaduFragment extends Fragment {


    private View view;
    private RecyclerView recyclerView;
    private LinearLayoutManager manager;
    private PostAdapter pAdapter;
    private List<Post> post = new ArrayList<>();
    private ShimmerFrameLayout mShimmerViewContainer;

    private int page_no = 1;
    private boolean loading = true;


    public TamilNaduFragment() {
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_tamil_nadu, container, false);

        getCategoryPost();

        mShimmerViewContainer = view.findViewById(R.id.shimmer_view_container);
        recyclerView = view.findViewById(R.id.post_list);
        manager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);
        pAdapter = new PostAdapter(getContext(), post, getActivity());
        recyclerView.setAdapter(pAdapter);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int lastPos = manager.findLastVisibleItemPosition();
                if (lastPos == (pAdapter.getItemCount() - 1)) {
                    page_no++;
                    getCategoryPost();

                } else {
                    pAdapter.setLoaded();
                }
                loading = true;

            }
        });


        return view;
    }

    public void getCategoryPost() {
        GetdataService service = RetrofitClient.getRetrofitInstance().create(GetdataService.class);
        Call<List<Post>> call = service.getCategoryPost("239", page_no);
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(@NonNull Call<List<Post>> call, @NonNull Response<List<Post>> response) {
                List<Post> mlist = null;
                try {
                    if (response.isSuccessful()) {
                        mlist = response.body();
                        post.addAll(mlist);
                        pAdapter.notifyDataSetChanged();
                    } else {
                        mShimmerViewContainer.startShimmer();
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

}
