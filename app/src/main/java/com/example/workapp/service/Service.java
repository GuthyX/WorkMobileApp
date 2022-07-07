package com.example.workapp.service;

import com.example.workapp.model.Result;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Service {
    private static Service instance = null;
    private Api myApi;
    private Service() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        myApi = retrofit.create(Api.class);
    }

    public static synchronized Service getInstance() {
        if (instance == null) {
            instance = new Service();
        }
        return instance;
    }

   public Call<List<Result>> getList() {
       Call<List<Result>> call = myApi.getResults();
       return  call;

    }

}
