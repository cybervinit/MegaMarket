package com.inos.megamarket.ui.login;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dd.morphingbutton.MorphingButton;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.inos.megamarket.R;
import com.inos.megamarket.ui.dashboard.DashboardActivity;

public class LoginActivity extends AppCompatActivity implements ILoginView {

    private ILoginPresenter.forView mLoginPresenter;

    // View vars
    Button mLoginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        // FIXME: impl login
        // TODO: use button lib


        this.mLoginPresenter = new LoginPresenter(this);

        // TODO: TEMP
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        final GoogleApiClient mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this /* FragmentActivity */, new GoogleApiClient.OnConnectionFailedListener() {
                    @Override
                    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
                        Toast.makeText(getBaseContext(), "Connection failed", Toast.LENGTH_SHORT).show();
                    }
                } /* OnConnectionFailedListener */)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();

        mLoginBtn = (Button) findViewById(R.id.login_btn);

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient)), 9001);
            }
        });


    }

    public String getUsername() {
        EditText usernameField = (EditText) findViewById(R.id.username_et);
        return usernameField.getText().toString();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 9001) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            if (result.isSuccess()) {
                mLoginPresenter.loginWith(getUsername(), result.getSignInAccount().getEmail());
                Toast.makeText(getBaseContext(), result.getSignInAccount().getEmail(), Toast.LENGTH_SHORT).show();
                // startActivity(new Intent(LoginActivity.this, DashboardActivity.class));
            } else {
                Toast.makeText(getBaseContext(), "Failed: ", Toast.LENGTH_SHORT).show();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onLoginSuccess(String username) {
        // FIXME: if login is successful, login here.
        startActivity(new Intent(LoginActivity.this, DashboardActivity.class).putExtra("USERNAME_KEY", username));
    }

    @Override
    public void onLoginFailure(String errorMessage) {
        Toast.makeText(this.getBaseContext(), errorMessage, Toast.LENGTH_SHORT).show();
    }
}
