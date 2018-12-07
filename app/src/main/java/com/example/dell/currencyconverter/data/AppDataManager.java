package com.example.dell.currencyconverter.data;

import com.example.dell.currencyconverter.Application;
import com.example.dell.currencyconverter.data.model.Country;
import com.example.dell.currencyconverter.data.model.theme.ThemeObject;
import com.example.dell.currencyconverter.data.prefs.AppPreferencesHelper;
import com.example.dell.currencyconverter.data.prefs.PreferencesHelper;

import java.util.List;

public class AppDataManager implements DataManager {


    private static volatile AppDataManager Instance = null;
    private PreferencesHelper mPreferencesHelper;

    private AppDataManager() {
        mPreferencesHelper = new AppPreferencesHelper(Application.Context);
    }

    public static AppDataManager getInstance() {
        AppDataManager localInstance = Instance;
        if (localInstance == null) {
            synchronized (AppDataManager.class) {
                localInstance = Instance;
                if (localInstance == null) {
                    Instance = localInstance = new AppDataManager();
                }
            }
        }
        return localInstance;
    }


    @Override
    public List<ThemeObject> parseDataTheme() {
        return mPreferencesHelper.parseDataTheme();
    }

    @Override
    public ThemeObject getDefaultTheme() {
        return mPreferencesHelper.getDefaultTheme();
    }

    @Override
    public void saveThemeState(ThemeObject themeObject) {
        mPreferencesHelper.saveThemeState(themeObject);
    }

    @Override
    public ThemeObject getThemeState() {
        return mPreferencesHelper.getThemeState();
    }

    @Override
    public List<Country> parseDataCountry() {
        return mPreferencesHelper.parseDataCountry();
    }
}
