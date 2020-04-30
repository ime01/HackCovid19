package com.flowz.hackcovid19.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.flowz.hackcovid19.R;
import com.flowz.hackcovid19.pojoClasses.Countries;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> {

    List<Countries> countries;
    Context context;

    public CountryAdapter(List<Countries> countries, Context context) {
        this.countries = countries;
        this.context = context;
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.country_detail_model2, parent, false);

        return new CountryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {

        String nc = String.valueOf(countries.get(position).getNewConfirmed());
      String nd = String.valueOf(countries.get(position).getNewDeaths());
      String nr = String.valueOf(countries.get(position).getNewRecovered());
      String tc = String.valueOf(countries.get(position).getTotalConfirmed());
      String td = String.valueOf(countries.get(position).getTotalDeaths());
      String tr = String.valueOf(countries.get(position).getTotalRecovered());

      holder.country.setText(countries.get(position).getCountry());
      holder.newConfirmed.setText(nc);
      holder.newDeaths.setText(nd);
      holder.newRecovered.setText(nr);
      holder.totalConfirmed.setText(tc);
      holder.totalDeaths.setText(td);
      holder.totalRecovered.setText(tr);
      holder.date.setText(countries.get(position).getDate());

    }

    @Override
    public int getItemCount() {
        return countries.size();
    }

    public class CountryViewHolder extends RecyclerView.ViewHolder {
        TextView newConfirmed, newDeaths,newRecovered,totalConfirmed,totalDeaths,totalRecovered, country, date;

        public CountryViewHolder(@NonNull View itemView) {
            super(itemView);
            newConfirmed = itemView.findViewById(R.id.nc_num);
            newDeaths = itemView.findViewById(R.id.nd_num);
            newRecovered = itemView.findViewById(R.id.nr_num);
            totalConfirmed = itemView.findViewById(R.id.tc_num);
            totalDeaths = itemView.findViewById(R.id.td_num);
            totalRecovered = itemView.findViewById(R.id.tr_num);
            country = itemView.findViewById(R.id.country);
            date = itemView.findViewById(R.id.date);
        }
    }
}
