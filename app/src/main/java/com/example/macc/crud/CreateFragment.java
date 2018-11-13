package com.example.macc.crud;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.widget.EditText;
import android.widget.Toast;



public class CreateFragment extends Fragment implements View.OnClickListener {


    private Callack callback = null;
    private MovieViewModel movieViewModel; //the viewModel of the view rendered by this fragment..

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        movieViewModel = ViewModelProviders.of(this).get(MovieViewModel.class);
        View view = inflater.inflate(R.layout.create,container,false);
        view.findViewById(R.id.btnCreateOK).setOnClickListener(this);
        return view;
    }


    @Override
    public void onClick(View v) {
        Toast.makeText(getContext(),"Movie is being created...",Toast.LENGTH_LONG).show();
        final String movieTitle = ((EditText)(getActivity().findViewById(R.id.inputMovieTitle))).getText().toString();
        new Thread(new Runnable() {
            @Override
            public void run() {
                movieViewModel.create(new Movie(movieTitle));
            }
        }).start();

        callback.done();
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        callback = (Callack) context;
    }
}
