package com.minhtam.mvpsample.Presenter;

import com.minhtam.mvpsample.DataManager.DataManagerment;
import com.minhtam.mvpsample.Model.Movie;
import com.minhtam.mvpsample.View.MainView;

import java.util.List;

/**
 * Created by st on 1/20/2018.
 */

public class MainPresenter implements DataManagerment.GetDataListener{
    private DataManagerment dataManagerment;
    private MainView mainView;

    public MainPresenter(MainView mainView) {
        dataManagerment = new DataManagerment();
        dataManagerment.setCallBack(this);
        this.mainView = mainView;
    }

    @Override
    public void onResponse(List<Movie> listMovie) {
        mainView.updateListMovie(listMovie);
    }

    @Override
    public void onFailure(String message) {
        mainView.showError(message);
    }
}
