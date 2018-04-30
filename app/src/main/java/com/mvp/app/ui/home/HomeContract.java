package com.mvp.app.ui.home;

import com.mvp.app.base.BasePresenter;
import com.mvp.app.base.BaseView;

public interface HomeContract {
    interface Presenter extends BasePresenter<View> {

    }

    interface View extends BaseView<Presenter> {

    }
}
