package com.example.dell.currencyconverter.ui.splash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import com.example.dell.currencyconverter.ui.base.MvpView;

public interface SplashMvpView extends MvpView {
    AppCompatActivity getActivity();
    void pushIntent(Intent intent);
}
