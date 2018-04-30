package com.mvp.app.ui.home;


import com.mvp.app.data.sources.DataManager;

public class HomePresenter implements HomeContract.Presenter {

    private static HomeContract.Presenter mInstance;

    private DataManager dataManager;
    private HomeContract.View view;

    private HomePresenter(DataManager dataManager, HomeContract.View view) {
        this.dataManager = dataManager;
        this.view = view;
    }

    public static HomeContract.Presenter getInstance(DataManager dataManager,
                                                     HomeContract.View view) {
        if (mInstance == null) {
            mInstance = new HomePresenter(dataManager, view);
        }

        return mInstance;
    }


    @Override
    public void attachView(HomeContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }
}
