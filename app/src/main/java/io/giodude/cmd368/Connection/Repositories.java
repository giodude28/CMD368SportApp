package io.giodude.cmd368.Connection;


import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import java.util.List;

import io.giodude.cmd368.Model.LiveModel;
import io.giodude.cmd368.Model.PastModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repositories {

    private static Repositories instance;
    static ApiClient rfit = new ApiClient();

    public static Repositories getInstance(){
        if (instance==null){
            instance = new Repositories();
        }
        return instance;
    }

    public MutableLiveData<List<LiveModel.Datum>> getLive(){

        final MutableLiveData<List<LiveModel.Datum>> data = new MutableLiveData<>();
        Call<LiveModel> call = rfit.retrofitBuilder().getLive();
        call.enqueue(new Callback<LiveModel>() {
            @Override
            public void onResponse(Call<LiveModel> call, Response<LiveModel> response) {
                try
                {
                    LiveModel datalist = response.body();
                    List<LiveModel.Datum> datumlist = datalist.getData();
                    data.setValue(datumlist);
                }catch (Exception e)
                {
                    Log.d("Data","Null List!");
                }

            }

            @Override
            public void onFailure(Call<LiveModel> call, Throwable t) {

            }
        });
    return data;
    }

    public MutableLiveData<List<PastModel.PreviousEvents>> getEvents(){

        final MutableLiveData<List<PastModel.PreviousEvents>> data = new MutableLiveData<>();
        Call<PastModel> call = rfit.retrofitBuilder1().getPast();
        call.enqueue(new Callback<PastModel>() {
            @Override
            public void onResponse(Call<PastModel> call, Response<PastModel> response) {
                try{
                    PastModel dataList1 = response.body();
                    List<PastModel.PreviousEvents> samples = dataList1.getPrevious();
                    data.setValue(samples);
                }catch (Exception e){
                    Log.d("Data","Null List!");
                }

            }

            @Override
            public void onFailure(Call<PastModel> call, Throwable t) {

            }
        });
        return data;
    }

}
