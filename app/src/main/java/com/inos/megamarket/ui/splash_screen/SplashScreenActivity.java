package com.inos.megamarket.ui.splash_screen;

import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.inos.megamarket.R;
import com.inos.megamarket.ui.login.LoginActivity;
import com.inos.megamarket.ui.onboarding.OnboardingActivity;

import java.util.List;
import java.util.Locale;

public class SplashScreenActivity extends AppCompatActivity implements ISplashScreenView {

    private ISplashScreenPresenter mSplashScreenPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // FIXME: may need to setContentView(...);

        this.mSplashScreenPresenter = new SplashScreenPresenter(this);
        boolean firstAppOpen = this.mSplashScreenPresenter.getFirstAppOpen();



        if (firstAppOpen) {
            startActivity(new Intent(SplashScreenActivity.this, OnboardingActivity.class));
        } else {
            // TODO: may need to check if user logged in from last session;
            startActivity(new Intent(SplashScreenActivity.this, LoginActivity.class));
        }

    }

    @Override
    public Context getContextFromView() {
        return this.getBaseContext();
    }
}
