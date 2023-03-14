package com.example.animeapiretrofitexample.repository;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import com.example.animeapiretrofitexample.model.AnimeGetDataModel;
import com.example.animeapiretrofitexample.model.AnimeInfoModel;
import com.example.animeapiretrofitexample.service.AnimeDbApiDataService;
import com.example.animeapiretrofitexample.service.AnimeDbRetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AnimeRepository {
    private ArrayList<AnimeInfoModel> animeInfoModels=new ArrayList<>();
    private MutableLiveData<List<AnimeInfoModel>> mutableLiveData=new MutableLiveData<>();
    private Application application;

    public AnimeRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<List<AnimeInfoModel>> getMutableLiveData() {
        AnimeDbApiDataService dbApiDataService= AnimeDbRetrofitInstance.getService();
        Call<AnimeGetDataModel> call=dbApiDataService.getAllAnime(1,1000);
        call.enqueue(new Callback<AnimeGetDataModel>() {
            @Override
            public void onResponse(Call<AnimeGetDataModel> call, Response<AnimeGetDataModel> response) {
                //Log.d("listOfAnime",response.body().getData().get(0).getAlternativeTitles().toString());
                AnimeGetDataModel animeGetDataModel=response.body();
                if(animeGetDataModel!=null )
                {
                    animeInfoModels=(ArrayList<AnimeInfoModel>) animeGetDataModel.getData();
                   // showOnRecyclerView();
                    mutableLiveData.setValue(animeInfoModels);
                }
            }



            @Override
            public void onFailure(Call<AnimeGetDataModel> call, Throwable t) {

            }
        });
        return mutableLiveData;
    }


}
