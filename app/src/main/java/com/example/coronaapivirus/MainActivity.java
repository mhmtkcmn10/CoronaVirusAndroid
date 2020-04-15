package com.example.coronaapivirus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity implements WorldStatReq.WorldStatReqListener{

    TextView tvCases;
    TextView tvDeaths;
    TextView tvRecovered;
    TextView tvNewCases;
    TextView tvNewDeaths;
    TextView tvStatistic;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvCases = findViewById(R.id.tvcases);
        tvDeaths = findViewById(R.id.tvdeaths);
        tvRecovered = findViewById(R.id.tvrecovered);
        tvNewCases = findViewById(R.id.tvnewcases);
        tvNewDeaths = findViewById(R.id.tvnewdeaths);
        tvStatistic = findViewById(R.id.tvstatistic);
        btn=findViewById(R.id.btnTikla);


        WorldStatReq req=new WorldStatReq(this);
        req.execute();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity.this,AffectedCountriesActivity.class);
                startActivity(intent);

            }
        });
    }

    @Override
    public void worldStatReqDone(String result) {

        Gson gson = new Gson();
        WorldStatModel model = gson.fromJson(result, WorldStatModel.class);

        tvCases.setText(model.total_cases);
        tvDeaths.setText(model.total_deaths);
        tvRecovered.setText(model.total_recovered);
        tvNewCases.setText(model.new_cases);
        tvNewDeaths.setText(model.new_deaths);
        tvStatistic.setText(model.statistic_taken_at);
    }
}
