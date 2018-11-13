package com.example.macc.crud;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;


@Database(entities = {Movie.class}, version = 1, exportSchema = false)
public abstract class MovieDB extends RoomDatabase {

    public abstract MovieDAO movieDAO();
    private static volatile MovieDB INSTANCE;

    static MovieDB getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (MovieDB.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            MovieDB.class, "movie_database3")
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}
