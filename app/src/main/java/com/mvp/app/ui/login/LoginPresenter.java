package com.mvp.app.ui.login;

import com.mvp.app.data.model.User;
import com.mvp.app.data.sources.DataManager;

public class LoginPresenter implements LoginContract.Presenter {

    private static LoginContract.Presenter mInstance;

    private DataManager dataManager;
    private LoginContract.View view;

    private LoginPresenter(DataManager dataManager, LoginContract.View view) {
        this.dataManager = dataManager;
        this.view = view;
    }

    public static LoginContract.Presenter getInstance(DataManager dataManager,
                                               LoginContract.View view) {
        if(mInstance == null) {
            mInstance = new LoginPresenter(dataManager, view);
        }

        return mInstance;
    }

    @Override
    public void authenticateUser(String userName, String pass) {
        dataManager.authenticateUser(userName, pass, new DataManager.Callback<User>() {
            @Override
            public void onSuccess(User data) {
                view.onAuthenticationSuccessfull(data);
            }

            @Override
            public void onFailed(String error) {

            }
        });
    }

    @Override
    public void attachView(LoginContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view =  null;
    }
}
