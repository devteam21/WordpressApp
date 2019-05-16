package com.techybazaar.wordpressapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.Placeholder;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.techybazaar.wordpressapp.PostDetails;
import com.techybazaar.wordpressapp.R;
import com.techybazaar.wordpressapp.model.Post;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.List;


public class PostLargeAdapter extends RecyclerView.Adapter<PostLargeAdapter.PostViewHolder> {
    private Context context;
    private List<Post> posts;

    public PostLargeAdapter(Context context, List<Post> posts) {
        this.context = context;
        this.posts = posts;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.list_item_large, viewGroup, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder postViewHolder, int i) {
        Post post = posts.get(i);
         try{
                String imageUrl = post.getEmbedded().getWpFeaturedmedia().get(0).getMediaDetails().getSizes().getMedium().getSourceUrl();
                Glide.with(context)
                        .load(imageUrl)
//                        .placeholder(R.drawable.loading)
//                        .error(R.drawable.loading)
                        .into(postViewHolder.imageLarge);
                postViewHolder.imageLarge.setScaleType(ImageView.ScaleType.FIT_XY);

            }catch (NullPointerException ignored){

            }

         postViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(context, PostDetails.class);
                 context.startActivity(intent);
             }
         });
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder {
        ImageView  imageLarge;




        public PostViewHolder(@NonNull View itemView) {
            super(itemView);

            imageLarge = itemView.findViewById(R.id.img_large);
        }

    }
}
