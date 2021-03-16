package io.giodude.cmd368.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import io.giodude.cmd368.Connection.Repositories;
import io.giodude.cmd368.Model.PastModel;


public class PastViewModel extends ViewModel {

    private MutableLiveData<List<PastModel.PreviousEvents>> pasts;
    public Repositories repositories;

    public void init(){
        if (pasts != null){
            return;
        }
        repositories = Repositories.getInstance();
        pasts = repositories.getEvents();
    }

    public LiveData<List<PastModel.PreviousEvents>> getPast(){
        return pasts;
    }
}
