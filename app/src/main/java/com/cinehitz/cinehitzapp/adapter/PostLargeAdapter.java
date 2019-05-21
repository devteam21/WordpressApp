package com.cinehitz.cinehitzapp.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.cinehitz.cinehitzapp.PostDetailsActivity;
import com.cinehitz.cinehitzapp.R;
import com.cinehitz.cinehitzapp.model.Post;

import java.util.List;


public class PostLargeAdapter extends RecyclerView.Adapter<PostLargeAdapter.PostViewHolder> {
    private Context context;
    private List<Post> posts;
    private Activity mActivity;
    private boolean loading;

    public PostLargeAdapter(Context context, List<Post> posts,Activity mActivity) {
        this.context = context;
        this.posts = posts;
        this.mActivity= mActivity;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.list_item_large, viewGroup, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final PostViewHolder postViewHolder, int i) {
        final Post post = posts.get(i);
         try{
                String imageUrl = post.getEmbedded().getWpFeaturedmedia().get(0).getMediaDetails().getSizes().getFull().getSourceUrl();
                Glide.with(context)
                        .load(imageUrl)
//                        .placeholder(R.drawable.loading)
//                        .error(R.drawable.loading)
                        .into(postViewHolder.imageLarge);
                postViewHolder.imageLarge.setScaleType(ImageView.ScaleType.FIT_XY);

            }catch (NullPointerException ignored){

            }
//        postViewHolder.imageLarge.setAnimation(AnimationUtils.loadAnimation(context, R.anim.fade_trasition_left_animation));

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
                 intent.putExtra("postLink", post.getLink());
                 intent.putExtra("imageUrl", post.getEmbedded().getWpFeaturedmedia().get(0).getMediaDetails().getSizes().getFull().getSourceUrl());
                 ActivityOptionsCompat options = ActivityOptionsCompat.
                         makeSceneTransitionAnimation(mActivity , postViewHolder.imageLarge,"image");
                 context.startActivity(intent,options.toBundle());
//                 mActivity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

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
    public void setLoaded() {
        loading = false;
        for (int i = 0; i < getItemCount(); i++) {
            if (posts.get(i) == null) {
                posts.remove(i);
                notifyItemRemoved(i);
            }
        }

    }
}
