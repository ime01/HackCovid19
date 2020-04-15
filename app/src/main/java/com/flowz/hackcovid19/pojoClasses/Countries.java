package com.flowz.hackcovid19.pojoClasses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Countries {

    @SerializedName("Country")
    @Expose
    private String Country;

    @SerializedName("CountryCode")
    @Expose
    private String CountryCode;

    @SerializedName("Slug")
    @Expose
    private String Slug;

    @SerializedName("NewConfirmed")
    @Expose
    private int NewConfirmed;

    @SerializedName("TotalConfirmed")
    @Expose
    private int TotalConfirmed;

    @SerializedName("NewDeaths")
    @Expose
    private int  NewDeaths;

    @SerializedName("TotalDeaths")
    @Expose
    private int  TotalDeaths;

    @SerializedName("NewRecovered")
    @Expose
    private int  NewRecovered;

    @SerializedName("TotalRecovered")
    @Expose
    private int  TotalRecovered;

    @SerializedName("Date")
    @Expose
    private String Date;

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getCountryCode() {
        return CountryCode;
    }

    public void setCountryCode(String countryCode) {
        CountryCode = countryCode;
    }

    public String getSlug() {
        return Slug;
    }

    public void setSlug(String slug) {
        Slug = slug;
    }

    public int getNewConfirmed() {
        return NewConfirmed;
    }

    public void setNewConfirmed(int newConfirmed) {
        NewConfirmed = newConfirmed;
    }

    public int getTotalConfirmed() {
        return TotalConfirmed;
    }

    public void setTotalConfirmed(int totalConfirmed) {
        TotalConfirmed = totalConfirmed;
    }

    public int getNewDeaths() {
        return NewDeaths;
    }

    public void setNewDeaths(int newDeaths) {
        NewDeaths = newDeaths;
    }

    public int getTotalDeaths() {
        return TotalDeaths;
    }

    public void setTotalDeaths(int totalDeaths) {
        TotalDeaths = totalDeaths;
    }

    public int getNewRecovered() {
        return NewRecovered;
    }

    public void setNewRecovered(int newRecovered) {
        NewRecovered = newRecovered;
    }

    public int getTotalRecovered() {
        return TotalRecovered;
    }

    public void setTotalRecovered(int totalRecovered) {
        TotalRecovered = totalRecovered;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }
}
