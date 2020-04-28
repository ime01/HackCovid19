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

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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

import java.util.ArrayList;
import java.util.HashMap;
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
        setContentView(R.layout.activity2_main);

        rcyCountry = findViewById(R.id.ryc_country);
        globalupdate = findViewById(R.id.global_update);
        countrydetails = findViewById(R.id.country_details);
        cardView = findViewById(R.id.cardView);

        rcyCountry.setVisibility(View.INVISIBLE);
        globalupdate.setVisibility(View.INVISIBLE);
        countrydetails.setVisibility(View.INVISIBLE);
        cardView.setVisibility(View.GONE);


        final LinearLayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        rcyCountry.setLayoutManager(layoutManager);

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

    public void callNCDCbyState() {
        String [] listOfState = {"CALL THE NCDC NOW","Abia State","Adamawa State","Akwa Ibom State","Anambra State","Bauchi State", "Bayelsa State","Benue State","Borno State","Cross River State","Delta State",
                "Ebonyi State","Edo State","Ekiti State","Enugu State","Gombe State", "Imo State","Jigawa State","Kaduna State","Kano State","Katsina State",
                "Kebbi State","Kogi State","Kwara State","Lagos State","Nasarawa State", "Niger State","Ogun State","Ondo State","Osun State","Oyo State",
                "Plateau State","Rivers State","Sokoto State","Taraba State","Yobe State","Zamfara State","Federal Capital Territory"
        };

        final int listSize= listOfState.length-1;

        final ArrayList<String> contactsOfNCDCbyState = new ArrayList<>(36);

        contactsOfNCDCbyState.add("07002242362");
        contactsOfNCDCbyState.add("08031230359");
        contactsOfNCDCbyState.add("08189411111");
        contactsOfNCDCbyState.add("09034728047");
        contactsOfNCDCbyState.add("08023909309");
        contactsOfNCDCbyState.add("08039216821");
        contactsOfNCDCbyState.add("09018602439");
        contactsOfNCDCbyState.add("080099999999");
        contactsOfNCDCbyState.add("07035371180");
        contactsOfNCDCbyState.add("08033521961");
        contactsOfNCDCbyState.add("09020332489");
        contactsOfNCDCbyState.add("08084096723");
        contactsOfNCDCbyState.add("09062970434");
        contactsOfNCDCbyState.add("08182555550");
        contactsOfNCDCbyState.add("08103371257");
        contactsOfNCDCbyState.add("08099555577");
        contactsOfNCDCbyState.add("08068725224");
        contactsOfNCDCbyState.add("08035871662");
        contactsOfNCDCbyState.add("08039704476");
        contactsOfNCDCbyState.add("09035037114");
        contactsOfNCDCbyState.add("07046352309");
        contactsOfNCDCbyState.add("07088292249");
        contactsOfNCDCbyState.add("09062010001");
        contactsOfNCDCbyState.add("08023169485");
        contactsOfNCDCbyState.add("08036018579");
        contactsOfNCDCbyState.add("09010999909");
        contactsOfNCDCbyState.add("08001235678");
        contactsOfNCDCbyState.add("07002684319");
        contactsOfNCDCbyState.add("08035025692");
        contactsOfNCDCbyState.add("08095394000");
        contactsOfNCDCbyState.add("07032864444");
        contactsOfNCDCbyState.add("08056109538");
        contactsOfNCDCbyState.add("08032311116");
        contactsOfNCDCbyState.add("08065508675");
        contactsOfNCDCbyState.add("08131834764");
        contactsOfNCDCbyState.add("08035626731");
        contactsOfNCDCbyState.add("08031230508");


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 1:
                        dialNCDCnumber(contactsOfNCDCbyState.get(0));
                        break;
                    case 2:
                        dialNCDCnumber(contactsOfNCDCbyState.get(1));
                        break;
                    case 3:
                        dialNCDCnumber(contactsOfNCDCbyState.get(2));
                        break;
                    case 4:
                        dialNCDCnumber(contactsOfNCDCbyState.get(3));
                        break;
                    case 5:
                        dialNCDCnumber(contactsOfNCDCbyState.get(4));
                        break;
                    case 6:
                        dialNCDCnumber(contactsOfNCDCbyState.get(5));
                        break;
                    case 7:
                        dialNCDCnumber(contactsOfNCDCbyState.get(6));
                        break;
                    case 8:
                        dialNCDCnumber(contactsOfNCDCbyState.get(7));
                        break;
                    case 9:
                        dialNCDCnumber(contactsOfNCDCbyState.get(8));
                        break;
                    case 10:
                        dialNCDCnumber(contactsOfNCDCbyState.get(9));
                        break;
                    case 11:
                        dialNCDCnumber(contactsOfNCDCbyState.get(10));
                        break;
                    case 12:
                        dialNCDCnumber(contactsOfNCDCbyState.get(11));
                        break;
                    case 13:
                        dialNCDCnumber(contactsOfNCDCbyState.get(12));
                        break;
                    case 14:
                        dialNCDCnumber(contactsOfNCDCbyState.get(13));
                        break;
                    case 15:
                        dialNCDCnumber(contactsOfNCDCbyState.get(14));
                        break;
                    case 16:
                        dialNCDCnumber(contactsOfNCDCbyState.get(15));
                        break;
                    case 17:
                        dialNCDCnumber(contactsOfNCDCbyState.get(16));
                        break;
                    case 18:
                        dialNCDCnumber(contactsOfNCDCbyState.get(17));
                        break;
                    case 19:
                        dialNCDCnumber(contactsOfNCDCbyState.get(18));
                        break;
                    case 20:
                        dialNCDCnumber(contactsOfNCDCbyState.get(19));
                        break;
                    case 21:
                        dialNCDCnumber(contactsOfNCDCbyState.get(20));
                        break;
                    case 22:
                        dialNCDCnumber(contactsOfNCDCbyState.get(21));
                        break;
                    case 23:
                        dialNCDCnumber(contactsOfNCDCbyState.get(22));
                        break;
                    case 24:
                        dialNCDCnumber(contactsOfNCDCbyState.get(23));
                        break;
                    case 25:
                        dialNCDCnumber(contactsOfNCDCbyState.get(24));
                        break;
                    case 26:
                        dialNCDCnumber(contactsOfNCDCbyState.get(25));
                        break;
                    case 27:
                        dialNCDCnumber(contactsOfNCDCbyState.get(26));
                        break;
                    case 28:
                        dialNCDCnumber(contactsOfNCDCbyState.get(27));
                        break;
                    case 29:
                        dialNCDCnumber(contactsOfNCDCbyState.get(28));
                        break;
                    case 30:
                        dialNCDCnumber(contactsOfNCDCbyState.get(29));
                        break;
                    case 31:
                        dialNCDCnumber(contactsOfNCDCbyState.get(30));
                        break;
                    case 32:
                        dialNCDCnumber(contactsOfNCDCbyState.get(31));
                        break;
                    case 33:
                        dialNCDCnumber(contactsOfNCDCbyState.get(32));
                        break;
                    case 34:
                        dialNCDCnumber(contactsOfNCDCbyState.get(33));
                        break;
                    case 35:
                        dialNCDCnumber(contactsOfNCDCbyState.get(34));
                        break;
                    case 36:
                        dialNCDCnumber(contactsOfNCDCbyState.get(35));
                        break;
                    case 37:
                        dialNCDCnumber(contactsOfNCDCbyState.get(36));
                        break;
                }
            }

            private void dialNCDCnumber(String contactNumber) {
                Intent callNcdc = new Intent(Intent.ACTION_DIAL);
                callNcdc.setData(Uri.parse("tel:" + contactNumber));
                startActivity(callNcdc);
                return;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

//        HashMap myMap = new HashMap();
//        myMap.put("Abia", 07067624441);
//        myMap.put("Akwa Ibom", 07098624451);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, listOfState);
        spinner.setAdapter(adapter);
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
