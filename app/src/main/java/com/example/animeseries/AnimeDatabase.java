package com.example.animeseries;

import android.app.Application;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Anime.class}, version = 1, exportSchema = false)
public abstract class AnimeDatabase extends RoomDatabase {

    private static final String DB_NAME = "anime.db";
    private static AnimeDatabase instance = null;

    public static AnimeDatabase getInstance(Application application) {
        if (instance == null) {
            instance = Room.databaseBuilder(
                    application,
                    AnimeDatabase.class,
                    DB_NAME
            ).build();
        }
        return instance;
    }

    abstract AnimeDao animeDao();
}
