package io.giodude.cmd368;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import io.giodude.cmd368.View.LiveView;
import io.giodude.cmd368.View.PastView;

public class FootballMain extends Fragment {

    public static BottomNavigationView navigationView;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    boolean doubleBackToExitPressedOnce = false;

    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        view = inflater.inflate(R.layout.activity_football_main, container, false);
        navigationView = view.findViewById(R.id.bottom_navigation);
        getChildFragmentManager().beginTransaction().replace(R.id.fLayout, new LiveView()).commit();

        declare();
        return view;
    }

    private void declare()
    {
        navigationView.setOnNavigationItemSelectedListener(item -> {
            Fragment selectedFragment = null;

            switch (item.getItemId()) {

                case R.id.live:
                    selectedFragment = new LiveView();
                    break;

                case R.id.previous:
                    selectedFragment = new PastView();
                    break;

            }
            getChildFragmentManager().beginTransaction()
                    .replace(R.id.fLayout,selectedFragment)
                    .commit();

            return true;
        });
    }

}