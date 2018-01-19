package com.minhtam.mvpsample.DataManager;

import com.minhtam.mvpsample.DataManager.Cloud.API;
import com.minhtam.mvpsample.DataManager.Cloud.Client;
import com.minhtam.mvpsample.Model.Movie;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by st on 1/20/2018.
 */

public class DataManagerment {

    private GetDataListener callBack;

    public void setCallBack(GetDataListener callBack) {
        this.callBack = callBack;
    }

    public void getMovie(){
        API api = Client.getAPI();
        Call<List<Movie>> call = api.listMovie("abcd");
        call.enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                if (response.isSuccessful()) {
                    callBack.onResponse(response.body());
                } else {
                    callBack.onFailure(response.message());
                }
            }

            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {
                callBack.onFailure(t.getMessage());
                t.printStackTrace();
            }
        });
    }

    public interface GetDataListener{
        void onResponse(List<Movie> listMovie);
        void onFailure(String message);
    }
}
