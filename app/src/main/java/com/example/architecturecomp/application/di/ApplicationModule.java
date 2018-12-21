package com.example.architecturecomp.application.di;

import com.example.architecturecomp.BuildConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApplicationModule {

    @ApplicationScope
    @Provides
    Retrofit getRetrofit(GsonConverterFactory gsonConverterFactory){
        return new Retrofit.Builder().baseUrl(BuildConfig.BASE_URL).
                addConverterFactory(gsonConverterFactory).build();
    }

    @Provides
    GsonConverterFactory gsonConverterFactory(Gson gson)
    {
        return GsonConverterFactory.create(gson);
    }

    @Provides
    Gson gson(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        return gsonBuilder.create();
    }
}
