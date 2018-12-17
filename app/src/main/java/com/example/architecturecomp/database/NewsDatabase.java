package com.example.architecturecomp.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = News.class , version = 1)
public abstract class NewsDatabase extends RoomDatabase {

    private static NewsDatabase newsDatabase;

    public static synchronized NewsDatabase getInstance(Context context)
    {
        if(newsDatabase == null)
        {
            newsDatabase = Room.databaseBuilder(context.getApplicationContext(), NewsDatabase.class, "news_database")
                    .fallbackToDestructiveMigration().build();
        }
        return newsDatabase;
    }

    public abstract NewsDao getNewsDao();


}
