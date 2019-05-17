package com.techybazaar.wordpressapp.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.techybazaar.wordpressapp.CategoryPost;
import com.techybazaar.wordpressapp.R;
import com.techybazaar.wordpressapp.model.Category;

import java.util.ArrayList;
import java.util.List;


public class CategoryListAdapter extends RecyclerView.Adapter<CategoryListAdapter.CategoryViewHolder> {

    private Context ctx;
    private List<Category> category = new ArrayList<>();
    private Activity mActivity;

    private boolean loading;


    public CategoryListAdapter(Context ctx, List<Category> category,Activity mActivity) {
        this.ctx = ctx;
        this.category = category;
        this.mActivity = mActivity;

    }


    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(ctx);
        View view = layoutInflater.inflate(R.layout.category_item, viewGroup, false);
        CategoryViewHolder categoryViewHolder = new CategoryViewHolder(view);
        return categoryViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final CategoryViewHolder categoryViewHolder, final int i) {
        final Category categorylist = category.get(i);
        categoryViewHolder.categoryName.setText(categorylist.getName());
        categoryViewHolder.totalPosts.setText(categorylist.getCount().toString());

        categoryViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent categoryIntent = new Intent(ctx, CategoryPost.class);
                categoryIntent.putExtra("id", categorylist.getId().toString());
                categoryIntent.putExtra("name", categorylist.getName());
                ctx.startActivity(categoryIntent);
                mActivity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

    }

    @Override
    public int getItemCount() {
        return category.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView categoryName, totalPosts;


        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryName = itemView.findViewById(R.id.category_name);
            totalPosts = itemView.findViewById((R.id.total_post));

        }


    }
    public void setLoaded() {
        loading = false;
        for(int i = 0; i< getItemCount(); i++){
            if(category.get(i) == null){
                category.remove(i);
                notifyItemRemoved(i);
            }
        }
    }

}
