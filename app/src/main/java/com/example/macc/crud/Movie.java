package com.example.macc.crud;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.net.Uri;
import android.support.annotation.NonNull;

import java.nio.charset.Charset;
import java.util.Date;
import java.util.Random;


@Entity(tableName = "tbl_movies")
public class Movie {

    @PrimaryKey (autoGenerate = true)
    @NonNull
    private Integer mid;
    private String title;
    private Integer stars;


     public Movie() {this.title="Missed title";
        this.stars = 0;
        }

    public Movie(String title) {
         if (title.length()==0)
             title="Dummy title";
        this.title=title;
        this.stars = 0;
    }

    public  Movie(@NonNull Integer mid, String title, Date date, Integer stars) {
        this.mid = mid;
        this.title = title;
        this.stars = stars;
    }

    public Integer getStars() {

        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    @NonNull
    public Integer getMid() {
        return mid;
    }

    public void setMid(@NonNull Integer id) {
        this.mid = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


}
