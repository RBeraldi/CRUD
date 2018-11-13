package com.example.macc.crud;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class UpdateFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         final View view = inflater.inflate(R.layout.update,container,false);

         new Thread(new Runnable() {
            @Override
            public void run() {
                    //Snackbar.make(view,"Updating a movie",Snackbar.LENGTH_SHORT).show();
            }
        }).start();
         return view;
    }
}
