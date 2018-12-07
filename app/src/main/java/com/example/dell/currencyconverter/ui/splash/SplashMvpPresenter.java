package com.example.dell.currencyconverter.ui.splash;

import com.example.dell.currencyconverter.ui.base.MvpPresenter;

public interface SplashMvpPresenter<V extends SplashMvpView> extends MvpPresenter<V> {
    void goToMain();
}
