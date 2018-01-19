package com.minhtam.mvpsample.DataManager.Cloud;

import com.minhtam.mvpsample.Model.Movie;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by st on 1/20/2018.
 */

public interface API {
    @GET("getmovie/{abcd}")
    Call<List<Movie>> listMovie(@Path("abcd") String abcd);
}
