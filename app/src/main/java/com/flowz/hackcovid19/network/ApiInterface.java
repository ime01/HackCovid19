package com.flowz.hackcovid19.network;

import com.flowz.hackcovid19.PojoClasses.Summary;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("summary")
    Call<Summary> getSummary();
}
