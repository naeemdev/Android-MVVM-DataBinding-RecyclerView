package com.android_mvvm_databinding_recyclerviewexample.repository;

import androidx.lifecycle.MutableLiveData;

import com.android_mvvm_databinding_recyclerviewexample.Model.DeveloperModel;
import com.android_mvvm_databinding_recyclerviewexample.network.ApiDataService;
import com.android_mvvm_databinding_recyclerviewexample.network.RetrofitClient;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DeveloperRepository {

    private static final String TAG = "DeveloperRepository";
    private ArrayList<DeveloperModel> mmDeveloperModelmist = new ArrayList<>();
    private MutableLiveData<List<DeveloperModel>> mutableLiveData = new MutableLiveData<>();

    public DeveloperRepository() {
    }

    ////call to internet and  retun  MutableLiveData
    public MutableLiveData<List<DeveloperModel>> getMutableLiveData() {

        ///ini Retrofit Class
        final ApiDataService userDataService = RetrofitClient.getService();

        ///call the API that define In Interface
        Call<JsonArray> call = userDataService.getApiRequestsArray();

        call.enqueue(new Callback<JsonArray>() {
            String message;

            @Override
            public void onResponse(Call<JsonArray> call, Response<JsonArray> resp) {

                /// parse the data if  Response successfully and store data in MutableLiveData  and retrun to DeveloperViewModel class
                Gson gson = new GsonBuilder().create();

                if (resp != null && resp.body() != null) {
                    JsonArray json = new JsonParser().parse(resp.body().toString()).getAsJsonArray();
                    if (json != null) {

                        for (int i = 0; i <= json.size() - 1; i++) {
                            try {

                                JsonObject jsonobj = new JsonParser().parse(json.get(i).toString()).getAsJsonObject();

                                DeveloperModel responseModel = gson.fromJson(jsonobj, DeveloperModel.class);

                                mmDeveloperModelmist.add(responseModel);

                            } catch (Exception ex) {

                            }


                        }
                        mutableLiveData.setValue(mmDeveloperModelmist);

                    }
                }


            }

            @Override
            public void onFailure(Call<JsonArray> call, Throwable t) {
                t.printStackTrace();

            }
        });


        return mutableLiveData;
    }
}
