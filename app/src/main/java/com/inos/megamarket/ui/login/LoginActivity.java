package com.inos.megamarket.ui.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.dd.morphingbutton.MorphingButton;
import com.inos.megamarket.R;
import com.inos.megamarket.ui.dashboard.DashboardActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        // FIXME: impl login
        // TODO: use button lib
        startActivity(new Intent(LoginActivity.this, DashboardActivity.class));

    }
}
