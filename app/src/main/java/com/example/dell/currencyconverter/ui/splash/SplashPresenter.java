package com.example.dell.currencyconverter.ui.splash;

import android.content.Intent;

import com.example.dell.currencyconverter.ui.base.BasePresenter;
import com.example.dell.currencyconverter.ui.main.MainActivity;

public class SplashPresenter<V extends SplashMvpView> extends BasePresenter<V> implements SplashMvpPresenter<V> {
    @Override
    public void goToMain() {
        Intent intent = new Intent(getMvpView().getActivity(), MainActivity.class);
        getMvpView().pushIntent(intent);
    }
}
