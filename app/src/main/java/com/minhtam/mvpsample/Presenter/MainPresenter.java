package com.minhtam.mvpsample.Presenter;

import com.minhtam.mvpsample.DataManager.DataManagerment;
import com.minhtam.mvpsample.Model.MenuItem;
import com.minhtam.mvpsample.Model.Movie;
import com.minhtam.mvpsample.View.MainView;

import java.util.List;

/**
 * Created by st on 1/20/2018.
 */

public class MainPresenter {
    private DataManagerment dataManagerment;
    private MainView.MenuView menuView;
    private MainView.ListMovieView movieView;

    public MainPresenter(MainView.ListMovieView listMovieView, MainView.MenuView menuView) {
        dataManagerment = new DataManagerment();
        dataManagerment.setMovieListener(getMovieListener);
        dataManagerment.setMenuItemListener(menuItemListener);
        this.movieView = listMovieView;
        this.menuView = menuView;
    }


    /** LISTENER **/
    private DataManagerment.getMenuItemListener menuItemListener = new DataManagerment.getMenuItemListener() {
        @Override
        public void onResponse(List<MenuItem> menuItemList) {
            menuView.updateListMenu(menuItemList);
        }

        @Override
        public void onFailure(String message) {
            menuView.showError(message);
        }
    };

    private DataManagerment.getMovieListener getMovieListener = new DataManagerment.getMovieListener() {
        @Override
        public void onResponse(List<Movie> listMovie) {
            movieView.updateListMovie(listMovie);
        }

        @Override
        public void onFailure(String message) {
            movieView.showError(message);
        }
    };


    /**EXECUTE**/
    public void getMenuItemList() {
        dataManagerment.getMenuItem();
    }

    public void getMovieItemList() {
        dataManagerment.getMovie();
    }
}
