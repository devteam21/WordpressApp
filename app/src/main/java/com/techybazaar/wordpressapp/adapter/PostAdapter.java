package com.techybazaar.wordpressapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.techybazaar.wordpressapp.PostDetails;
import com.techybazaar.wordpressapp.R;
import com.techybazaar.wordpressapp.model.Post;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.List;




public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {
    private Context context;
    private List<Post> posts;

    private boolean loading;

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
    public void onBindViewHolder(@NonNull final PostViewHolder postViewHolder, int i) {
        final Post post = posts.get(i);
        Document document = Jsoup.parse(post.getTitle().getRendered());
        final String title = document.body().text();
        postViewHolder.postTitleView.setText(title);
        Document doc = Jsoup.parse(post.getExcerpt().getRendered());
        String content = doc.body().text();
        postViewHolder.postContentView.setText(content);

        try{
            String imageUrl= post.getEmbedded().getWpFeaturedmedia().get(0).getMediaDetails().getSizes().getMedium().getSourceUrl();
            Glide.with(context)
                    .load(imageUrl)
//                    .placeholder(R.drawable.loading)
//                    .error(R.drawable.loading)
                    .into(postViewHolder.postImageView);
            postViewHolder.postImageView.setScaleType(ImageView.ScaleType.FIT_XY);

        }catch (NullPointerException ignored){

        }

        postViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PostDetails.class);
                context.startActivity(intent);
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

    public class PostViewHolder extends RecyclerView.ViewHolder {
        ImageView postImageView, imageLarge;
        TextView postTitleView, postContentView;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            postImageView = itemView.findViewById(R.id.post_image);
            postTitleView = itemView.findViewById(R.id.post_title);
            postContentView = itemView.findViewById(R.id.post_content_view);
            imageLarge = itemView.findViewById(R.id.img_large);
        }

    }

    public void setLoaded() {
        loading = false;
        for(int i = 0; i< getItemCount(); i++){
            if(posts.get(i) == null){
                posts.remove(i);
                notifyItemRemoved(i);
            }
        }
    }

}
