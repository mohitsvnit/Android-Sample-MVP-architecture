package com.mvp.app.base;

/**
 * Created by mohit on 30/4/18.
 */

public interface BaseView<T> {
    void setPresenter(T presenter);
    void showError(String error);
}
