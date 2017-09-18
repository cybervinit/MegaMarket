package com.inos.megamarket.ui.login;

/**
 * Created by vinitsoni on 2017-09-17.
 */

public interface ILoginView {

    void onLoginSuccess(String username);
    void onLoginFailure(String errorMessage);
}
