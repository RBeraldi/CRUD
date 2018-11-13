package com.example.macc.crud;

import android.app.Application;

public class MovieRepository {

    private MovieDAO movieDAO=null;
    MovieRepository(Application application) {
        MovieDB db = MovieDB.getDatabase(application);
        movieDAO = db.movieDAO();
    }


}
