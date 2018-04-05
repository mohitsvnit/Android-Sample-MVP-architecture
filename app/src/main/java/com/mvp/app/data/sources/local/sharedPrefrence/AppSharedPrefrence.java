package com.mvp.app.data.sources.local.sharedPrefrence;

import android.content.Context;
import android.content.SharedPreferences;

public class AppSharedPrefrence implements PrefrenceHelper{

    private static final String PREF_APP_NAME = "app_pref_name_6598";
    private static PrefrenceHelper mInstance;
    private SharedPreferences sharedPreferences;

    private AppSharedPrefrence(Context context) {
        sharedPreferences = context.getSharedPreferences(PREF_APP_NAME, Context.MODE_PRIVATE);
    }

    public static PrefrenceHelper getInstance(Context context) {
        if(mInstance == null) {
            mInstance = new AppSharedPrefrence(context);
        }
        return mInstance;
    }

    @Override
    public void saveSessionKey(String key, String sessionKey) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, sessionKey);
        editor.apply();
    }
}
