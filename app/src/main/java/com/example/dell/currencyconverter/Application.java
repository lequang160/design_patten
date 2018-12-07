package com.example.dell.currencyconverter;

import com.example.dell.currencyconverter.data.AppDataManager;
import com.example.dell.currencyconverter.data.model.theme.observer.ThemeState;

public class Application extends android.app.Application {

    public static android.content.Context Context;
    ThemeState themeState;
    AppDataManager dataManager;

    @Override
    public void onCreate() {
        super.onCreate();

        Context = this;

        themeState = ThemeState.getInstance();
        dataManager = AppDataManager.getInstance();
        if(themeState.getThemeState() == null)
        {
            themeState.setThemeState(dataManager.getThemeState());
        }
    }
}
