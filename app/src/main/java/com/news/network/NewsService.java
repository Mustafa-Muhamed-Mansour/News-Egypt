package com.news.network;

import com.news.model.ArticlesModel;
import com.news.model.NewsModel;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface NewsService
{

    @GET("top-headlines")
    Call<ArrayList<ArticlesModel>> getNews(@QueryMap HashMap<String, String> stringHashMap);
}
