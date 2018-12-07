package com.example.dell.currencyconverter.ui.adapters;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.dell.currencyconverter.Application;
import com.example.dell.currencyconverter.R;
import com.example.dell.currencyconverter.data.model.Country;
import com.example.dell.currencyconverter.data.model.theme.observer.ThemeState;

import java.util.List;

public class CountryAdapter extends BaseQuickAdapter<Country, BaseViewHolder> {
    public CountryAdapter(@Nullable List<Country> data) {
        super(R.layout.item_country, data);
    }


    @Override
    protected void convert(BaseViewHolder helper, Country item) {
        helper.setText(R.id.text_title, item.getCurrCd());

        int size = Application.Context.getResources().getDimensionPixelOffset(R.dimen._25sdp);
        int mipmapResourceId = mContext.getResources().getIdentifier(item.getCtryCd(), "mipmap", mContext.getPackageName());
        Glide.with(mContext).asBitmap().load(mipmapResourceId).apply(new RequestOptions().override(size, size)).into((ImageView) helper.getView(R.id.image_flag));
        View view = helper.getView(R.id.check);
        if (item.isCheck()) {
            view.setVisibility(View.VISIBLE);
            setRadiusView(view);
        } else {
            view.setVisibility(View.INVISIBLE);
        }
    }

    private void setRadiusView(View view) {
        int roundRadius = Application.Context.getResources().getDimensionPixelOffset(R.dimen._12sdp);
        int fillColor = Color.parseColor(ThemeState.getInstance().getThemeState().getColor());
        GradientDrawable gd = new GradientDrawable();
        gd.setColor(fillColor);
        gd.setCornerRadius(roundRadius);
        view.setBackground(gd);
    }
}
