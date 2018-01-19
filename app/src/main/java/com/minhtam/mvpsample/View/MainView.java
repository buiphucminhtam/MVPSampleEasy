package com.minhtam.mvpsample.View;

import com.minhtam.mvpsample.Model.Movie;

import java.util.List;

/**
 * Created by st on 1/20/2018.
 */

public interface MainView {
    void updateListMovie(List<Movie> movieList);
    void showError(String message);
}
