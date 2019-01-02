package com.snipex.shantu.androidretrofitwithjava.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.bumptech.glide.Glide;
import com.snipex.shantu.androidretrofitwithjava.R;
import com.snipex.shantu.androidretrofitwithjava.adapter.ArticleAdapter;
import com.snipex.shantu.androidretrofitwithjava.model.Article;
import com.snipex.shantu.androidretrofitwithjava.network.ApiRequest;
import com.snipex.shantu.androidretrofitwithjava.network.RetrofitRequest;
import com.snipex.shantu.androidretrofitwithjava.response.ArticleResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private RecyclerView my_recycler_view;
    private LinearLayoutManager layoutManager;
    private ArticleAdapter adapter;
    private ArrayList<Article> articleArrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialization();

        getMoviesArticle();


    }

    private void initialization() {
        my_recycler_view = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(MainActivity.this);
        my_recycler_view.setLayoutManager(layoutManager);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        my_recycler_view.setHasFixedSize(true);
    }

    private void getMoviesArticle() {
        ApiRequest apiRequest = RetrofitRequest.getRetrofitInstance().create(ApiRequest.class);


        Call<ArticleResponse> call = apiRequest.getMovieArticles("movies", "079dac74a5f94ebdb990ecf61c8854b7");
        call.enqueue(new Callback<ArticleResponse>() {
            @Override
            public void onResponse(Call<ArticleResponse> call, Response<ArticleResponse> response) {

                Log.d(TAG, "onResponse response:: " + response);

                if (response.body() != null) {

                    articleArrayList = new ArrayList<>(response.body().getArticles());

                    if (response.body().getStatus().equals("ok")){
                        // specify an adapter
                        adapter = new ArticleAdapter(MainActivity.this, articleArrayList);
                        my_recycler_view.setAdapter(adapter);
                    }
                }

            }

            @Override
            public void onFailure(Call<ArticleResponse> call, Throwable t) {
                Log.d(TAG, "onFailure response :: " + t);
            }

        });
    }
}
