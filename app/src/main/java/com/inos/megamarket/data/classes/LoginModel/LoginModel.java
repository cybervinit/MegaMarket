package com.inos.megamarket.data.classes.LoginModel;

import com.inos.megamarket.ui.login.ILoginPresenter;

/**
 * Created by vinitsoni on 2017-09-17.
 */

public class LoginModel implements ILoginModel {

    private ILoginPresenter.forModel mLoginPresenter;

    public LoginModel(ILoginPresenter.forModel loginPresenter) {
        this.mLoginPresenter = loginPresenter;
    }

    @Override
    public void getEmailForLogin(String username) {
        // TODO: get email for gmail authentication
    }
}
