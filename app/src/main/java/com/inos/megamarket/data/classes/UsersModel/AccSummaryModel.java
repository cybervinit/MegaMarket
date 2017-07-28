package com.inos.megamarket.data.classes.UsersModel;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.inos.megamarket.data.interfaces.IAccSummaryModel;
import com.inos.megamarket.ui.dashboard.IAccSummaryPresenter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by vinit on 2017-07-28.
 */

public class AccSummaryModel implements IAccSummaryModel {

    public static final String TAG = "VINIT";

    private RAccSummaryService mUsersService;
    private IAccSummaryPresenter mPresenter;

    public AccSummaryModel(IAccSummaryPresenter presenter) {
        mUsersService = RAccSummaryService.retrofit.create(RAccSummaryService.class);
        this.mPresenter = presenter;
    }

    @Override
    public void getUsers() {
        Call<Object>  call = this.mUsersService.users();
        call.enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                Log.d(TAG, "Successful!");
                mPresenter.onUsersReceived("hey");
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                Log.d(TAG, "Failure");
                mPresenter.onUsersReceived(t.getMessage());
            }
        });

    }
}
