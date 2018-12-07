package com.example.dell.currencyconverter.data.prefs;

import com.example.dell.currencyconverter.data.model.Country;
import com.example.dell.currencyconverter.data.model.theme.ThemeObject;

import java.util.List;

public interface PreferencesHelper {

    List<ThemeObject> parseDataTheme();
    ThemeObject getDefaultTheme();
    void saveThemeState(ThemeObject themeObject);
    ThemeObject getThemeState();

    List<Country> parseDataCountry();
}
