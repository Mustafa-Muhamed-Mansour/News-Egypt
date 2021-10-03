package com.news.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class NewsModel
{

    @SerializedName("articles")
    private ArrayList<ArticlesModel> articlesModels;

    public NewsModel()
    {
    }



    public ArrayList<ArticlesModel> getArticlesModels()
    {
        return articlesModels;
    }
}
