package com.example.dell.currencyconverter.ui.bottomsheet;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.dell.currencyconverter.R;
import com.example.dell.currencyconverter.data.model.Country;
import com.example.dell.currencyconverter.ui.adapters.CountryAdapter;
import com.example.dell.currencyconverter.ui.base.BaseActivity;
import com.example.dell.currencyconverter.utils.Config;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class CountryActivity extends BaseActivity implements CountryMvpView {

    private CountryMvpPresenter<CountryMvpView> mPresenter;
    private CountryAdapter mAdapter;
    private List<Country> mData = new ArrayList<>();
    private List<Country> mDataTemp = new ArrayList<>();
    private static int positionCheck = 0;
    private static String country;
    private int type;

    @BindView(R.id.container)
    ConstraintLayout container;

    @BindView(R.id.text_title)
    TextView mTitle;

    @BindView(R.id.searchView)
    SearchView mSearchView;

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    @Override
    protected int getContentView() {
        return R.layout.activity_country;
    }

    @Override
    protected void initViews() {
        mPresenter = new CountryPresenter<>();
        mPresenter.onAttach(this);

        initRV();

        if (getIntent() != null) {
            country = getIntent().getStringExtra(Config.CURRENCY);
            type = getIntent().getIntExtra(Config.TYPE, Config.TYPE_BASE);
        }
    }

    @Override
    public void setupLayout() {
        if(type == Config.TYPE_BASE) {
            mTitle.setText(getResources().getText(R.string.base_currency));
        }else
        {
            mTitle.setText(getResources().getText(R.string.quote_currency));
        }
        getPosition();
        mDataTemp.get(positionCheck).setCheck(true);
    }

    @Override
    protected void initControls() {
        mData.addAll(mPresenter.getDataCountry());
        mDataTemp.addAll(mData);


        mSearchView.setQueryHint("Search");
        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                setDataRV(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                setDataRV(s);
                return false;
            }
        });


        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                mDataTemp.get(positionCheck).setCheck(false);
                mAdapter.notifyItemChanged(positionCheck);
                mDataTemp.get(position).setCheck(true);
                mAdapter.notifyItemChanged(position);
                positionCheck = position;
                goBack();
            }
        });

        // hide keyboard
        container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideKeyboard();
            }
        });

        // hide keyboard
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                hideKeyboard();
            }
        });

        setupLayout();
    }



    private void initRV() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        RecyclerView.ItemDecoration mDividerItemDecoration = new DividerItemDecoration(mRecyclerView.getContext(),
                ((LinearLayoutManager) layoutManager).getOrientation());
        mRecyclerView.addItemDecoration(mDividerItemDecoration);
        mRecyclerView.setLayoutManager(layoutManager);
        mAdapter = new CountryAdapter(mDataTemp);
        mRecyclerView.setAdapter(mAdapter);
    }

    @OnClick(R.id.image_back)
    public void goBack() {
        Intent intent = new Intent();
        intent.putExtra(Config.DATA_RESULT, mDataTemp.get(positionCheck).getCurrCd());
        intent.putExtra(Config.TYPE, mDataTemp.get(positionCheck).getRate());
        setResult(RESULT_OK, intent);
        finish();
    }

    private void setDataRV(String query) {
        mDataTemp.clear();
        for (Country country : mData) {
            if (country.getCurrCd().toLowerCase().contains(query.toLowerCase())) {
                mDataTemp.add(country);
            }
        }
        mAdapter.notifyDataSetChanged();
    }
    private void getPosition()
    {
        for(int i =0; i < mDataTemp.size(); i++)
        {
            if(mDataTemp.get(i).getCurrCd().equals(country))
            {
               mDataTemp.get(i).setCheck(true);
            }
        }
    }
}
