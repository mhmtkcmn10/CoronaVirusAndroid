package com.example.coronaapivirus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CasesByCountryActivity extends AppCompatActivity implements CasesByCountryReq.CasesByCountryListener {

    TextView country_name;
    TextView cases;
    TextView deaths;
    TextView region;
    TextView total_recovered;
    TextView new_deaths;
    TextView new_cases;
    TextView serious_critical;
    TextView active_cases;
    TextView total_cases_per_1m_population;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cases_by_country);
        country_name=findViewById(R.id.tvcountryname);
        cases=findViewById(R.id.tv_cases);
        deaths=findViewById(R.id.tv_deaths);
        //region=findViewById(R.id.tv_region);    data da boş olduğu için listelenmedi
        total_recovered=findViewById(R.id.tv_totalrecovered);
        new_deaths=findViewById(R.id.tv_newdeaths);
        new_cases=findViewById(R.id.tv_newcases);
        serious_critical=findViewById(R.id.tv_serious_critical);
        active_cases=findViewById(R.id.tv_active_cases);
        total_cases_per_1m_population=findViewById(R.id.tv_total_cases_per_1m_population);

        CasesByCountryReq acr=new CasesByCountryReq(this);
        acr.execute();

    }

    @Override
    public void casesByCountryReqDone(String result) {

        Gson gson=new Gson();
        CountriesDetay model=gson.fromJson(result,CountriesDetay.class);

        Intent intent=getIntent();
        Bundle bundle = intent.getExtras();

        if(bundle != null){

            String post=bundle.getString("position");

            // int post=bundle.getInt("data");
            Log.d("posti",""+post);
            country_name.setText(model.countries_stat[Integer.parseInt(post)].country_name);
            cases.setText(model.countries_stat[Integer.parseInt(post)].cases);
            deaths.setText(model.countries_stat[Integer.parseInt(post)].deaths);
            //region.setText(model.countries_stat[Integer.parseInt(post)].region);
            total_recovered.setText(model.countries_stat[Integer.parseInt(post)].total_recovered);
            new_deaths.setText(model.countries_stat[Integer.parseInt(post)].new_deaths);
            new_cases.setText(model.countries_stat[Integer.parseInt(post)].new_cases);
            serious_critical.setText(model.countries_stat[Integer.parseInt(post)].serious_critical);
            active_cases.setText(model.countries_stat[Integer.parseInt(post)].active_cases);
            total_cases_per_1m_population.setText(model.countries_stat[Integer.parseInt(post)].total_cases_per_1m_population);

        }
    }
}
