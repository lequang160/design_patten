package com.example.dell.currencyconverter.ui.splash;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;

import com.example.dell.currencyconverter.R;
import com.example.dell.currencyconverter.data.model.theme.ThemeObject;
import com.example.dell.currencyconverter.data.model.theme.observer.IObserverTheme;
import com.example.dell.currencyconverter.data.model.theme.observer.ThemeState;
import com.example.dell.currencyconverter.ui.base.BaseActivity;

import butterknife.BindView;

public class SplashActivity extends BaseActivity implements SplashMvpView, IObserverTheme {
    @BindView(R.id.content)
    ConstraintLayout contentLayout;

    SplashMvpPresenter<SplashMvpView> mPresenter;
    @Override
    protected int getContentView() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initViews() {

        ThemeState.getInstance().onAttach(this);
        ThemeState.getInstance().onNotify();

        mPresenter = new SplashPresenter<>();
        mPresenter.onAttach(this);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();

                mPresenter.goToMain();
            }
        },3000);
    }

    @Override
    public void updateTheme(ThemeObject themeState) {
        contentLayout.setBackgroundColor(Color.parseColor(themeState.getColor()));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ThemeState.getInstance().onDetach(this);
    }
}
