package com.example.animeapiretrofitexample.service;

import com.example.animeapiretrofitexample.model.AnimeGetDataModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface AnimeDbApiDataService {

    @Headers({"X-RapidAPI-Key:dc0574d5c4msh4bc3b5e267988d4p1cbc6fjsna6896bb699b0",
            "X-RapidAPI-Host:anime-db.p.rapidapi.com"})
    @GET("anime")
    Call<AnimeGetDataModel> getAllAnime(@Query("page") int page,@Query("size") int size);

    @Headers({"X-RapidAPI-Key:dc0574d5c4msh4bc3b5e267988d4p1cbc6fjsna6896bb699b0",
            "X-RapidAPI-Host:anime-db.p.rapidapi.com"})
    @GET("anime")
    Call<AnimeGetDataModel> getAnimeListWithPaging(@Query("page") int page,@Query("size") int size);


}
