package com.flowz.hackcovid19.PojoClasses;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Summary {

    @SerializedName("Global")
    private Global global;

    @SerializedName("Countries")
    private List<com.flowz.hackcovid19.PojoClasses.Countries> Countries;

    @SerializedName("Date")
    private String Date;

//    public Summary(String global, List<com.flowz.hackcovid19.PojoClasses.Countries> countries, String date) {
//        Global = global;
//        Countries = countries;
//        Date = date;
//    }


    public Global getGlobal() {
        return global;
    }

    public void setGlobal(Global global) {
        this.global = global;
    }

    public List<com.flowz.hackcovid19.PojoClasses.Countries> getCountries() {
        return Countries;
    }

    public void setCountries(List<com.flowz.hackcovid19.PojoClasses.Countries> countries) {
        Countries = countries;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }
}
