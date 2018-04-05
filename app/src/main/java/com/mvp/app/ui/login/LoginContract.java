package com.mvp.app.ui.login;

import com.mvp.app.data.model.User;

public interface LoginContract {
    interface Presenter {
        void authenticateUser(String userName, String pass);
    }

    interface View {
        void onAuthenticationSuccessfull(User user);
        void onAuthenticationFailed(String error);
    }
}
