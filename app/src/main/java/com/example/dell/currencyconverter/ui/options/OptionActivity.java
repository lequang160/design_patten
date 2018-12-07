package com.example.dell.currencyconverter.ui.options;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.dell.currencyconverter.R;
import com.example.dell.currencyconverter.data.model.OptionModel;
import com.example.dell.currencyconverter.ui.adapters.OptionAdapter;
import com.example.dell.currencyconverter.ui.adapters.ThemeAdapter;
import com.example.dell.currencyconverter.ui.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class OptionActivity extends BaseActivity implements OptionMvpView {

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    @BindView(R.id.text_title)
    TextView mTitle;

    @OnClick(R.id.image_back)
    public void goBack() {
        finish();
    }
    List<OptionModel> mData = new ArrayList<>();
    OptionAdapter mAdapter;
    OptionMvpPresenter<OptionMvpView> mPresenter;

    @Override
    protected int getContentView() {
        return R.layout.activity_option;
    }

    @Override
    protected void initViews() {
        mTitle.setText(getResources().getText(R.string.themes));
        mPresenter = new OptionPresenter<>();
        mPresenter.onAttach(this);
        mData.addAll(mPresenter.getBaseData());
        initRV();
        mTitle.setText(R.string.option);
    }
    private void initRV()
    {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        RecyclerView.ItemDecoration mDividerItemDecoration = new DividerItemDecoration(mRecyclerView.getContext(),
                ((LinearLayoutManager) layoutManager).getOrientation());
        mRecyclerView.addItemDecoration(mDividerItemDecoration);
        mRecyclerView.setLayoutManager(layoutManager);
        mAdapter = new OptionAdapter(mData);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void initControls() {
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                switch (position){
                    case 0:
                        mPresenter.goTheme();
                        break;
                    case 1:
                        break;
                }
            }
        });
    }
}
