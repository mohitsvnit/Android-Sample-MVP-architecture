package com.mvp.app.data.sources.remote;

import com.mvp.app.data.model.User;
import com.mvp.app.data.sources.DataManager;
import com.mvp.app.data.sources.remote.api.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RemoteDataSourceClass implements RemoteDataSource {

    private static RemoteDataSource mInstance;
    private ApiService service;

    private RemoteDataSourceClass(ApiService apiService) {
        this.service = apiService;
    }

    public static RemoteDataSource getInstance(ApiService apiService) {
        if(mInstance == null){
            mInstance = new RemoteDataSourceClass(apiService);
        }

        return mInstance;
    }

    @Override
    public void authenticateUser(String userName, String password, final DataManager.Callback<User> callback) {
        callback.onSuccess(new User("mohits", "Mohit Sharma"));

        final Call<User> request = service.authenticateUser(userName, password);
        request.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful()) {
                    callback.onSuccess(response.body());
                }else{
                    callback.onFailed(response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                callback.onFailed(t.getMessage());
            }
        });
    }
}
