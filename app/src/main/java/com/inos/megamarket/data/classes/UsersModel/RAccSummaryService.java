package com.inos.megamarket.data.classes.UsersModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by vinit on 2017-07-28.
 */

public interface RAccSummaryService {

    public static final String base = "https://catchapi.herokuapp.com/";
    public static final String version = "v1/";

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(base+version)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    @GET("users")
    Call<Object> users();

}
