package com.techybazaar.wordpressapp.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.techybazaar.wordpressapp.PostDetailsActivity;
import com.techybazaar.wordpressapp.R;
import com.techybazaar.wordpressapp.model.Post;
import com.techybazaar.wordpressapp.utils.Tools;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


import java.util.ArrayList;
import java.util.List;


public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {
    private Context context;
    private List<Post> posts;
    private Activity mActivity;

    private boolean loading;

    public PostAdapter(Context context, List<Post> posts, Activity mActivity) {
        this.context = context;
        this.posts = posts;
        this.mActivity = mActivity;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.list_item, viewGroup, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final PostViewHolder postViewHolder, int i) {
        final Post post = posts.get(i);
        Document document = Jsoup.parse(post.getTitle().getRendered());
        final String title = document.body().text();
        postViewHolder.postTitleView.setText(title);
        postViewHolder.postDateView.setText(Tools.getDurationTimeStamp(post.getDate()));
//        Document doc = Jsoup.parse(post.getExcerpt().getRendered());
//        String content = doc.body().text();
//        postViewHolder.postContentView.setText(content);

        try {
            String imageUrl = post.getEmbedded().getWpFeaturedmedia().get(0).getMediaDetails().getSizes().getMedium().getSourceUrl();
            Glide.with(context)
                    .load(imageUrl)
//                    .placeholder(R.drawable.loading)
//                    .error(R.drawable.loading)
                    .into(postViewHolder.postImageView);
            postViewHolder.postImageView.setScaleType(ImageView.ScaleType.FIT_XY);

        }
        catch (NullPointerException ignored) {

        }
//        postViewHolder.postImageView.setAnimation(AnimationUtils.loadAnimation(context, R.anim.fade_trasition_left_animation));
//        postViewHolder.postContentView.setAnimation(AnimationUtils.loadAnimation(context, R.anim.fade_trasition_right_animation));
//        postViewHolder.postTitleView.setAnimation(AnimationUtils.loadAnimation(context, R.anim.fade_trasition_right_animation));

        postViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, PostDetailsActivity.class);
                intent.putExtra("id", post.getId().toString());
                intent.putExtra("date", post.getDate());
                intent.putExtra("title", post.getTitle().getRendered());
                intent.putExtra("catId", post.getCategories().get(0).toString());
                intent.putExtra("breifcontent", post.getExcerpt().getRendered());
                intent.putExtra("content", post.getContent().getRendered());
                intent.putExtra("postLink", post.getGuid().getRendered());
                intent.putExtra("imageUrl", post.getEmbedded()
                        .getWpFeaturedmedia().get(0).getMediaDetails()
                        .getSizes().getFull().getSourceUrl());
                ActivityOptionsCompat options = ActivityOptionsCompat
                        .makeSceneTransitionAnimation(mActivity,postViewHolder.postImageView,"image" );
                context.startActivity(intent, options.toBundle());

            }
        });
        postViewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                //Log.d("MainActivity", ""+title);
                return false;

            }
        });


    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public  static class PostViewHolder extends RecyclerView.ViewHolder {
        ImageView postImageView;
        TextView postTitleView, postContentView, postDateView;
        CardView cardView;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardview);
            postImageView = itemView.findViewById(R.id.post_image);
            postTitleView = itemView.findViewById(R.id.post_title);
            postDateView = itemView.findViewById(R.id.post_date_view);
            postContentView = itemView.findViewById(R.id.post_content_view);
        }

    }

    public void setLoaded() {
        loading = false;
        for (int i = 0; i < getItemCount(); i++) {
            if (posts.get(i) == null) {
                posts.remove(i);
                notifyItemRemoved(i);
            }
        }
    }
    public void resetListData() {
        this.posts = new ArrayList<>();
        notifyDataSetChanged();
    }
    public void insertData(List<Post> posts) {
        setLoaded();
        int positionStart = getItemCount();
        int itemCount = posts.size();
        this.posts.addAll(posts);
        notifyItemChanged(positionStart, itemCount);
    }

}
