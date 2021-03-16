package io.giodude.cmd368.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

import io.giodude.cmd368.Adapter.PastAdapter;
import io.giodude.cmd368.Model.PastModel;
import io.giodude.cmd368.R;
import io.giodude.cmd368.ViewModel.PastViewModel;

public class PastView extends Fragment {
    private PastViewModel pastViewModel;
    private List<PastModel.PreviousEvents> eventsModel = new ArrayList<>();
    public PastAdapter pastAdapter;
    public static RecyclerView recyclerView;
    private RecyclerView.LayoutManager rLayout;
    public ProgressBar progressBar;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        view = inflater.inflate(R.layout.activity_past_view, container, false);
        progressBar = view.findViewById(R.id.progress);
        showevents();
        return view;
    }

    private void getEvents(List<PastModel.PreviousEvents> eventModels){
        recyclerView = view.findViewById(R.id.recyclerview);
        rLayout = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(rLayout);
        pastAdapter = new PastAdapter(getContext(), eventModels);
        recyclerView.setAdapter(pastAdapter);
    }

    private void showevents(){
        pastViewModel = ViewModelProviders.of(PastView.this).get(PastViewModel.class);
        pastViewModel.init();

        pastViewModel.getPast().observe(this, events ->{
            getEvents(events);
            eventsModel.addAll(events);
            pastAdapter.notifyDataSetChanged();

            if(eventsModel.size() == 0)
            {
                progressBar.setVisibility(View.VISIBLE);
            }else{
                progressBar.setVisibility(View.INVISIBLE);
            }
        });
    }
}