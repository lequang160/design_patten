package com.example.dell.currencyconverter.ui.main;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import com.example.dell.currencyconverter.ui.base.MvpView;

public interface MainMvpView extends MvpView {


    AppCompatActivity getActivity();

    void pushIntent(Intent intent);

    void setupLayout();

}
