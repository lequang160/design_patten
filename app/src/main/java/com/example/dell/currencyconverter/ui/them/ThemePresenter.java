package com.example.dell.currencyconverter.ui.them;

import com.example.dell.currencyconverter.data.AppDataManager;
import com.example.dell.currencyconverter.data.DataManager;
import com.example.dell.currencyconverter.data.model.theme.ThemeObject;
import com.example.dell.currencyconverter.ui.base.BasePresenter;

import java.util.List;

public class ThemePresenter<V extends ThemeMvpView> extends BasePresenter<V> implements ThemeMvpPresenter<V> {

    DataManager mDataManager;

    public ThemePresenter() {
        mDataManager = AppDataManager.getInstance();
    }

    @Override
    public List<ThemeObject> getDataTheme() {
        return mDataManager.parseDataTheme();
    }

    @Override
    public void saveTheme(ThemeObject themeObject) {
        mDataManager.saveThemeState(themeObject);
    }
}
