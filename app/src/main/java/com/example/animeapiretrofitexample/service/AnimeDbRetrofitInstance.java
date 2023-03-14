package com.example.animeapiretrofitexample.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AnimeDbRetrofitInstance {
    private static Retrofit retrofit=null;
    private static String BASE_URL="https://anime-db.p.rapidapi.com/";

    public static  AnimeDbApiDataService getService(){
        if(retrofit==null)
        {
            retrofit=new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(AnimeDbApiDataService.class);
    }
}
