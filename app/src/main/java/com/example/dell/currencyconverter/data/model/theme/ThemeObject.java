package com.example.dell.currencyconverter.data.model.theme;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ThemeObject {

    @SerializedName("nameColor")
    @Expose
    private String nameColor;
    @SerializedName("color")
    @Expose
    private String color;

    public String getNameColor() {
        return nameColor;
    }

    public void setNameColor(String nameColor) {
        this.nameColor = nameColor;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
