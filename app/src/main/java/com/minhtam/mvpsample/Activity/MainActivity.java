package com.minhtam.mvpsample.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.minhtam.mvpsample.Model.Movie;
import com.minhtam.mvpsample.Presenter.MainPresenter;
import com.minhtam.mvpsample.R;
import com.minhtam.mvpsample.View.MainView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView {

    private MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainPresenter = new MainPresenter(this);
    }


    @Override
    public void updateListMovie(List<Movie> movieList) {

    }

    @Override
    public void showError(String message) {

    }
}
