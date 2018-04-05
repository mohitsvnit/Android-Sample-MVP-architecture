package com.mvp.app.data.sources.local;

import com.mvp.app.data.model.User;

public interface LocalDataSource {
    public void saveUser(User user);
}
