package com.example.architecturecomp;

import android.app.Application;
import android.arch.lifecycle.LiveData;

import com.example.architecturecomp.database.News;
import com.example.architecturecomp.database.NewsDao;
import com.example.architecturecomp.database.NewsDatabase;

import java.util.List;

public class NewsRepository {
    private NewsDao newsDao;
    private LiveData<List<News>> allNews;

    public NewsRepository(Application application){
       NewsDatabase newsDatabase =  NewsDatabase.getInstance(application);
       newsDao = newsDatabase.getNewsDao();
       allNews = newsDao.getAllNews();
    }

    public void insertNews(News news){
        // Should be done in background thread, Room takes care of methods that return liveData to be executed in bacground
        //thread , all others we need to take care
    }

    public void deleteNews(News news){

    }

    public LiveData<List<News>> getAllNews(){
        return allNews;
    }

}
