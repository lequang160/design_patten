package com.example.dell.currencyconverter.ui.adapters;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.dell.currencyconverter.R;
import com.example.dell.currencyconverter.data.model.OptionModel;

import java.util.List;

public class OptionAdapter extends BaseQuickAdapter<OptionModel,BaseViewHolder> {
    public OptionAdapter(@Nullable List<OptionModel> data) {
        super(R.layout.item_option, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, OptionModel item) {
        helper.setText(R.id.text_title, item.getTitle());
        helper.setImageResource(R.id.image,item.getImage());
    }
}
