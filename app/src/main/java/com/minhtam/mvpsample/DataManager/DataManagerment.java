package com.minhtam.mvpsample.DataManager;

import com.minhtam.mvpsample.DataManager.Cloud.API;
import com.minhtam.mvpsample.DataManager.Cloud.Client;
import com.minhtam.mvpsample.Model.MenuItem;
import com.minhtam.mvpsample.Model.Movie;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by st on 1/20/2018.
 */

public class DataManagerment {

    private getMovieListener movieListener;
    private getMenuItemListener menuItemListener;

    public void getMovie(){
        API api = Client.getAPI();
        Call<List<Movie>> call = api.listMovie("abcd");
        call.enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                if (response.isSuccessful()) {
                    movieListener.onResponse(response.body());
                } else {
                    movieListener.onFailure(response.message());
                }
            }

            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {
                movieListener.onFailure(t.getMessage());
                t.printStackTrace();
            }
        });
    }

    public void getMenuItem() {
        API api = Client.getAPI();
        Call<List<MenuItem>> call = api.listMenu("something");
        call.enqueue(new Callback<List<MenuItem>>() {
            @Override
            public void onResponse(Call<List<MenuItem>> call, Response<List<MenuItem>> response) {
                if (response.isSuccessful()) {
                    menuItemListener.onResponse(response.body());
                } else {
                    menuItemListener.onFailure(response.message());
                }
            }

            @Override
            public void onFailure(Call<List<MenuItem>> call, Throwable t) {
                menuItemListener.onFailure(t.getMessage());
                t.printStackTrace();
            }
        });
    }


    public void setMenuItemListener(getMenuItemListener menuItemListener) {
        this.menuItemListener = menuItemListener;
    }

    public void setMovieListener(getMovieListener movieListener) {
        this.movieListener = movieListener;
    }

    public interface getMovieListener {
        void onResponse(List<Movie> listMovie);
        void onFailure(String message);
    }

    public interface getMenuItemListener{
        void onResponse(List<MenuItem> menuItemList);
        void onFailure(String message);
    }
}
