package com.example.architecturecomp.application.di;

import com.example.architecturecomp.application.MyApplication;

import dagger.Component;
import retrofit2.Retrofit;

@ApplicationScope
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    Retrofit getRetrofit();

    void inject(MyApplication myApplication);
}
