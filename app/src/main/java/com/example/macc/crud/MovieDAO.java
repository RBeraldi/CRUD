package com.example.macc.crud;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;


@Dao
public interface MovieDAO { //CRUD operations


    @Insert
    void Create(Movie movie);  //Create


    @Query("SELECT * FROM tbl_movies WHERE mid = :movieId")
    LiveData<Movie> Read(Integer movieId); //Read

    @Query("SELECT * FROM tbl_movies")
    LiveData<List<Movie>> ReadAll(); //Read all movies


    @Update()
    void Update(Movie movie);  //Update

    @Delete
    void Delete(Movie movie);   //Delete a movie


    @Query("DELETE FROM tbl_movies")
    void DeleteAll();   //Delete all movies



}
