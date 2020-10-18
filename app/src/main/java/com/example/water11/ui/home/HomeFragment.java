package com.example.water11.ui.home;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.water11.R;
import com.example.water11.ui.home.individual.IndividualFragment;
import com.example.water11.ui.home.task.TaskFragment;

public class HomeFragment extends Fragment{

    private HomeViewModel homeViewModel;
    Button btCurrent;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        replaceFragment(new IndividualFragment());
        final Button btCurrent=root.findViewById(R.id.bt_current);
        final Button btTask=root.findViewById(R.id.bt_task);
        btCurrent.setBackgroundColor(Color.WHITE);
        btCurrent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new IndividualFragment());
                btCurrent.setBackgroundColor(Color.WHITE);
                btTask.setBackgroundColor(Color.rgb(50,131,160));
            }
        });
        btTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new TaskFragment());
                btCurrent.setBackgroundColor(Color.rgb(50,131,160));
                btTask.setBackgroundColor(Color.WHITE);
            }
        });
        return root;
    }
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager=getFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.replace(R.id.water_layout,fragment);
        transaction.commit();
    }
}