package com.snipex.shantu.androidretrofitwithjava.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.snipex.shantu.androidretrofitwithjava.model.Article;

import java.util.ArrayList;

public class ArticleResponse {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("totalResults")
    @Expose
    private Integer totalResults;
    @SerializedName("articles")
    @Expose
    private ArrayList<Article> articles = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    public ArrayList<Article> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<Article> articles) {
        this.articles = articles;
    }
}
