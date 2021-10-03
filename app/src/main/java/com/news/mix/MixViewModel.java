package com.news.mix;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.news.model.ArticlesModel;
import com.news.network.NewsClient;
import com.news.network.NewsService;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MixViewModel extends ViewModel
{

    private NewsService newsService;
    private MutableLiveData<String> stringMutableLiveData = new MutableLiveData<>();
    private HashMap<String, String> hashMap = new HashMap<>();

    public MixViewModel()
    {
        newsService = NewsClient.getRetrofit().create(NewsService.class);
    }

    public LiveData<ArrayList<ArticlesModel>> getNews()
    {
        MutableLiveData<ArrayList<ArticlesModel>> newsMutableLiveData = new MutableLiveData<>();

        hashMap.put("country", "eg");
        hashMap.put("apiKey", "f8bf970536a6496c89f9d95ff9a2439d");

        newsService
                .getNews(hashMap)
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