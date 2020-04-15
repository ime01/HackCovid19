package com.flowz.hackcovid19;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.flowz.hackcovid19.network.ApiClient;
import com.flowz.hackcovid19.network.ApiInterface;
import com.flowz.hackcovid19.pojoClasses.Countries;
import com.flowz.hackcovid19.pojoClasses.Summary;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    Countries couDetail;

    TextView text1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1 = findViewById(R.id.text1);

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
//                    int data = fetchedCovidData.getGlobal().getNewConfirmed();
//
//                    int data1 = fetchedCovidData.getGlobal().getNewDeaths();
//
//                    int data5 = fetchedCovidData.getGlobal().getTotalConfirmed();
//
//                    int data2 = fetchedCovidData.getGlobal().getNewRecovered();
//
//                    int data3 = fetchedCovidData.getGlobal().getTotalDeaths();
//
//                    int data4 = fetchedCovidData.getGlobal().getTotalRecovered();



                    List<Countries> country = fetchedCovidData.getCountries();


                    String data1 = country.get(20).getCountry();
                    String data2 = country.get(20).getCountryCode();
                    String data3 = country.get(20).getSlug();
                    String data4 = String.valueOf(country.get(20).getNewConfirmed());
                    String data5 = String.valueOf(country.get(20).getNewDeaths());
                    String data6 = String.valueOf(country.get(20).getTotalDeaths());
                    String data7 = String.valueOf(country.get(20).getNewRecovered());
                    String data8 = String.valueOf(country.get(20).getTotalRecovered());
                    String data9 = country.get(20).getDate();

                    text1.append("\n Country :" + data1 +
                                 "\n CountryCode :" + data2
                                 +"\n Slug :" + data3
                                 +"\n NewConfirmed :" + data4
                                 +"\n NewDeaths :" + data5
                                 +"\n TotalDeaths :" + data6 +
                                 "\n NewRecovered :" + data7
                                 +"\n TotalRecovered :" + data8
                                 +"\n Date :" + data9
                    );




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

}
