package com.example.animeapiretrofitexample.repository;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;

import com.example.animeapiretrofitexample.service.AnimeDbApiDataService;

public class AnimeDataSourceFactory extends DataSource.Factory {
    private AnimeDataSource dataSource;
    private AnimeDbApiDataService animeDbApiDataService;
    private Application application;
    private MutableLiveData<AnimeDataSource> mutableLiveData;

    public AnimeDataSourceFactory(AnimeDbApiDataService animeDbApiDataService, Application application) {
        this.animeDbApiDataService = animeDbApiDataService;
        this.application = application;
        mutableLiveData=new MutableLiveData<>();
    }

    @NonNull
    @Override
    public DataSource create() {
        dataSource=new AnimeDataSource(animeDbApiDataService,application);
        mutableLiveData.postValue(dataSource);
        return dataSource;
    }

    public MutableLiveData<AnimeDataSource> getMutableLiveData() {
        return mutableLiveData;
    }
}
