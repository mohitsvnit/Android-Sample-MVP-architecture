package com.mvp.app;

import android.content.Context;

import com.mvp.app.data.sources.DataManager;
import com.mvp.app.data.sources.DataManagerClass;
import com.mvp.app.data.sources.local.LocalDataSource;
import com.mvp.app.data.sources.local.LocalDataSourceClass;
import com.mvp.app.data.sources.remote.RemoteDataSourceClass;
import com.mvp.app.data.sources.remote.api.ApiClient;
import com.mvp.app.data.sources.remote.api.ApiService;

public class Injection {

    public static DataManager provideDataManager(Context context) {

        return DataManagerClass.getInstance(LocalDataSourceClass.getInstance(context)
                , RemoteDataSourceClass.getInstance(ApiClient.getClient().create(ApiService.class)));
    }
}
