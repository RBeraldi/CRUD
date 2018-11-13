package com.example.macc.crud;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class MainActivity extends AppCompatActivity implements Callack {

    private MovieViewModel movieViewModel = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        movieViewModel =new MovieViewModel(this);

       // MovieDB mdb = MovieDB.getDatabase(this);
       // SigletonDB.movieDB=mdb;

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.reset) {

            Snackbar.make(findViewById(R.id.rootView),"Delete all movies",Snackbar.LENGTH_SHORT).show();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    //SigletonDB.movieDB.movieDAO().DeleteAll();
                    movieViewModel.deleteAll();
                }
            }).start();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void create(View view) {
        Snackbar.make(view,"Create a movie",Snackbar.LENGTH_SHORT).show();
        getSupportFragmentManager().
                beginTransaction().
                replace(R.id.content,new CreateFragment()).
                commit();
    }

    public void read(final View view) {
        getSupportFragmentManager().
                beginTransaction().
                replace(R.id.content,new ReadFragment()).
                commit();
    }


    public void readAll(final View view) {
        getSupportFragmentManager().
                beginTransaction().
                replace(R.id.content,new ReadAllFragment()).
                commit();
        }


    public void update(final View view) {
        getFragmentManager().
                beginTransaction().
                replace(R.id.content,new UpdateFragment()).
                commit();
        }

    public void delete(final View view) {
        getFragmentManager().
                beginTransaction().
                replace(R.id.content,new DeleteFragment()).
                commit();
    }

    @Override
    public void done() {
        getSupportFragmentManager().
                beginTransaction().
                replace(R.id.content,new ReadAllFragment()).
                commit();
    }
}
