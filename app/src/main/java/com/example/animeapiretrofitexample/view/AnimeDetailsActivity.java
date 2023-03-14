package com.example.animeapiretrofitexample.view;

import android.content.Intent;
import android.os.Bundle;

import com.example.animeapiretrofitexample.databinding.ActivityAnimeDetailsBinding;
import com.example.animeapiretrofitexample.model.AnimeInfoModel;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;

import androidx.databinding.DataBindingUtil;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;



import com.example.animeapiretrofitexample.R;

public class AnimeDetailsActivity extends AppCompatActivity {

    private AnimeInfoModel animeInfoModel;
    ActivityAnimeDetailsBinding animeDetailsActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        animeDetailsActivity= DataBindingUtil.setContentView(this,R.layout.activity_anime_details);

        Intent intent=getIntent();
        if(intent.hasExtra("anime"))
        {

            animeInfoModel=getIntent().getParcelableExtra("anime");
          //  Log.d("parcelables",animeInfoModel.getId()+animeInfoModel.getTitle());
            animeDetailsActivity.setAnimeInfo(animeInfoModel);

        }

    }


}