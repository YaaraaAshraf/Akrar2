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
        return mSharedPreferences.getString(PREF_TOKEN, "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6Ijk1ZjU3MzQ1MjA1NGZhYWJkZTAyN2U2YWVkMGUwZWNjMmQxMjU1OGIxN2E3NzM3NGZkMTRmOWVlY2NiYjVmMGQyYjllODc4ZTQzMGZhOWNjIn0.eyJhdWQiOiIxIiwianRpIjoiOTVmNTczNDUyMDU0ZmFhYmRlMDI3ZTZhZWQwZTBlY2MyZDEyNTU4YjE3YTc3Mzc0ZmQxNGY5ZWVjY2JiNWYwZDJiOWU4NzhlNDMwZmE5Y2MiLCJpYXQiOjE1NjUwMDYxNDAsIm5iZiI6MTU2NTAwNjE0MCwiZXhwIjoxNTk2NjI4NTQwLCJzdWIiOiIxIiwic2NvcGVzIjpbXX0.EVUQ5uXIR1Hs7vJdMc74V1tSEBP_7KV2dFeopY7MyJeJL2TuYRkJ3wNKywtfrWnwQfbSe65WUbT-BOkgpXtdYofF_tar_-sVTXRL8Ncmdcd2sRbCgXEhczudu7bYHSYcxj6Oi_Hlz284n3t59Bn0SO6IVQZvmgWUoKPEFEY28zHEGK-nVYKw3gxZV4VjuZTgSxPrQaj_cB0Y-2MY3Uh37gdXv4YHU-C9aTBedI3kVvwOsZG_PgP6B2iOeaH8GHA33VJkOdFllYVs5lKPEpe8VOA-1GWDDBuKoMWM0RgEVUts8_iicwi0jPKEhbsAtM7aH_4pnlgLaU4224764FTI5Age250oTiKcCWY-XH_YHlxqh6LjPUSFo4Suu-m41jQCE79RlRmeDcbgD2g6r5TdEd3wH7wUL4sRNkJ4FclLNwrThrmbpFT4UqoVXZln_EvnflUiqu4osbKk8ZH2nxnm8bTmANO2FeJHWD1-fCCRf15QmVETXuqZY3PFf22jpNmyKk74MBxxG0N5I0MzsNNbC-sUZZfNdNK7eErQ0zrpZClxJGdYjdHkxDInTFA9omrejKkEuCNHbsWeLLA5g5Dqt0GxHGBfgTov0DnIYTkslS_p6yhKKPWErC_6zvSXjDY9ZGr4cN3-X-CZ59bgmCGiRrLckMK7US21mevEU6pNRQ4");
//        return mSharedPreferences.getString(PREF_DEVICE_SERIAL_KEY, null);
    }
}
