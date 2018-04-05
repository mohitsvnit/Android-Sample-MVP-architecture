package com.mvp.app.data.sources.remote;

import com.mvp.app.data.model.User;
import com.mvp.app.data.sources.DataManager;

public interface RemoteDataSource {
    void authenticateUser(String userName, String password, DataManager.Callback<User> callback);
}
