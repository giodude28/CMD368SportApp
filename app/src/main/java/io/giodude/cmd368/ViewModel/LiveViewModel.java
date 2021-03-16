package io.giodude.cmd368.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import io.giodude.cmd368.Connection.Repositories;
import io.giodude.cmd368.Model.LiveModel;


public class LiveViewModel extends ViewModel {

    private MutableLiveData<List<LiveModel.Datum>> lives;
    public Repositories repositories;

    public void init(){
        if (lives != null){
            return;
        }
        repositories = Repositories.getInstance();
        lives = repositories.getLive();
    }

    public LiveData<List<LiveModel.Datum>> getLives(){
        return lives;
    }
}
