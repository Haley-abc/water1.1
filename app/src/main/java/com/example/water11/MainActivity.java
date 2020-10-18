package com.example.water11;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.water11.data.User;
import com.example.water11.ui.home.HomeFragment;
import com.example.water11.ui.home.individual.IndividualFragment;
import com.example.water11.ui.home.task.TaskFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import org.litepal.crud.DataSupport;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView nickName;
    TextView grade;
    TextView coinNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent=getIntent();
        int id=intent.getIntExtra("id",0);
        User user=DataSupport.find(User.class,id);

        nickName = (TextView) findViewById(R.id.tv_nick_name);
        grade=(TextView)findViewById(R.id.tv_grade);
        coinNumber=(TextView)findViewById(R.id.tv_coin_number);
        nickName.setText(user.getNickName());
        grade.setText(String.valueOf(user.getLevel()));
        coinNumber.setText(String.valueOf(user.getCoin()));

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications,R.id.navigation_service)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }
    }
}
