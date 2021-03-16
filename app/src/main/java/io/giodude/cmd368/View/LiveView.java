package io.giodude.cmd368.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import io.giodude.cmd368.Adapter.LiveAdapter;
import io.giodude.cmd368.Model.LiveModel;
import io.giodude.cmd368.R;
import io.giodude.cmd368.ViewModel.LiveViewModel;

public class LiveView extends Fragment {
    private LiveViewModel liveViewModel;
    private List<LiveModel.Datum> livemodel = new ArrayList<>();
    public LiveAdapter liveAdapter;
    public static RecyclerView recyclerView;
    private RecyclerView.LayoutManager rLayout;
    public ProgressBar progressBar;
    public TextView text;
    View root;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.activity_live_view,container,false);
        text = root.findViewById(R.id.tete);
        progressBar = root.findViewById(R.id.progress);

        showlives();
        return root;
    }



    private void getLives(List<LiveModel.Datum> livemodel){
        recyclerView = root.findViewById(R.id.recyclerview);
        rLayout = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(rLayout);
        liveAdapter = new LiveAdapter(getContext(), livemodel);
        recyclerView.setAdapter(liveAdapter);
    }

    private void showlives(){
        liveViewModel = ViewModelProviders.of(LiveView.this).get(LiveViewModel.class);
        liveViewModel.init();


        liveViewModel.getLives().observe(this,lives ->{
            getLives(lives);
            livemodel.addAll(lives);
            liveAdapter.notifyDataSetChanged();

            if(livemodel.size() == 0)
            {
                progressBar.setVisibility(View.VISIBLE);
                text.setVisibility(View.VISIBLE);
            }else{
                progressBar.setVisibility(View.INVISIBLE);
                text.setVisibility(View.INVISIBLE);
            }
        });
    }
}