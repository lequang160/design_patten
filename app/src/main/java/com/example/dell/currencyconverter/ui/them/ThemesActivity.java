package com.example.dell.currencyconverter.ui.them;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.dell.currencyconverter.R;
import com.example.dell.currencyconverter.data.model.theme.ThemeObject;
import com.example.dell.currencyconverter.data.model.theme.observer.ThemeState;
import com.example.dell.currencyconverter.ui.adapters.ThemeAdapter;
import com.example.dell.currencyconverter.ui.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class ThemesActivity extends BaseActivity implements ThemeMvpView {

    ThemeMvpPresenter<ThemeMvpView> mPresenter;

    List<ThemeObject> mData = new ArrayList<>();
    ThemeAdapter mAdapter;

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    @BindView(R.id.text_title)
    TextView mTitle;

    @OnClick(R.id.image_back)
    public void goBack() {
        finish();
    }


    @Override
    protected int getContentView() {
        return R.layout.activity_themes;
    }

    @Override
    protected void initViews() {
        mTitle.setText(getResources().getText(R.string.themes));
        initRV();
    }
    private void initRV()
    {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        RecyclerView.ItemDecoration mDividerItemDecoration = new DividerItemDecoration(mRecyclerView.getContext(),
                ((LinearLayoutManager) layoutManager).getOrientation());
        mRecyclerView.addItemDecoration(mDividerItemDecoration);
        mRecyclerView.setLayoutManager(layoutManager);
        mAdapter = new ThemeAdapter(mData);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void initControls() {
        mPresenter = new ThemePresenter<>();
        mPresenter.onAttach(this);
        mAdapter.addData(mPresenter.getDataTheme());
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ThemeState.getInstance().setThemeState((ThemeObject) adapter.getData().get(position));
                ThemeState.getInstance().onNotify();
                Toast.makeText(ThemesActivity.this, "Theme changed.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
