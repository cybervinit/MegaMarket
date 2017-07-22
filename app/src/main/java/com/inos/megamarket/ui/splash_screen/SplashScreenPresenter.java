package com.inos.megamarket.ui.splash_screen;

import android.content.Context;

import com.inos.megamarket.data.classes.SharedPrefRepo;
import com.inos.megamarket.data.interfaces.ISharedPrefRepo;

/**
 * Created by vinit on 2017-07-22.
 */

public class SplashScreenPresenter implements ISplashScreenPresenter {

    ISplashScreenView mSplashScreenView;
    ISharedPrefRepo mSharedPrefRepo;

    public SplashScreenPresenter(ISplashScreenView splashScreenView) {
        this.mSplashScreenView = splashScreenView;
        this.mSharedPrefRepo = SharedPrefRepo.getInstance(this);
    }


    @Override
    public Context getContext() {
        return this.mSplashScreenView.getContextFromView();
    }

    @Override
    public boolean getFirstAppOpen() {
        boolean firstAppOpen = mSharedPrefRepo.getBool(SharedPrefRepo.FIRST_APP_OPEN_KEY);
        if (firstAppOpen) {
            this.mSharedPrefRepo.writeBool(SharedPrefRepo.FIRST_APP_OPEN_KEY, false);
        }
        return firstAppOpen;
    }


}
