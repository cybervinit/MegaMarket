package com.inos.megamarket.ui.login;

/**
 * Created by vinitsoni on 2017-09-17.
 */

public interface ILoginPresenter {


    interface forView {
        void loginWith(String username, String email);
    }

    interface forModel {
        void onEmailReceived(String email);
    }
}
