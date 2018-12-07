package com.example.dell.currencyconverter.ui.bottomsheet;

import android.content.Intent;

import com.example.dell.currencyconverter.data.AppDataManager;
import com.example.dell.currencyconverter.data.model.Country;
import com.example.dell.currencyconverter.ui.base.BasePresenter;
import com.example.dell.currencyconverter.ui.options.OptionActivity;

import java.util.List;


public class CountryPresenter<V extends CountryMvpView> extends BasePresenter<V> implements CountryMvpPresenter<V> {

    @Override
    public List<Country> getDataCountry() {
        return AppDataManager.getInstance().parseDataCountry();
    }
}
