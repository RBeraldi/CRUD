package com.example.macc.crud;

//import android.app.Fragment;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v4.app.Fragment;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;


public class ReadAllFragment extends Fragment {

    private MovieViewModel movieViewModel; //the viewModel of the view rendered by this fragment..
    MovieAdapter movieAdapter = null;
    ArrayList<Movie> movielist = new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.readall,container,false);

        movieAdapter = new MovieAdapter(getContext(),movielist);

        movieViewModel = ViewModelProviders.of(this).get(MovieViewModel.class);
        movieViewModel.getAllMovies().observe(this, new Observer<List<Movie>>() {
                    @Override
                    public void onChanged(@Nullable List<Movie> movies) {
                        movielist.clear();
                        for (Movie movie : movies){
                        movielist.add(movie);
                        }
                        movieAdapter.notifyDataSetChanged();
                        }
        }
        );
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ((ListView) getActivity().findViewById(R.id.listAllMovies)).setAdapter(movieAdapter);
    }
}
