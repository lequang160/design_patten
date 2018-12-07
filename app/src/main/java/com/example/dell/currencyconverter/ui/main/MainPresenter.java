package com.example.dell.currencyconverter.ui.main;

import android.content.Intent;

import com.example.dell.currencyconverter.data.AppDataManager;
import com.example.dell.currencyconverter.data.model.Country;
import com.example.dell.currencyconverter.ui.base.BasePresenter;
import com.example.dell.currencyconverter.ui.bottomsheet.CountryActivity;
import com.example.dell.currencyconverter.ui.options.OptionActivity;
import com.example.dell.currencyconverter.utils.Config;

import java.util.List;


public class MainPresenter<V extends MainMvpView> extends BasePresenter<V> implements MainMvpPresenter<V> {



    @Override
    public void goToOption() {
        Intent intent = new Intent(getMvpView().getActivity(), OptionActivity.class);
        getMvpView().getActivity().startActivity(intent);
    }

    @Override
    public void goToAllCountry(String currency , int type) {
       Intent intent = new Intent(getMvpView().getActivity(), CountryActivity.class);
       intent.putExtra(Config.CURRENCY, currency);
       intent.putExtra(Config.TYPE, type);
       getMvpView().getActivity().startActivityForResult(intent,type);
    }

    @Override
    public List<Country> getDataCountry() {
        return AppDataManager.getInstance().parseDataCountry();
    }

}
