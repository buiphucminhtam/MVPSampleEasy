package com.minhtam.mvpsample.View;

import com.minhtam.mvpsample.Model.MenuItem;
import com.minhtam.mvpsample.Model.Movie;

import java.util.List;

/**
 * Created by st on 1/20/2018.
 */

public interface MainView {

    //Update loading view
    void showLoading();
    void hideLoading();

    public interface ListMovieView{
        //Update data view
        void updateListMovie(List<Movie> movieList);
        void showError(String message);

    }

    public interface MenuView{
        //Update data view
        void updateListMenu(List<MenuItem> menuItemList);
        void showError(String message);
    }

}
