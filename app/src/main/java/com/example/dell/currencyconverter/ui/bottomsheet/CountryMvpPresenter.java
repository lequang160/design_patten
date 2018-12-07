package com.example.dell.currencyconverter.ui.bottomsheet;


import com.example.dell.currencyconverter.data.model.Country;
import com.example.dell.currencyconverter.ui.base.MvpPresenter;

import java.util.List;

public interface CountryMvpPresenter<V extends CountryMvpView> extends MvpPresenter<V> {
    List<Country> getDataCountry();
}
