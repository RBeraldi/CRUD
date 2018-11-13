package com.example.macc.crud;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MovieViewModel extends ViewModel {

    static private LiveData<Movie> movie;
    static private LiveData<List<Movie>> lmovies;
    static private MovieDB mdb=null;
    static private Context context = null;

//    static private



    public MovieViewModel(Context context){
        mdb = MovieDB.getDatabase(context);
        this.context=context;
    }


    public MovieViewModel() {

/*

        // SigletonDB.movieDB=mdb;


        //Set a Dummy Movie
        Movie m = new Movie(); //Set movie to a default Movie
        m.setTitle("Dummy title");
        MutableLiveData<Movie> movieMutableLiveData = new MutableLiveData<>();
        movieMutableLiveData.setValue(m);
        movie = movieMutableLiveData;


        //Set a Dummy List of dummy movies
        List<Movie> lm = new ArrayList<Movie>();

        lm.add(new Movie("Title 1"));
        lm.add(new Movie("Title 2"));

        lmovies = new MutableLiveData<List<Movie>>();
        ((MutableLiveData<List<Movie>>) lmovies).setValue(lm);
*/

    }

    public LiveData<Movie> getMovie(int mid){
        return mdb.movieDAO().Read(mid);
        //return movie;
    };

    public LiveData<List<Movie>> getAllMovies(){
        return mdb.movieDAO().ReadAll();
        //return lmovies;
    }

    public void create(Movie movie){
//        Toast.makeText(context,"Creating a movie",Toast.LENGTH_SHORT).show();
        mdb.movieDAO().Create(movie);
    }

    public void deleteAll(){
        // mdb.movieDAO().Create(new Movie(Math.random()*10+""));
        mdb.clearAllTables();
    }




}
