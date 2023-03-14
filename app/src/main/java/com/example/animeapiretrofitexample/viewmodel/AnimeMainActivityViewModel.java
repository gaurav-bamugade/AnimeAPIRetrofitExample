package com.example.animeapiretrofitexample.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.example.animeapiretrofitexample.model.AnimeInfoModel;
import com.example.animeapiretrofitexample.repository.AnimeDataSource;
import com.example.animeapiretrofitexample.repository.AnimeDataSourceFactory;
import com.example.animeapiretrofitexample.repository.AnimeRepository;
import com.example.animeapiretrofitexample.service.AnimeDbApiDataService;
import com.example.animeapiretrofitexample.service.AnimeDbRetrofitInstance;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import retrofit2.Retrofit;

public class AnimeMainActivityViewModel extends AndroidViewModel {
    private AnimeRepository repository;
    private Executor executor;
    LiveData<AnimeDataSource> animeDataSourceLiveData;
    private LiveData<PagedList<AnimeInfoModel>> pagedListLiveData;

    public AnimeMainActivityViewModel(@NonNull Application application) {
        super(application);
        repository=new AnimeRepository(application);
        AnimeDbApiDataService animeDbApiDataService= AnimeDbRetrofitInstance.getService();
        AnimeDataSourceFactory factory=new AnimeDataSourceFactory(animeDbApiDataService,application);

        animeDataSourceLiveData=factory.getMutableLiveData();

        PagedList.Config config=(new PagedList.Config.Builder())
                .setEnablePlaceholders(true)
                .setInitialLoadSizeHint(10)
                .setPageSize(20)
                .setPrefetchDistance(4)
                .build();

        executor= Executors.newFixedThreadPool(5);
        pagedListLiveData=(new LivePagedListBuilder<Integer,AnimeInfoModel>(factory,config))
                .setFetchExecutor(executor)
                .build();
    }
    public LiveData<List<AnimeInfoModel>> getAllAnime(){
        return repository.getMutableLiveData();
    }

    public LiveData<PagedList<AnimeInfoModel>> getPagedListLiveData() {
        return pagedListLiveData;
    }
}
