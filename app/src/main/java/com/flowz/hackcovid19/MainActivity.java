package com.flowz.hackcovid19;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.flowz.hackcovid19.adapter.CountryAdapter;
import com.flowz.hackcovid19.network.ApiClient;
import com.flowz.hackcovid19.network.ApiInterface;
import com.flowz.hackcovid19.pojoClasses.Countries;
import com.flowz.hackcovid19.pojoClasses.Summary;

import java.util.List;

import static androidx.recyclerview.widget.LinearLayoutManager.*;

public class MainActivity extends AppCompatActivity {
    Countries couDetail;

    RecyclerView rcyCountry;

    TextView newConfirmed, newDeaths, newRecovered, totalConfirmed, totalDeaths, totalRecovered, globalupdate, countrydetails;
    private Object Context;
    ProgressBar progressBar;
    CardView cardView;
    ImageView rightArrow, leftArrow;
    Spinner spinner;
    public  int p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity1_main);

        rcyCountry = findViewById(R.id.ryc_country);
        globalupdate = findViewById(R.id.global_update);
        countrydetails = findViewById(R.id.country_details);
        cardView = findViewById(R.id.cardView);
        rcyCountry.setVisibility(View.INVISIBLE);
        globalupdate.setVisibility(View.INVISIBLE);
        countrydetails.setVisibility(View.INVISIBLE);
        cardView.setVisibility(View.INVISIBLE);

        // rcyCountry.setLayoutManager(new LinearLayoutManager(this));
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        rcyCountry.setLayoutManager(layoutManager);
        //rcyCountry.setLayoutManager(new LinearLayoutManager(this, HORIZONTAL, false));

        spinner = findViewById(R.id.spinner);
        progressBar = findViewById(R.id.progressBar2);
        newConfirmed = findViewById(R.id.newConfirmedNum);
        newDeaths = findViewById(R.id.newDeathsNum);
        newRecovered = findViewById(R.id.newRecoveredNum);
        totalConfirmed = findViewById(R.id.totalConfirmedNum);
        totalDeaths = findViewById(R.id.totalDeathsNum);
        totalRecovered = findViewById(R.id.totalRecoveredNum);
        rightArrow = findViewById(R.id.swipe_right);
        leftArrow = findViewById(R.id.swipe_left);

        getDataforCountryCode("CountryCode");

        callNCDCbyState();

        leftArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p = layoutManager.findFirstVisibleItemPosition() - 1;
                rcyCountry.smoothScrollToPosition( p);
                checkVisibility();
            }
        });


        rightArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p = layoutManager.findLastVisibleItemPosition() + 1;
                rcyCountry.smoothScrollToPosition(p);
                checkVisibility();
            }
        });
    }

    private void callNCDCbyState() {
        int [] ncdcNumbersByState = {};
    }

    public void checkVisibility() {
        if (p < 1) {
            leftArrow.setVisibility(View.GONE);
            rightArrow.setVisibility(View.VISIBLE);
        } else if (p >= (rcyCountry.getAdapter().getItemCount() - 1)) {
            leftArrow.setVisibility(View.VISIBLE);
            rightArrow.setVisibility(View.GONE);
        } else {
            rightArrow.setVisibility(View.VISIBLE);
            leftArrow.setVisibility(View.VISIBLE);
        }
    }
    public void getDataforCountryCode (final String CountryCode){
        ApiInterface retrofitInterface = ApiClient.getApiClent().create(ApiInterface.class);


        Call<Summary> summaryCall = retrofitInterface.getSummary();

        summaryCall.enqueue(new Callback<Summary>() {
            @Override
            public void onResponse(Call<Summary> call, Response<Summary> response) {
                if (response.body() != null){


                    Summary fetchedCovidData = response.body();
//
                    int data = fetchedCovidData.getGlobal().getNewConfirmed();

                    int data1 = fetchedCovidData.getGlobal().getNewDeaths();

                    int data2 = fetchedCovidData.getGlobal().getNewRecovered();

                    int data5 = fetchedCovidData.getGlobal().getTotalConfirmed();

                    int data3 = fetchedCovidData.getGlobal().getTotalDeaths();

                    int data4 = fetchedCovidData.getGlobal().getTotalRecovered();

                    String nC = String.valueOf(data);
                    String nD = String.valueOf(data1);
                    String nR = String.valueOf(data2);
                    String tC = String.valueOf(data5);
                    String tD = String.valueOf(data3);
                    String tR = String.valueOf(data4);

                    newConfirmed.setText(nC);
                    newDeaths.setText(nD);
                    newRecovered.setText(nR);
                    totalConfirmed.setText(tC);
                    totalDeaths.setText(tD);
                    totalRecovered.setText(tR);


                    List<Countries> country = fetchedCovidData.getCountries();

                    loadCountriesRecycler(country);


//                    String data1 = country.get(20).getCountry();
//                    String data2 = country.get(20).getCountryCode();
//                    String data3 = country.get(20).getSlug();
//                    String data4 = String.valueOf(country.get(20).getNewConfirmed());
//                    String data5 = String.valueOf(country.get(20).getNewDeaths());
//                    String data6 = String.valueOf(country.get(20).getTotalDeaths());
//                    String data7 = String.valueOf(country.get(20).getNewRecovered());
//                    String data8 = String.valueOf(country.get(20).getTotalRecovered());
//                    String data9 = country.get(20).getDate();

//                    text1.append("\n Country :" + data1 +
//                                 "\n CountryCode :" + data2
//                                 +"\n Slug :" + data3
//                                 +"\n NewConfirmed :" + data4
//                                 +"\n NewDeaths :" + data5
//                                 +"\n TotalDeaths :" + data6 +
//                                 "\n NewRecovered :" + data7
//                                 +"\n TotalRecovered :" + data8
//                                 +"\n Date :" + data9
//                    );

//                    for (Countries c : country){
//
//                        if (c.getCountryCode().equals(CountryCode))
//
//                            couDetail = c;
//
//                        runOnUiThread(new Runnable() {
//                            @Override
//                            public void run() {
//                                text1.append(couDetail.getCountryCode());
//                            }
//                        });
//                    }


                    //String data = response.body().getCountries().toString();


//                    for (Countries countries1: country) {
//
//                         String dataContent = "";
//
//                        dataContent += "Countries" + countries1.getCountryCode() ;
//                        text1.append(dataContent);
//
//                    }
                } else{
                    Toast.makeText(MainActivity.this, "No Result", Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(Call<Summary> call, Throwable t) {

                Toast.makeText(MainActivity.this, "Network Call Failure, try again", Toast.LENGTH_LONG).show();
            }
        });

    }
    private void loadCountriesRecycler(List<Countries> country) {
        CountryAdapter countryAdapter = new CountryAdapter(country, this);
        rcyCountry.setAdapter(countryAdapter);
        progressBar.setVisibility(View.GONE);
        rcyCountry.setVisibility(View.VISIBLE);
        globalupdate.setVisibility(View.VISIBLE);
        countrydetails.setVisibility(View.VISIBLE);
        cardView.setVisibility(View.VISIBLE);
    }





}
