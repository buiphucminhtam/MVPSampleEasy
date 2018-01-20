package com.minhtam.mvpsample.Activity;

import android.app.Activity;
import android.os.Bundle;

import com.minhtam.mvpsample.Model.MenuItem;
import com.minhtam.mvpsample.Model.Movie;
import com.minhtam.mvpsample.Presenter.MainPresenter;
import com.minhtam.mvpsample.R;
import com.minhtam.mvpsample.View.MainView;

import java.util.List;

public class MainActivity extends Activity implements MainView{

    private MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainPresenter = new MainPresenter(listMovieView, menuView);

        mainPresenter.getMenuItemList();
        mainPresenter.getMovieItemList();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    private MainView.ListMovieView listMovieView = new MainView.ListMovieView() {
        @Override
        public void updateListMovie(List<Movie> movieList) {

        }

        @Override
        public void showError(String message) {

        }
    };

    private MainView.MenuView menuView = new MainView.MenuView() {
        @Override
        public void updateListMenu(List<MenuItem> menuItemList) {

        }

        @Override
        public void showError(String message) {

        }
    };
}
