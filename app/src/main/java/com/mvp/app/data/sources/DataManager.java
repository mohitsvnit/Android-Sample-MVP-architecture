package com.mvp.app.data.sources;

import com.mvp.app.data.model.User;

public interface DataManager {
    public void saveUser(User user);
    void authenticateUser(String userName, String password, Callback<User> callback);

    public interface Callback<T> {
        void onSuccess(T data);
        void onFailed(String error);
    }
}
