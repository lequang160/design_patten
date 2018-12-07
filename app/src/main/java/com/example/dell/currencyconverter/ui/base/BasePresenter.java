package com.example.dell.currencyconverter.ui.base;


import com.example.dell.currencyconverter.data.AppDataManager;
import com.example.dell.currencyconverter.data.DataManager;

public class BasePresenter<V extends MvpView> implements MvpPresenter<V> {

    private V mMvpView;

    private DataManager mDataManager;

    protected BasePresenter() {
        mDataManager = AppDataManager.getInstance();
    }

    @Override
    public void onAttach(V mvpView) {
        this.mMvpView = mvpView;
    }

    @Override
    public void onDetach() {
        this.mMvpView = null;
    }

    public boolean isViewAttached() {
        return mMvpView != null;
    }

    public V getMvpView() {
        return mMvpView;
    }


    public DataManager getDataManager() {
        return mDataManager;
    }
}
