package com.example.architecturecomp.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface NewsDao {

    @Insert
    void insertNews(News news);

    @Delete
    void deleteNews(News news);

    @Update
    void updateNews(News news);

    @Query("SELECT * FROM news_table")
    LiveData<List<News>> getAllNews();
}
