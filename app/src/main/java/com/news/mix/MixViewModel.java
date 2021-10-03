package com.news.mix;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.news.model.ArticlesModel;
import com.news.model.NewsModel;
import com.news.network.NewsClient;
import com.news.network.NewsService;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.QueryMap;

public class MixViewModel extends ViewModel
{

    private NewsService newsService;
    private MutableLiveData<String> stringMutableLiveData = new MutableLiveData<>();
    private HashMap<String, String> stringHashMap = new HashMap<>();

    public MixViewModel()
    {
        newsService = NewsClient.getRetrofit().create(NewsService.class);
    }

    public LiveData<ArrayList<ArticlesModel>> getNews()
    {
        MutableLiveData<ArrayList<ArticlesModel>> newsMutableLiveData = new MutableLiveData<>();
        
        newsService
                .getNews(stringHashMap)
                .enqueue(new Callback<ArrayList<ArticlesModel>>()
                {
                    @Override
                    public void onResponse(Call<ArrayList<ArticlesModel>> call, Response<ArrayList<ArticlesModel>> response)
                    {
                        newsMutableLiveData.postValue(response.body());
                    }

                    @Override
                    public void onFailure(Call<ArrayList<ArticlesModel>> call, Throwable t)
                    {
                        stringMutableLiveData.setValue(t.getMessage());
                    }
                });
        
        return newsMutableLiveData;
    }
}