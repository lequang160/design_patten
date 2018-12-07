package com.example.dell.currencyconverter.ui.adapters;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.Nullable;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.dell.currencyconverter.Application;
import com.example.dell.currencyconverter.R;
import com.example.dell.currencyconverter.data.model.theme.ThemeObject;

import java.util.List;

public class ThemeAdapter extends BaseQuickAdapter<ThemeObject, BaseViewHolder> {
    public ThemeAdapter(@Nullable List<ThemeObject> data) {
        super(R.layout.item_theme, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ThemeObject item) {
        helper.setText(R.id.text_title,item.getNameColor());
        addShape(helper.getView(R.id.view_color),item.getColor());
    }

    private void addShape(View view, String color)
    {
        int roundRadius = Application.Context.getResources().getDimensionPixelOffset(R.dimen._12sdp);
        int fillColor = Color.parseColor(color);

        GradientDrawable gd = new GradientDrawable();
        gd.setColor(fillColor);
        gd.setCornerRadius(roundRadius);
        view.setBackground(gd);
    }
    /*int strokeWidth = 5; // 5px not dp
        int roundRadius = 15; // 15px not dp
        int strokeColor = Color.parseColor("#2E3135");
        int fillColor = Color.parseColor("#DFDFE0");

        GradientDrawable gd = new GradientDrawable();
        gd.setColor(fillColor);
        gd.setCornerRadius(roundRadius);
        gd.setStroke(strokeWidth, strokeColor);*/
}
