package com.example.insta_recyclerview.utils;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferenceClass {
    //set user logged in key
    public static void saveLogin(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("login_details", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("isLoggedIn", true);
        editor.apply();
    }

    //get user logged in key
    public static boolean isLoggedIn(Context context) {
        SharedPreferences preferences = context.getSharedPreferences("login_details", MODE_PRIVATE);
        boolean isLogin = preferences.getBoolean("isLoggedIn", false);
        return isLogin;
    }
}
