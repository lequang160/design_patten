package com.example.dell.currencyconverter.ui.main;


import com.example.dell.currencyconverter.data.model.Country;
import com.example.dell.currencyconverter.ui.base.MvpPresenter;

import java.util.List;

public interface MainMvpPresenter<V extends MainMvpView> extends MvpPresenter<V> {

    void goToOption();

    void goToAllCountry(String currency, int type);

    List<Country> getDataCountry();
}
