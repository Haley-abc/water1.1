package com.example.water11.ui.dashboard;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import com.example.water11.R;
import com.example.water11.ui.dashboard.advanced.AdvancedFragment;
import com.example.water11.ui.dashboard.grade.GradeFragment;
import com.example.water11.ui.dashboard.progress.ProgressFragment;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        replaceFragment(new AdvancedFragment());
        final Button btAdvanced=root.findViewById(R.id.bt_advanced);
        final Button btProgress=root.findViewById(R.id.bt_progress);
        final Button btGrade=root.findViewById(R.id.bt_grade);
        btAdvanced.setBackgroundColor(Color.WHITE);
        btAdvanced.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new AdvancedFragment());
                btAdvanced.setBackgroundColor(Color.WHITE);
                btGrade.setBackgroundColor(Color.rgb(50,131,160));
                btProgress.setBackgroundColor(Color.rgb(50,131,160));
            }
        });
        btProgress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new ProgressFragment());
                btProgress.setBackgroundColor(Color.WHITE);
                btAdvanced.setBackgroundColor(Color.rgb(50,131,160));
                btGrade.setBackgroundColor(Color.rgb(50,131,160));
            }
        });
        btGrade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new GradeFragment());
                btGrade.setBackgroundColor(Color.WHITE);
                btAdvanced.setBackgroundColor(Color.rgb(50,131,160));
                btProgress.setBackgroundColor(Color.rgb(50,131,160));
            }
        });
        return root;
    }
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager=getFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.replace(R.id.list_layout,fragment);
        transaction.commit();
    }
}