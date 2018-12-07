package com.example.dell.currencyconverter.ui.options;

import android.content.Intent;

import com.example.dell.currencyconverter.R;
import com.example.dell.currencyconverter.data.model.OptionModel;
import com.example.dell.currencyconverter.ui.base.BasePresenter;
import com.example.dell.currencyconverter.ui.main.MainMvpPresenter;
import com.example.dell.currencyconverter.ui.them.ThemesActivity;

import java.security.cert.PKIXRevocationChecker;
import java.util.ArrayList;
import java.util.List;

public class OptionPresenter<V extends OptionMvpView> extends BasePresenter<V> implements OptionMvpPresenter<V> {
    @Override
    public List<OptionModel> getBaseData() {
        List<OptionModel> list = new ArrayList<>();
        list.add(new OptionModel("Themes", R.drawable.ic_goto));
        list.add(new OptionModel("About", R.drawable.ic_goto));
        return list;
    }

    @Override
    public void goTheme() {
        Intent intent = new Intent(getMvpView().getActivity(), ThemesActivity.class);

        getMvpView().getActivity().startActivity(intent);
    }
}
