package com.example.macc.crud;

//import android.app.Fragment;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.widget.TextView;

import java.util.List;


public class ReadFragment extends Fragment { //WARNING: Fragment hinerhits FROM SUPPORT:V4.APP.FRAGMENT. USE GETSUPPORT FRAGMENT..


    private MovieViewModel movieViewModel; //the viewModel of the view rendered by this fragment..


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         final View view = inflater.inflate(R.layout.read,container,false);
         movieViewModel = ViewModelProviders.of(this).get(MovieViewModel.class);
         movieViewModel.getMovie(0).observe(this, new Observer<Movie>() {
             @Override
             public void onChanged(@Nullable Movie movie) {
                 if (movie!=null)
                 ((TextView)(getActivity().findViewById(R.id.movieTitle))).setText(movie.getTitle());
                 else
                     ((TextView)(getActivity().findViewById(R.id.movieTitle))).setText("Movie not found..");

             }
         });

         return view;
    }

}
