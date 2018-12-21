package com.example.architecturecomp.application;

import android.app.Application;

import com.example.architecturecomp.application.di.ApplicationComponent;
import com.example.architecturecomp.application.di.ApplicationModule;
import com.example.architecturecomp.application.di.DaggerApplicationComponent;

import javax.inject.Inject;

import retrofit2.Retrofit;

public class MyApplication extends Application {
    ApplicationComponent applicationComponent;

    @Inject
    Retrofit retrofit1;

    @Inject
    Retrofit retrofit2;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule()).build();

        Retrofit retrofit = applicationComponent.getRetrofit();

        applicationComponent.inject(this);
    }
}
