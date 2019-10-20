package com.android_mvvm_databinding_recyclerviewexample.network;


import com.google.gson.JsonArray;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiDataService {


    @GET("developers")
    Call<JsonArray> getApiRequestsArray();

}
