package com.example.rebelbob11.recyclerviewpractice.WebServices;

import com.example.rebelbob11.recyclerviewpractice.POJO.Hero;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("marvel/")
    Call<List<Hero>> getHeros();

}
