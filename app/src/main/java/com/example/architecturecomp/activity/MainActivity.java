package com.example.architecturecomp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.architecturecomp.R;
import com.example.architecturecomp.activity.di.ActivityComponent;
import com.example.architecturecomp.activity.di.ActivityModule;
import com.example.architecturecomp.activity.di.DaggerActivityComponent;

public class MainActivity extends AppCompatActivity {
    ActivityComponent activityComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activityComponent = DaggerActivityComponent.builder()
                .activityModule(new ActivityModule()).build();
    }
}
