package com.mvp.app.base;

/**
 * Created by mohit on 30/4/18.
 */

public interface BasePresenter<T> {
    void attachView(T view);
    void detachView();
}
