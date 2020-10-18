package com.example.water11.ui.Service;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.water11.R;
import com.example.water11.ui.Service.activity.ActivityFragment;
import com.example.water11.ui.Service.curriculum.CurriculumFragment;
import com.example.water11.ui.Service.knowledge.KnowledgeFragment;
import com.example.water11.ui.Service.policy.PolicyFragment;
import com.example.water11.ui.dashboard.advanced.AdvancedFragment;
import com.example.water11.ui.dashboard.grade.GradeFragment;
import com.example.water11.ui.dashboard.progress.ProgressFragment;
import com.example.water11.ui.home.HomeViewModel;

public class ServiceFragment extends Fragment {

    private ServiceViewModel serviceViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        serviceViewModel =
                ViewModelProviders.of(this).get(ServiceViewModel.class);
        View root = inflater.inflate(R.layout.service_fragment, container, false);
        replaceFragment(new KnowledgeFragment());
        final Button btKnowledge=root.findViewById(R.id.bt_knowledge);
        final Button btPolicy=root.findViewById(R.id.bt_policy);
        final Button btActivity=root.findViewById(R.id.bt_activity);
        final Button btCurriculum=root.findViewById(R.id.bt_curriculum);
        btKnowledge.setBackgroundColor(Color.WHITE);
        btKnowledge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new KnowledgeFragment());
                btKnowledge.setBackgroundColor(Color.WHITE);
                btPolicy.setBackgroundColor(Color.rgb(50,131,160));
                btActivity.setBackgroundColor(Color.rgb(50,131,160));
                btCurriculum.setBackgroundColor(Color.rgb(50,131,160));
            }
        });
        btPolicy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new PolicyFragment());
                btKnowledge.setBackgroundColor(Color.rgb(50,131,160));
                btPolicy.setBackgroundColor(Color.WHITE);
                btActivity.setBackgroundColor(Color.rgb(50,131,160));
                btCurriculum.setBackgroundColor(Color.rgb(50,131,160));
            }
        });
        btActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new ActivityFragment());
                btKnowledge.setBackgroundColor(Color.rgb(50,131,160));
                btPolicy.setBackgroundColor(Color.rgb(50,131,160));
                btActivity.setBackgroundColor(Color.WHITE);
                btCurriculum.setBackgroundColor(Color.rgb(50,131,160));
            }
        });
        btCurriculum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new CurriculumFragment());
                btKnowledge.setBackgroundColor(Color.rgb(50,131,160));
                btPolicy.setBackgroundColor(Color.rgb(50,131,160));
                btActivity.setBackgroundColor(Color.rgb(50,131,160));
                btCurriculum.setBackgroundColor(Color.WHITE);
            }
        });
        return root;
    }
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager=getFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.replace(R.id.service_layout,fragment);
        transaction.commit();
    }
}
