package com.example.dell.currencyconverter.data.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Country {
    private boolean isCheck = false;

    @SerializedName("ctry_cd")
    @Expose
    private String ctryCd;
    @SerializedName("ctry_kr")
    @Expose
    private String ctryKr;
    @SerializedName("ctry_en")
    @Expose
    private String ctryEn;
    @SerializedName("curr_cd")
    @Expose
    private String currCd;
    @SerializedName("curr_name")
    @Expose
    private String currName;
    @SerializedName("ap_ican")
    @Expose
    private String apIcan;
    @SerializedName("ap_ct_kr")
    @Expose
    private String apCtKr;
    @SerializedName("ap_kr")
    @Expose
    private String apKr;

    @SerializedName("rate")
    @Expose
    private Double rate;

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public boolean isCheck() {
        return isCheck;
    }

    public void setCheck(boolean check) {
        isCheck = check;
    }

    public String getCtryCd() {
        return ctryCd;
    }

    public void setCtryCd(String ctryCd) {
        this.ctryCd = ctryCd;
    }

    public String getCtryKr() {
        return ctryKr;
    }

    public void setCtryKr(String ctryKr) {
        this.ctryKr = ctryKr;
    }

    public String getCtryEn() {
        return ctryEn;
    }

    public void setCtryEn(String ctryEn) {
        this.ctryEn = ctryEn;
    }

    public String getCurrCd() {
        return currCd;
    }

    public void setCurrCd(String currCd) {
        this.currCd = currCd;
    }

    public String getCurrName() {
        return currName;
    }

    public void setCurrName(String currName) {
        this.currName = currName;
    }

    public String getApIcan() {
        return apIcan;
    }

    public void setApIcan(String apIcan) {
        this.apIcan = apIcan;
    }

    public String getApCtKr() {
        return apCtKr;
    }

    public void setApCtKr(String apCtKr) {
        this.apCtKr = apCtKr;
    }

    public String getApKr() {
        return apKr;
    }

    public void setApKr(String apKr) {
        this.apKr = apKr;
    }
}