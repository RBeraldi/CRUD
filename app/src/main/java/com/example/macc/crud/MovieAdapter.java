package com.example.macc.crud;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MovieAdapter extends ArrayAdapter<Movie> {


    private ArrayList<Movie> movies = null;
    private Context mContext = null;

    public MovieAdapter(@NonNull Context context, ArrayList<Movie> movies) {
        super(context, android.R.layout.simple_list_item_1 , movies);
        //super(context, 0 , movies);
        this.movies=movies;
        mContext = context;
     }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View movieView = LayoutInflater.from(mContext).inflate(R.layout.movie,parent,false);
        Movie movie = movies.get(position);

        TextView title = movieView.getRootView().findViewById(R.id.movieTitle);
        title.setText(movie.getTitle());

        return  movieView;
        //return super.getView(position, convertView, parent);
    }




}
