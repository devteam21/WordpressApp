package com.techybazaar.wordpressapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.techybazaar.wordpressapp.R;
import com.techybazaar.wordpressapp.model.Category;

import java.util.List;


public class CategoryAdapter extends  RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    private Context context;
    private List<Category> category;

    public CategoryAdapter(Context context, List<Category> category) {
        this.context = context;
        this.category = category;
    }

    @NonNull
    @Override
    public  CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.category_item, viewGroup,false);
        return new  CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  CategoryViewHolder categoryViewHolder, int i) {
        Category categorylist = category.get(i);
        categoryViewHolder.categoryName.setText(categorylist.getName());
        categoryViewHolder.totalPosts.setText(categorylist.getCount().toString());

    }

    @Override
    public int getItemCount() {
        return category.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView categoryName, totalPosts;


        public  CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
           categoryName = itemView.findViewById(R.id.category_name);
           totalPosts = itemView.findViewById((R.id.total_post));
        }
    }
}
