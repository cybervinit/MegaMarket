package com.inos.megamarket.ui.onboarding;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntroFragment;
import com.inos.megamarket.R;
import com.inos.megamarket.ui.login.LoginActivity;

public class OnboardingActivity extends AppIntro {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // FIXME: may need to setContentView(...);


        addSlide(AppIntroFragment.newInstance("Trade Stocks",
                                                "Buy and sell stocks in a simple, fun stock market!",
                                                R.drawable.ic_arrow_back_white, Color.parseColor("#455a64")));
        addSlide(AppIntroFragment.newInstance("Play to get the best trade price",
                "win minigame to get the highest selling price or lowest buying price",
                R.drawable.ic_arrow_forward_white, Color.parseColor("#455a64")));


        showSkipButton(false);
    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        startActivity(new Intent(OnboardingActivity.this, LoginActivity.class));
    }
}
