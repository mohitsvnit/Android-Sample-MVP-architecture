package com.mvp.app.data.sources;

import com.mvp.app.data.model.User;
import com.mvp.app.data.sources.local.LocalDataSource;
import com.mvp.app.data.sources.remote.RemoteDataSource;

public class DataManagerClass implements DataManager {

    private static DataManager mInstance;

    private LocalDataSource localDataSource;
    private RemoteDataSource remoteDataSource;



    public static DataManager getInstance(LocalDataSource localDataSource,
                                          RemoteDataSource remoteDataSource) {
        if(mInstance == null) {
            mInstance = new DataManagerClass(localDataSource, remoteDataSource);
        }

        return mInstance;
    }

    private DataManagerClass(LocalDataSource localDataSource, RemoteDataSource remoteDataSource) {
        this.localDataSource = localDataSource;
        this.remoteDataSource = remoteDataSource;
    }

    @Override
    public void saveUser(User user) {

    }

    @Override
    public void authenticateUser(String userName, String password, final Callback<User> callback) {
        remoteDataSource.authenticateUser(userName, password, new Callback<User>() {
            @Override
            public void onSuccess(User data) {
                callback.onSuccess(data);
            }

            @Override
            public void onFailed(String error) {
                callback.onFailed(error);
            }
        });
    }

}
