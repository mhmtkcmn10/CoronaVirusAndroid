package com.example.coronaapivirus;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.List;

public class AffectedCountriesReq extends BaseReq {
    public AffectedCountriesReq.AffectedCountriesListener listener;

    public interface AffectedCountriesListener {
        void affectedCountriesReqDone(String result);
    }

    public AffectedCountriesReq(AffectedCountriesReq.AffectedCountriesListener listener) {
        this.listener = listener;
    }

    @Override
    public String getReqUrl() {
        return "https://coronavirus-monitor.p.rapidapi.com/coronavirus/affected.php?rapidapi-key=b296fcbc2dmsh6bfe7d8930db773p1e098ajsnf3c04b17ca0e";
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        listener.affectedCountriesReqDone(result);
    }
}