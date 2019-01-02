package com.snipex.shantu.androidretrofitwithjava.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.snipex.shantu.androidretrofitwithjava.R;
import com.snipex.shantu.androidretrofitwithjava.model.Article;

import java.util.ArrayList;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder> {

    private Context _context;
    ArrayList<Article> articleArrayList;

    public ArticleAdapter(Context context, ArrayList<Article> articleArrayList) {
        this._context = context;
        this.articleArrayList = articleArrayList;
    }

    @NonNull
    @Override
    public ArticleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_each_row_article, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleAdapter.ViewHolder viewHolder, int i) {
        Article article = articleArrayList.get(i);
        viewHolder.tvTitle.setText(article.getTitle());
        viewHolder.tvAuthor.setText(article.getAuthor() + " | " + "Published - " + article.getPublishedAt());
        viewHolder.tvDescription.setText(article.getDescription());

        Glide.with(_context)
                .load(article.getUrlToImage())
                .into(viewHolder.imgViewArticleCover);
    }

    @Override
    public int getItemCount() {
        return articleArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvTitle;
        private final TextView tvDescription;
        private final TextView tvAuthor;
        private final ImageView imgViewArticleCover;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            tvAuthor = (TextView) itemView.findViewById(R.id.tvAuthor);
            tvDescription = (TextView) itemView.findViewById(R.id.tvDescription);
            imgViewArticleCover = (ImageView) itemView.findViewById(R.id.imgViewArticleCover);
        }
    }
}
