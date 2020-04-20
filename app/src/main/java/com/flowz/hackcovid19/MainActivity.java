package com.flowz.hackcovid19;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.flowz.hackcovid19.adapter.CountryAdapter;
import com.flowz.hackcovid19.network.ApiClient;
import com.flowz.hackcovid19.network.ApiInterface;
import com.flowz.hackcovid19.pojoClasses.Countries;
import com.flowz.hackcovid19.pojoClasses.Summary;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    Countries couDetail;

    RecyclerView rcyCountry;

    TextView newConfirmed, newDeaths, newRecovered, totalConfirmed, totalDeaths, totalRecovered;
    private Object Context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity1_main);

        rcyCountry = findViewById(R.id.ryc_country);

       // rcyCountry.setLayoutManager(new LinearLayoutManager(this));
        rcyCountry.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        newConfirmed = findViewById(R.id.newConfirmedNum);
        newDeaths = findViewById(R.id.newDeathsNum);
        newRecovered = findViewById(R.id.newRecoveredNum);
        totalConfirmed = findViewById(R.id.totalConfirmedNum);
        totalDeaths = findViewById(R.id.totalDeathsNum);
        totalRecovered = findViewById(R.id.totalRecoveredNum);

        getDataforCountryCode("CountryCode");
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




//
//
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

//                    text1.append("\n New Confirmed :" + data +
//                                 "\n TotalConfirmed :" + data5
//                                 +"\n NewDeaths :" + data1
//                                 +"\n TotalDeaths :" + data3
//                                 +"\n NewRecovered :" + data2
//                                 +"\n TotalRecovered :" + data4
//                    );


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
    }

}
