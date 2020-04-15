package com.flowz.hackcovid19.pojoClasses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Summary {

    @SerializedName("Global")
    @Expose
    private Global global;

    @SerializedName("Countries")
    @Expose
    private List<Countries> countries = null;

    @SerializedName("Date")
    @Expose
    private String Date;

//    public Summary(Global global, List<Countries> countries, String date) {
//        Global = global;
//        countries = countries;
//        Date = date;
//    }


    public Global getGlobal() {
        return global;
    }

    public void setGlobal(Global global) {
        this.global = global;
    }

    public List<Countries> getCountries() {
        return countries;
    }

    public void setCountries(List<Countries> countries) {
        this.countries = countries;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }
}
