package com.example.dell.currencyconverter.ui.them;

import com.example.dell.currencyconverter.data.model.theme.ThemeObject;
import com.example.dell.currencyconverter.ui.base.MvpPresenter;

import java.util.List;

public interface ThemeMvpPresenter<V extends ThemeMvpView> extends MvpPresenter<V> {
    List<ThemeObject> getDataTheme();
    void saveTheme(ThemeObject themeObject);
}
