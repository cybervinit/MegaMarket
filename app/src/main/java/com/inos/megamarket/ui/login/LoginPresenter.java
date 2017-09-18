package com.inos.megamarket.ui.login;

import com.inos.megamarket.data.classes.LoginModel.ILoginModel;
import com.inos.megamarket.data.classes.LoginModel.LoginModel;

/**
 * Created by vinitsoni on 2017-09-17.
 */

public class LoginPresenter implements ILoginPresenter.forModel, ILoginPresenter.forView {

    private ILoginView mLoginView;
    private ILoginModel mLoginModel;

    // program variables
    private String mUsername;
    private String mEmail;

    public LoginPresenter(ILoginView loginView) {
        this.mLoginView = loginView;
        this.mLoginModel = new LoginModel(this);
    }

    @Override
    public void loginWith(String username, String email) {
        this.mUsername = username;
        this.mEmail = email;
        mLoginModel.getEmailForLogin(username);
    }

    @Override
    public void onEmailReceived(String email) {
        // FIXME: compare emails
        if (!email.equals(mEmail)) {
            onLoginFailure("Your Google account doesn't match out servers.");
        } else {
            onLoginSuccess();
        }
    }


    private void onLoginSuccess() {
        // FIXME: update view with login successful
        mLoginView.onLoginSuccess(mUsername);
    }


    private void onLoginFailure(String error) {
        mLoginView.onLoginFailure(error);
    }
}
