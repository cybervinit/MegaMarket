package com.inos.megamarket.ui.splash_screen;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.inos.megamarket.R;
import com.inos.megamarket.ui.onboarding.OnboardingActivity;

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
            // TODO: Start the next activity;
            Toast.makeText(getBaseContext(), "Start actual app work here...", Toast.LENGTH_LONG).show();
        }
        // this.finish();
    }

    @Override
    public Context getContextFromView() {
        return this.getBaseContext();
    }
}
