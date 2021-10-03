package com.news.model;

import com.google.gson.annotations.SerializedName;

public class ArticlesModel
{

    @SerializedName("title")
    private String title;
    @SerializedName("description")
    private String description;
    @SerializedName("urlToImage")
    private String urlToImage;

    public ArticlesModel()
    {
    }


    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getUrlToImage() {
        return urlToImage;
    }
}
