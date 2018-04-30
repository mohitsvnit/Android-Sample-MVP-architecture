package com.mvp.app.ui.login;

import com.mvp.app.base.BasePresenter;
import com.mvp.app.base.BaseView;
import com.mvp.app.data.model.User;

public interface LoginContract {
    interface Presenter extends BasePresenter<View>{
        void authenticateUser(String userName, String pass);
    }

    interface View extends BaseView<Presenter>{
        void onAuthenticationSuccessfull(User user);
        void onAuthenticationFailed(String error);
    }
}
