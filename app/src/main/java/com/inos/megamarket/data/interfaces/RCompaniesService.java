package com.inos.megamarket.data.interfaces;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by vinit on 2017-07-30.
 */

public interface RCompaniesService {
    public static final String base = "https://catchapi.herokuapp.com/";
    public static final String version = "v1/";

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(base+version)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    // TODO: make more methods for COMPANIES;
}
