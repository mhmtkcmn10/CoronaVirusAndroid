package com.example.coronaapivirus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AffectedCountriesActivity extends AppCompatActivity implements AffectedCountriesReq.AffectedCountriesListener{
    ListView listView;
    /*public String[] ulke ={

            "Türkiye" ,"ABD","Almanya","Rusya","Çin","Fransa"
    };*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affected_countries);

        listView=findViewById(R.id.listView);
        AffectedCountriesReq acr=new AffectedCountriesReq(this);
        acr.execute();
    }
    @Override
    public void affectedCountriesReqDone(String result) {
        Gson gson=new Gson();
        AffectedCountriesModel afModel=gson.fromJson(result,AffectedCountriesModel.class);

        final ArrayList<String> data=new ArrayList<>();
        for (int i=0;i<afModel.affected_countries.length;i++){
            data.add(afModel.affected_countries[i]);
        }

        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,R.layout.list_item,R.id.list_textview,data);

        /*Comparator<String> ALPHABETICAL_ORDER1 = new Comparator<String>() {
            public int compare(String object1, String object2) {
                int res = String.CASE_INSENSITIVE_ORDER.compare(object1.toString(), object2.toString());
                return res;
            }
        };

        Collections.sort(data, ALPHABETICAL_ORDER1);*/



        if (listView!=null){

            listView.setAdapter(adapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(final AdapterView<?> parent, View view, final int position, long id) {

                    Log.d("ulkepost",""+position);
                    Intent intent=new Intent(AffectedCountriesActivity.this,CasesByCountryActivity.class);
                     Bundle bundle = new Bundle();
                    bundle.putString("position",""+position);
                    intent.putExtras(bundle);
                    startActivity(intent);

                }
            });





            /*listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                   /* Toast.makeText(getApplicationContext(),
                            "Seçilen Data İsmi: " + data.get(position),
                            Toast.LENGTH_SHORT).show();*/


                   /* Bundle bundle = new Bundle();
                    bundle.getString("position",""+position);
                    Intent intent=new Intent(AffectedCountriesActivity.this,CasesByCountryActivity.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            });*/


        }



    }
}

