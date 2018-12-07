package com.example.dell.currencyconverter.data.model.theme.observer;

import com.example.dell.currencyconverter.data.AppDataManager;
import com.example.dell.currencyconverter.data.model.theme.ThemeObject;

import java.util.ArrayList;
import java.util.List;

public class ThemeState {
    private static ThemeState Instance;
    private ThemeObject themeState;
    private List<IObserverTheme> observerThemeList = new ArrayList<>();

    private ThemeState() {
    }

    public static ThemeState getInstance() {
        if (Instance == null) {
            return Instance = new ThemeState();
        } else {
            return Instance;
        }
    }

    public ThemeObject getThemeState() {
        return themeState;
    }

    public void setThemeState(ThemeObject themeState) {
        this.themeState = themeState;
        AppDataManager.getInstance().saveThemeState(themeState);
    }

    public void onAttach(IObserverTheme iObserverTheme) {
        if (iObserverTheme != null) {
            observerThemeList.add(iObserverTheme);
        }
    }

    public void onDetach(IObserverTheme iObserverTheme) {
        observerThemeList.remove(iObserverTheme);
    }

    public void onNotify() {
        for (IObserverTheme iObserverTheme : observerThemeList) {
            iObserverTheme.updateTheme(themeState);
        }
    }

}
