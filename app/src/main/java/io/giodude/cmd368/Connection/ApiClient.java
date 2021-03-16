package io.giodude.cmd368.Connection;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static ApiInterface retrofitBuilder(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiInterface.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        ApiInterface apiCall = retrofit.create(ApiInterface.class);

        return apiCall;
    }
    public static ApiInterface retrofitBuilder1(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiInterface.BASE_URL1)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        ApiInterface apiCall = retrofit.create(ApiInterface.class);

        return apiCall;
    }
}
