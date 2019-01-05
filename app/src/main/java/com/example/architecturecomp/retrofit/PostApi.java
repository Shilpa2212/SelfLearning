package com.example.architecturecomp.retrofit;

import com.example.architecturecomp.database.News;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostApi {

    @GET("posts")
    Call<List<Post>> getPosts();
}
