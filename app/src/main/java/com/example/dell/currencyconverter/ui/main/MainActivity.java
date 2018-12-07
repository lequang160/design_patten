package com.example.dell.currencyconverter.ui.main;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.dell.currencyconverter.R;
import com.example.dell.currencyconverter.data.model.Country;
import com.example.dell.currencyconverter.data.model.theme.ThemeObject;
import com.example.dell.currencyconverter.data.model.theme.observer.IObserverTheme;
import com.example.dell.currencyconverter.data.model.theme.observer.ThemeState;
import com.example.dell.currencyconverter.ui.base.BaseActivity;
import com.example.dell.currencyconverter.utils.Config;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements MainMvpView, IObserverTheme {

    private static String baseCurrency = "EUR";
    private static String quote = "USD";

    private static double rateCurrency = 0;
    private static double rateQuote = 0;

    @BindView(R.id.content)
    ConstraintLayout contentLayout;

    @BindView(R.id.image_background)
    ConstraintLayout imageBackground;

    @BindView(R.id.base_currency)
    Button buttonBaseCurrency;

    @BindView(R.id.quote)
    Button buttonQuote;

    @BindView(R.id.text_currency)
    TextView textCurrency;

    @BindView(R.id.text_quote)
    TextView textQuote;

    @BindView(R.id.edit_base_curency)
    EditText editBaseCurrency;

    @BindView(R.id.edit_quoste)
    EditText editQuote;

    @BindView(R.id.number_currency)
    TextView numberCurrency;

    @BindView(R.id.number_quote)
    TextView numberQuote;


    @OnClick(R.id.base_currency)
    public void showAllContry() {
        mPresenter.goToAllCountry(baseCurrency, Config.TYPE_BASE);
        Log.d("DATA", mPresenter.getDataCountry().size() + "");
    }

    @OnClick(R.id.quote)
    public void showAllContryQuote() {
        mPresenter.goToAllCountry(quote, Config.TYPE_QUOTE);
        Log.d("DATA", mPresenter.getDataCountry().size() + "");
    }


    @OnClick(R.id.setting)
    public void goToOption() {
        mPresenter.goToOption();
    }

    private MainMvpPresenter<MainMvpView> mPresenter;

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews() {
        mPresenter = new MainPresenter<>();
        mPresenter.onAttach(this);

        ThemeState.getInstance().onAttach(this);
        ThemeState.getInstance().onNotify();
        setupLayout();
        getRate();
        initTextConversions();
    }

    @Override
    protected void initControls() {
        super.initControls();
        editBaseCurrency.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    setQuote(editBaseCurrency.getText().toString());
                }else{
                    setQuote("0");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void setQuote(String s) {
        if(s.length() > 0) {
            double value = Double.valueOf(s);
            value = value * (rateQuote / rateCurrency);

            DecimalFormat formatter = new DecimalFormat("#0.00");
            editQuote.setText(String.valueOf(formatter.format(value)));
        }else
        {
            editQuote.setText("0");
        }
    }

    private void getRate() {
        List<Country> list = mPresenter.getDataCountry();

        for (Country country : list) {
            if (country.getCurrCd().equals(baseCurrency)) {
                rateCurrency = country.getRate();
            }
            if (country.getCurrCd().equals(quote)) {
                rateQuote = country.getRate();
            }
        }
        list.clear();
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

    @Override
    public void setupLayout() {
        imageBackground.post(new Runnable() {
            @Override
            public void run() {
                int width = imageBackground.getMeasuredWidth();
                ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) imageBackground.getLayoutParams();
                layoutParams.height = width;

                imageBackground.setLayoutParams(layoutParams);
            }
        });

        buttonBaseCurrency.setText(baseCurrency);
        buttonQuote.setText(quote);

        contentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideKeyboard();
            }
        });

        textCurrency.setText(baseCurrency);
        textQuote.setText(quote);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == Config.TYPE_BASE) {
            if (resultCode == Activity.RESULT_OK) {
                String result = data.getStringExtra(Config.DATA_RESULT);
                buttonBaseCurrency.setText(result);
                baseCurrency = result;
                rateCurrency = data.getDoubleExtra(Config.TYPE,0);
                textCurrency.setText(baseCurrency);
                setQuote(editBaseCurrency.getText().toString());
                initTextConversions();
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
            }
        } else {
            String result = data.getStringExtra(Config.DATA_RESULT);
            buttonQuote.setText(result);
            quote = result;
            textQuote.setText(quote);
            rateQuote = data.getDoubleExtra(Config.TYPE,0);
            setQuote(editBaseCurrency.getText().toString());
            initTextConversions();
        }
    }

    private void initTextConversions()
    {
        numberCurrency.setText("1");
        DecimalFormat formatter = new DecimalFormat("#0.00");
        numberQuote.setText(String.valueOf(formatter.format(rateQuote/rateCurrency)));
    }
}
