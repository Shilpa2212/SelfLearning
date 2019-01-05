package com.example.architecturecomp.application;

import android.app.Application;
import android.util.Log;

import com.example.architecturecomp.application.di.ApplicationComponent;
import com.example.architecturecomp.application.di.ApplicationModule;
import com.example.architecturecomp.application.di.DaggerApplicationComponent;
import com.example.architecturecomp.retrofit.Post;
import com.example.architecturecomp.retrofit.PostApi;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyApplication extends Application {
    ApplicationComponent applicationComponent;

    @Inject
    Retrofit retrofit1;

    @Inject
    Retrofit retrofit2;

    @Override
    public void onCreate() {
        super.onCreate();

      /**  applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule()).build();

        Retrofit retrofit = applicationComponent.getRetrofit();

        applicationComponent.inject(this);*/


        //Normal use of retrofit without DI
        Retrofit retrofit3 = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PostApi postApi = retrofit3.create(PostApi.class);
        Call<List<Post>> call = postApi.getPosts();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                List<Post> posts = response.body();
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Log.d("<>","******"+t.getLocalizedMessage());
            }
        });
    }
}
