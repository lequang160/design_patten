package com.example.dell.currencyconverter.ui.options;

import com.example.dell.currencyconverter.data.model.OptionModel;
import com.example.dell.currencyconverter.ui.base.MvpPresenter;
import com.example.dell.currencyconverter.ui.main.MainMvpView;

import java.util.List;

public interface OptionMvpPresenter<V extends OptionMvpView> extends MvpPresenter<V> {
    List<OptionModel> getBaseData();
    void goTheme();
}
