package com.example.animeapiretrofitexample.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;

import com.example.animeapiretrofitexample.R;
import com.example.animeapiretrofitexample.adapter.AnimeListAdapter;
import com.example.animeapiretrofitexample.databinding.ActivityMainBinding;
import com.example.animeapiretrofitexample.model.AnimeGetDataModel;
import com.example.animeapiretrofitexample.model.AnimeInfoModel;
import com.example.animeapiretrofitexample.repository.AnimeRepository;
import com.example.animeapiretrofitexample.service.AnimeDbApiDataService;
import com.example.animeapiretrofitexample.service.AnimeDbRetrofitInstance;
import com.example.animeapiretrofitexample.viewmodel.AnimeMainActivityViewModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
   //with paging
   PagedList<AnimeInfoModel> animeInfo;
    //normal
    //ArrayList<AnimeInfoModel> animeInfo;
    private RecyclerView animeListRecycler;
    private AnimeListAdapter animeListAdapter;
    private SwipeRefreshLayout swipeRefreshLayout;
    private AnimeRepository animeRepository;
    private AnimeMainActivityViewModel animeMainActivityViewModel;
    ActivityMainBinding activityMainBinding;


    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);

        activityMainBinding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        swipeRefreshLayout=activityMainBinding.reloadAnimeList;
        swipeRefreshLayout.setColorSchemeColors(R.color.black);
        animeMainActivityViewModel= new ViewModelProvider(this).get(AnimeMainActivityViewModel.class);
        getList();
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getList();
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    private void getList() {
        //mvvm method

       /*animeMainActivityViewModel.getAllAnime().observe(this, new Observer<List<AnimeInfoModel>>() {
           @Override
           public void onChanged(List<AnimeInfoModel> animeInfoModels) {
               animeInfo=(ArrayList<AnimeInfoModel>) animeInfoModels;
               showOnRecyclerView();
           }
       });*/


        //normal methond
      /*  AnimeDbApiDataService dbApiDataService= AnimeDbRetrofitInstance.getService();
        Call<AnimeGetDataModel> call=dbApiDataService.getAllAnime(1,1000);
        call.enqueue(new Callback<AnimeGetDataModel>() {
            @Override
            public void onResponse(Call<AnimeGetDataModel> call, Response<AnimeGetDataModel> response) {
                //Log.d("listOfAnime",response.body().getData().get(0).getAlternativeTitles().toString());
                AnimeGetDataModel animeGetDataModel=response.body();
                if(animeGetDataModel!=null && animeGetDataModel!=null)
                {
                    animeInfoModels=(ArrayList<AnimeInfoModel>) animeGetDataModel.getData();
                    showOnRecyclerView();

                }
            }



            @Override
            public void onFailure(Call<AnimeGetDataModel> call, Throwable t) {

            }
        });*/



        //with paging
        animeMainActivityViewModel.getPagedListLiveData().observe(this, new Observer<PagedList<AnimeInfoModel>>() {
            @Override
            public void onChanged(PagedList<AnimeInfoModel> animeInfoFromLiveData) {
                animeInfo=animeInfoFromLiveData;
                showOnRecyclerView();
            }
        });
    }
    private void showOnRecyclerView() {
        animeListRecycler=activityMainBinding.animeListRecycler;
        animeListAdapter=new AnimeListAdapter(this);
        animeListAdapter.submitList(animeInfo);

        if(this.getResources().getConfiguration().orientation== Configuration.ORIENTATION_PORTRAIT)
        {
           // animeListRecycler.setLayoutManager(new GridLayoutManager(this,2));
            animeListRecycler.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        }
        else
        {
           // animeListRecycler.setLayoutManager(new GridLayoutManager(this,4));
            animeListRecycler.setLayoutManager(new StaggeredGridLayoutManager(4,StaggeredGridLayoutManager.VERTICAL));

        }
        animeListRecycler.setItemAnimator(new DefaultItemAnimator());
        animeListRecycler.setAdapter(animeListAdapter);
        animeListAdapter.notifyDataSetChanged();

    }
}