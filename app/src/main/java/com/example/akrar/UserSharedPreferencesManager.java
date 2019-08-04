package com.example.akrar;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;

public class UserSharedPreferencesManager {

    private static final String FILE_DEVICE_PREFS = "device_prefs";
    private static final String PREF_TOKEN = "USER_TOKEN";
    private static UserSharedPreferencesManager deviceSharedPrefs;
    private SharedPreferences mSharedPreferences;

    private static UserSharedPreferencesManager createInstance(@NonNull Context context){
        if(deviceSharedPrefs == null)
            deviceSharedPrefs = new UserSharedPreferencesManager(context);
        return deviceSharedPrefs;
    }

    public static UserSharedPreferencesManager getInstance(@NonNull Context context){
        if(deviceSharedPrefs == null)
            createInstance(context);
        return deviceSharedPrefs;
    }

    private UserSharedPreferencesManager(@NonNull Context context) {
        mSharedPreferences = context.getSharedPreferences(FILE_DEVICE_PREFS, Context.MODE_PRIVATE);
    }

    public void saveToken(String token) {
        mSharedPreferences.edit()
                .putString(PREF_TOKEN, token)
                .apply();
    }

    public String getToken() {
        return mSharedPreferences.getString(PREF_TOKEN, null);
//        return mSharedPreferences.getString(PREF_DEVICE_SERIAL_KEY, null);
    }
}
