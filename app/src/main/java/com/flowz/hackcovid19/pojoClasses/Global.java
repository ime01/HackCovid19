package com.flowz.hackcovid19.pojoClasses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Global {

    @SerializedName("NewConfirmed")
    @Expose
    private int NewConfirmed;

    @SerializedName("TotalConfirmed")
    @Expose
    private int  TotalConfirmed;

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

    public int getTotalConfirmed() {
        return TotalConfirmed;
    }

    public void setTotalConfirmed(int totalConfirmed) {
        TotalConfirmed = totalConfirmed;
    }

    public int getNewConfirmed() {
        return NewConfirmed;
    }

    public void setNewConfirmed(int newConfirmed) {
        NewConfirmed = newConfirmed;
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
}
