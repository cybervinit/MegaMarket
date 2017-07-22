package com.inos.megamarket.data.classes;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.inos.megamarket.data.interfaces.ISharedPrefRepo;
import com.inos.megamarket.ui.splash_screen.ISplashScreenPresenter;

/**
 * Created by vinit on 2017-07-22.
 */

public class SharedPrefRepo implements ISharedPrefRepo {
    public static final String FIRST_APP_OPEN_KEY = "firstAppOpen";

    private static SharedPrefRepo thisRepo;

    private ISplashScreenPresenter mSplashScreenPresenter;
    private SharedPreferences mPref;

    private SharedPrefRepo() {/* CONSTRUCTOR */ }

    public static SharedPrefRepo getInstance(ISplashScreenPresenter splashScreenPresenter) {
        if (thisRepo == null) {
            thisRepo = new SharedPrefRepo();
            thisRepo.setPresenter(splashScreenPresenter);
        }
        return thisRepo;
    }

    public void setPresenter(ISplashScreenPresenter splashScreenPresenter) {
        this.mSplashScreenPresenter = splashScreenPresenter;
        this.mPref = PreferenceManager.getDefaultSharedPreferences(this.mSplashScreenPresenter.getContext());
    }

    @Override
    public boolean getBool(String key) {
        return this.mPref.getBoolean(key, false);
    }

    @Override
    public void writeBool(String key, boolean val) {
        SharedPreferences.Editor mPrefEdit = this.mPref.edit();
        mPrefEdit.putBoolean(key, val);
        mPrefEdit.apply();
    }
}
