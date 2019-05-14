package com.techybazaar.wordpressapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.techybazaar.wordpressapp.R;
import com.techybazaar.wordpressapp.model.Post;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.List;


public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {
    private Context context;
    private List<Post> posts;

    public PostAdapter(Context context, List<Post> posts) {
        this.context = context;
        this.posts = posts;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.list_item, viewGroup, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder postViewHolder, int i) {
        Post post = posts.get(i);
        Document document = Jsoup.parse(post.getTitle().getRendered());
        String title = document.body().text();
        postViewHolder.postTitleView.setText(title);
        Document doc = Jsoup.parse(post.getExcerpt().getRendered());
        String content = doc.body().text();
        postViewHolder.postContentView.setText(content);

        //Post Image
        Glide.with(context)
                .load(post.getEmbedded().getWpFeaturedmedia().get(0).getMediaDetails().getSizes().getMedium().getSourceUrl())
                .into(postViewHolder.postImageView);
        postViewHolder.postImageView.setScaleType(ImageView.ScaleType.FIT_XY);

    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder {
        ImageView postImageView;
        TextView postTitleView, postContentView, postDateView;


        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            postImageView = itemView.findViewById(R.id.post_image);
            postTitleView = itemView.findViewById(R.id.post_title);
            postContentView = itemView.findViewById(R.id.post_content_view);


        }
    }
}
