package com.example.dell.currencyconverter.data.prefs;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

import com.example.dell.currencyconverter.Application;
import com.example.dell.currencyconverter.data.model.Country;
import com.example.dell.currencyconverter.data.model.theme.ThemeObject;
import com.example.dell.currencyconverter.utils.Config;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class AppPreferencesHelper implements PreferencesHelper {

    private static final String PREF_FILE_NAME = "BrainyWords";

    private final SharedPreferences mPref;
    private final SharedPreferences.Editor mEditor;

    private final Gson mGson;

    @SuppressLint("CommitPrefEdits")
    public AppPreferencesHelper(Context context) {
        mPref = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
        mEditor = mPref.edit();
        mGson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSz")
                .create();
    }

    @Override
    public List<ThemeObject> parseDataTheme() {
        try {
            String jsonLetters = "";
            InputStream inputStream = Application.Context.getAssets().open("themes.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            jsonLetters = new String(buffer, "UTF-8");

            Type listType = new TypeToken<List<ThemeObject>>() {
            }.getType();

            return mGson.fromJson(jsonLetters, listType);
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    @Override
    public ThemeObject getDefaultTheme() {
        return parseDataTheme().get(0);
    }

    @Override
    public void saveThemeState(ThemeObject themeObject) {
        Gson gson = new Gson();
        String jsonInString = gson.toJson(themeObject);
        mEditor.putString(Config.THEME_STATE, jsonInString);
        mEditor.apply();
    }

    @Override
    public ThemeObject getThemeState() {
        Gson gson = new Gson();
        String jsonTheme = mPref.getString(Config.THEME_STATE, "");
        if (jsonTheme.length() <= 0) {
            return getDefaultTheme();
        } else {
            return gson.fromJson(jsonTheme, ThemeObject.class);
        }
    }

    @Override
    public List<Country> parseDataCountry() {
        try {
            String jsonLetters = "";
            InputStream inputStream = Application.Context.getAssets().open("countries.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            jsonLetters = new String(buffer, "UTF-8");

            Type listType = new TypeToken<List<Country>>() {
            }.getType();

            return mGson.fromJson(jsonLetters, listType);
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}
