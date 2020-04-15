package com.example.coronaapi;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolderWorldStat extends RecyclerView.ViewHolder  {

    public TextView tvcases;
    public TextView tvdeaths;
    public TextView tvrecovered;
    public TextView tvnewcases;
    public TextView tvnewdeaths;
    public TextView tvstatistic;

    public ViewHolderWorldStat(@NonNull View itemView) {
        super(itemView);

        tvcases = itemView.findViewById(R.id.tvCases);
        tvdeaths = itemView.findViewById(R.id.tvDeaths);
        tvrecovered = itemView.findViewById(R.id.tvRecovered);
        tvnewcases = itemView.findViewById(R.id.tvNewCases);
        tvnewdeaths = itemView.findViewById(R.id.tvNewDeaths);
        tvstatistic = itemView.findViewById(R.id.tvStatistic);
    }
}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             