package com.example.animeapiretrofitexample.repository;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;

import com.example.animeapiretrofitexample.model.AnimeGetDataModel;
import com.example.animeapiretrofitexample.model.AnimeInfoModel;
import com.example.animeapiretrofitexample.service.AnimeDbApiDataService;
import com.example.animeapiretrofitexample.service.AnimeDbRetrofitInstance;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AnimeDataSource extends PageKeyedDataSource<Integer, AnimeInfoModel> {
    private AnimeDbApiDataService animeDbApiDataService;
    private Application application;

    public AnimeDataSource(AnimeDbApiDataService animeDbApiDataService, Application application) {
        this.animeDbApiDataService = animeDbApiDataService;
        this.application = application;
    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull LoadInitialCallback<Integer, AnimeInfoModel> callback) {
        animeDbApiDataService = AnimeDbRetrofitInstance.getService();
        Call<AnimeGetDataModel> get=animeDbApiDataService.getAnimeListWithPaging(1,20);
        get.enqueue(new Callback<AnimeGetDataModel>() {
            @Override
            public void onResponse(Call<AnimeGetDataModel> call, Response<AnimeGetDataModel> response) {
                AnimeGetDataModel animeGetDataModel=response.body();
                ArrayList<AnimeInfoModel> animeInfoModels=new ArrayList<>();
                if(animeGetDataModel!=null && animeGetDataModel.getData()!=null) {
                    animeInfoModels = (ArrayList<AnimeInfoModel>) animeGetDataModel.getData();
                    callback.onResult(animeInfoModels, null, (int) 2);
                }
            }

            @Override
            public void onFailure(Call<AnimeGetDataModel> call, Throwable t) {

            }
        });
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, AnimeInfoModel> callback) {

    }

    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull final LoadCallback<Integer, AnimeInfoModel> callback) {
        animeDbApiDataService = AnimeDbRetrofitInstance.getService();
        Call<AnimeGetDataModel> get=animeDbApiDataService.getAnimeListWithPaging(params.key, 20);
        get.enqueue(new Callback<AnimeGetDataModel>() {
            @Override
            public void onResponse(Call<AnimeGetDataModel> call, Response<AnimeGetDataModel> response) {
                AnimeGetDataModel animeGetDataModel=response.body();
                ArrayList<AnimeInfoModel> animeInfoModels=new ArrayList<>();

                if(animeGetDataModel!=null && animeGetDataModel.getData()!=null)
                {
                    animeInfoModels=(ArrayList<AnimeInfoModel>)animeGetDataModel.getData();
                    callback.onResult(animeInfoModels, params.key+1);
                }

            }

            @Override
            public void onFailure(Call<AnimeGetDataModel> call, Throwable t) {

            }
        });
    }
}
