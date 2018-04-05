package com.mvp.app.data.sources.local;

import android.content.Context;

import com.mvp.app.data.model.User;
import com.mvp.app.data.sources.local.database.DbHelper;
import com.mvp.app.data.sources.local.sharedPrefrence.AppSharedPrefrence;
import com.mvp.app.data.sources.local.sharedPrefrence.PrefrenceHelper;

public class LocalDataSourceClass implements LocalDataSource {

    private static LocalDataSource mInstance;
    private PrefrenceHelper prefrenceHelper;
    private DbHelper dbHelper;

    private LocalDataSourceClass(Context context) {
        prefrenceHelper = AppSharedPrefrence.getInstance(context);
    }

    public static LocalDataSource getInstance(Context context) {
        if(mInstance == null) {
            mInstance = new LocalDataSourceClass(context);
        }

        return mInstance;
    }

    @Override
    public void saveUser(User user) {

    }
}
