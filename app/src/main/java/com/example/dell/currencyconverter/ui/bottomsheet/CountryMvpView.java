package com.example.dell.currencyconverter.ui.bottomsheet;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import com.example.dell.currencyconverter.ui.base.MvpView;

public interface CountryMvpView extends MvpView {


    AppCompatActivity getActivity();

    void pushIntent(Intent intent);

    void setupLayout();

}
