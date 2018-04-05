package com.mvp.app.data.sources.remote.api;

import com.mvp.app.data.model.User;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {
    @POST("authenticate")
    @FormUrlEncoded
    Call<User> authenticateUser(String userName, String pass);
}
