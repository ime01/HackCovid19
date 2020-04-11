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
import com.flowz.hackcovid19.PojoClasses.Countries;
import com.flowz.hackcovid19.PojoClasses.Summary;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView text1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1 = findViewById(R.id.text1);


        ApiInterface retrofitInterface = ApiClient.getApiClent().create(ApiInterface.class);

        Call<Summary> summaryCall = retrofitInterface.getSummary();

        summaryCall.enqueue(new Callback<Summary>() {
            @Override
            public void onResponse(Call<Summary> call, Response<Summary> response) {
                if (response.isSuccessful()){

                    Summary fetchedCovidData = response.body();

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


                    //String countriesData = fetchedCovidData.getCountries().toString();


                    List<Countries> country = fetchedCovidData.getCountries();


//                    for (Countries countries: country) {
//
//                         String dataContent = "";
//
//                        dataContent += "Countries" + countriesData.
//
//                    }

//                    text1.append("\n New Confirmed :" + data +
//                                 "\n TotalConfirmed :" + data5
//                                 +"\n NewDeaths :" + data1
//                                 +"\n TotalDeaths :" + data3
//                                 +"\n NewRecovered :" + data2
//                                 +"\n TotalRecovered :" + data4
//
//                    );

                    text1.append("\n"+ country);


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
